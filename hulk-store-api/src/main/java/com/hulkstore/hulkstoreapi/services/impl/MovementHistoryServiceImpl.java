package com.hulkstore.hulkstoreapi.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulkstore.hulkstoreapi.constants.HulkStoreConstants;
import com.hulkstore.hulkstoreapi.dtos.MovementActionDTO;
import com.hulkstore.hulkstoreapi.entities.MovementHistory;
import com.hulkstore.hulkstoreapi.entities.Product;
import com.hulkstore.hulkstoreapi.exceptions.HulkStoreException;
import com.hulkstore.hulkstoreapi.exceptions.InternalServerErrorException;
import com.hulkstore.hulkstoreapi.exceptions.NotFoundException;
import com.hulkstore.hulkstoreapi.jsons.MovementActionRest;
import com.hulkstore.hulkstoreapi.repositories.MovementHistoryRepository;
import com.hulkstore.hulkstoreapi.repositories.MovementTypeRepository;
import com.hulkstore.hulkstoreapi.repositories.ProductRepository;
import com.hulkstore.hulkstoreapi.repositories.UserRepository;
import com.hulkstore.hulkstoreapi.services.MovementHistoryService;

@Service
public class MovementHistoryServiceImpl implements MovementHistoryService {

	@Autowired
	MovementHistoryRepository movementHistoryRepository;

	@Autowired
	MovementTypeRepository movementTypeRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;

	public String addMovement(MovementActionRest movementActionRest) throws HulkStoreException {

		MovementHistory movementHistory = new MovementHistory();
		Product product = productRepository.findById(movementActionRest.getProductId())
				.orElseThrow(() -> new NotFoundException("PRODUCT_NOT_FOUND", "PRODUCT_NOT_FOUND"));

		if (product == null) {
			throw new NotFoundException("PRODUCT_NOT_FOUND", "PRODUCT_NOT_FOUND");
		}
		
		if((movementActionRest.getMovementTypeId() == HulkStoreConstants.ACTION_OUTPUT_ID) && (product.getCantStock() - movementActionRest.getCant()) <= 0) {
			throw new NotFoundException("ACTION_IS_NOT_ALLOWED", "ACTION_IS_NOT_ALLOWED");
		}

		movementHistory.setCant(movementActionRest.getCant());
		movementHistory.setUnitCost(movementActionRest.getUnitCost());
		movementHistory.setTotalCost((movementActionRest.getTotalCost() == null)
				? (movementActionRest.getCant() * movementActionRest.getUnitCost())
				: movementActionRest.getTotalCost());
		movementHistory.setDate(new Date());
		movementHistory.setUser(userRepository.findById(movementActionRest.getUserId())
				.orElseThrow(() -> new NotFoundException("USER_NOT_FOUND", "USER_NOT_FOUND")));
		movementHistory.setMovementType(movementTypeRepository.findById(movementActionRest.getMovementTypeId())
				.orElseThrow(() -> new NotFoundException("MOVEMENT_TYPE_NOT_FOUND", "MOVEMENT_TYPE_NOT_FOUND")));
		movementHistory.setProduct(product);
		
		try {
			movementHistoryRepository.save(movementHistory);
		} catch (final Exception e) {
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}

		return "MOVEMENT_ADDED";
	}
	
	public void addFirstMovement(MovementActionDTO movementActionDTO) throws HulkStoreException {

		MovementHistory movementHistory = new MovementHistory();

		movementHistory.setCant(movementActionDTO.getCant());
		movementHistory.setUnitCost(movementActionDTO.getCurrentCost());
		movementHistory.setTotalCost(movementActionDTO.getTotalCost());
		movementHistory.setDate(new Date());
		movementHistory.setUser(userRepository.findById(movementActionDTO.getUserId())
				.orElseThrow(() -> new NotFoundException("USER_NOT_FOUND", "USER_NOT_FOUND")));
		movementHistory.setMovementType(movementTypeRepository.findById(movementActionDTO.getMovementTypeId())
				.orElseThrow(() -> new NotFoundException("MOVEMENT_TYPE_NOT_FOUND", "MOVEMENT_TYPE_NOT_FOUND")));
		movementHistory.setProduct(productRepository.findById(movementActionDTO.getProductId())
				.orElseThrow(() -> new NotFoundException("PRODUCT_NOT_FOUND", "PRODUCT_NOT_FOUND")));
		
		try {
			movementHistoryRepository.save(movementHistory);
		} catch (final Exception e) {
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
	}
}
