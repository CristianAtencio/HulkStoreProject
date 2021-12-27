package com.hulkstore.hulkstoreapi.services.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulkstore.hulkstoreapi.constants.HulkStoreConstants;
import com.hulkstore.hulkstoreapi.dtos.MovementActionDTO;
import com.hulkstore.hulkstoreapi.entities.Product;
import com.hulkstore.hulkstoreapi.exceptions.HulkStoreException;
import com.hulkstore.hulkstoreapi.exceptions.InternalServerErrorException;
import com.hulkstore.hulkstoreapi.exceptions.NotFoundException;
import com.hulkstore.hulkstoreapi.jsons.ProductUpdateRest;
import com.hulkstore.hulkstoreapi.jsons.CompleteProductRest;
import com.hulkstore.hulkstoreapi.jsons.ProductCreateRest;
import com.hulkstore.hulkstoreapi.jsons.ProductRest;
import com.hulkstore.hulkstoreapi.repositories.ProductRepository;
import com.hulkstore.hulkstoreapi.repositories.UserRepository;
import com.hulkstore.hulkstoreapi.services.MovementHistoryService;
import com.hulkstore.hulkstoreapi.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	MovementHistoryService movementHistoryService;

	public static final ModelMapper modelMapper = new ModelMapper();

	public ProductRest getProductByid(Long productId) throws HulkStoreException {

		return modelMapper.map(getProductEntity(productId), ProductRest.class);
	}

	public CompleteProductRest getCompleteProductByid(Long productId) throws HulkStoreException {
		return modelMapper.map(getProductEntity(productId), CompleteProductRest.class);
	}

	private Product getProductEntity(Long productId) throws HulkStoreException {
		return productRepository.findById(productId)
				.orElseThrow(() -> new NotFoundException("PRODUCT_NOT_FOUND", "PRODUCT_NOT_FOUND"));
	}

	public String createProduct(ProductCreateRest productRest) throws HulkStoreException {

		if (productRepository.findByName(productRest.getName()).isPresent()) {
			throw new NotFoundException("PRODUCT_ALREADY_EXIST", "PRODUCT_ALREADY_EXIST");
		}

		Product product = new Product();
		product.setName(productRest.getName());
		product.setDescription(productRest.getDescription());
		product.setPrice(productRest.getPrice());
		product.setCantStock(productRest.getCantStock());
		product.setPrice(productRest.getPrice());
		product.setCurrentCost(productRest.getCurrentCost());
		product.setTotalCost(
				(productRest.getTotalCost() == null) ? (productRest.getCantStock() * productRest.getCurrentCost())
						: productRest.getTotalCost());

		product.setUser(userRepository.findById(productRest.getUserId())
				.orElseThrow(() -> new NotFoundException("USER_NOT_FOUND", "USER_NOT_FOUND")));
		product.setDateCreated(new Date());
		product.setDateUpdated(new Date());

		try {
			product = productRepository.save(product);

			final MovementActionDTO movementActionDTO = new MovementActionDTO();

			movementActionDTO.setCant(product.getCantStock());
			movementActionDTO.setCurrentCost(product.getCurrentCost());
			movementActionDTO.setTotalCost(product.getTotalCost());
			movementActionDTO.setProductId(product.getId());
			movementActionDTO.setUserId(product.getUser().getId());
			movementActionDTO.setMovementTypeId(HulkStoreConstants.ACTION_INITIAL_BALANCE_ID);

			movementHistoryService.addFirstMovement(movementActionDTO);

		} catch (final Exception e) {
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}

		return "PRODUCT_CREATED - ID : " + product.getId().toString();
	}

	public String updateProduct(Long productId, ProductUpdateRest productRest) throws HulkStoreException {

		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new NotFoundException("PRODUCT_NOT_FOUND", "PRODUCT_NOT_FOUND"));

		if (product == null) {
			throw new NotFoundException("PRODUCT_NOT_FOUND", "PRODUCT_NOT_FOUND");
		}

		product.setName(productRest.getName());
		product.setDescription(productRest.getDescription());
		product.setPrice(productRest.getPrice());
		product.setDateUpdated(new Date());

		try {
			product = productRepository.save(product);
		} catch (final Exception e) {
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}

		return "PRODUCT_UPDATED - ID : " + product.getId().toString();
	}

	public void updateProductByMovement(MovementActionDTO movementActionDTO) throws HulkStoreException {

		Product product = productRepository.findById(movementActionDTO.getProductId())
				.orElseThrow(() -> new NotFoundException("PRODUCT_NOT_FOUND", "PRODUCT_NOT_FOUND"));

		if (product == null) {
			throw new NotFoundException("PRODUCT_NOT_FOUND", "PRODUCT_NOT_FOUND");
		}

		if(movementActionDTO.getMovementTypeId() == HulkStoreConstants.ACTION_INPUT_ID) {
			product.setCantStock(product.getCantStock() + movementActionDTO.getCant());
			product.setCantStock(product.getTotalCost() + movementActionDTO.getTotalCost());
		} else {
			product.setCantStock(product.getCantStock() - movementActionDTO.getCant());
			product.setCantStock(product.getTotalCost() - movementActionDTO.getTotalCost());
		}

		product.setCantStock(product.getTotalCost() / product.getCantStock());
		product.setDateUpdated(new Date());

		try {
			product = productRepository.save(product);
		} catch (final Exception e) {
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}

	}

}
