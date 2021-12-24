package com.hulkstore.hulkstoreapi.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulkstore.hulkstoreapi.entities.Product;
import com.hulkstore.hulkstoreapi.exceptions.HulkStoreException;
import com.hulkstore.hulkstoreapi.exceptions.NotFoundException;
import com.hulkstore.hulkstoreapi.jsons.ProductUpdateRest;
import com.hulkstore.hulkstoreapi.jsons.ProductCreateRest;
import com.hulkstore.hulkstoreapi.jsons.ProductRest;
import com.hulkstore.hulkstoreapi.repositories.ProductRepository;
import com.hulkstore.hulkstoreapi.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{


	@Autowired
	ProductRepository productRepository;
	
	public static final ModelMapper modelMapper = new ModelMapper();
	
	public ProductRest getProductByid(Long productId) throws HulkStoreException {
		
		return modelMapper.map(getProductEntity(productId), ProductRest.class);
	}
	
	private Product getProductEntity(Long productId) throws HulkStoreException {
		return productRepository.findById(productId).orElseThrow(() -> new NotFoundException("PRODUCT_NOT_FOUND", "PRODUCT_NOT_FOUND"));
	}

	public String createProduct(ProductCreateRest productRest) throws HulkStoreException {

		if (productRepository.findByName(productRest.getName()).isPresent()) {
			throw new NotFoundException("PRODUCT_ALREADY_EXIST", "PRODUCT_ALREADY_EXIST");
		}
		
		return null;
	}

	@Override
	public String updateProduct(ProductUpdateRest productRest) throws HulkStoreException {
		// TODO Auto-generated method stub
		return null;
	}

}
