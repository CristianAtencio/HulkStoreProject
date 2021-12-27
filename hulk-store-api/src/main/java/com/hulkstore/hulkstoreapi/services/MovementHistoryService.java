package com.hulkstore.hulkstoreapi.services;

import com.hulkstore.hulkstoreapi.dtos.MovementActionDTO;
import com.hulkstore.hulkstoreapi.exceptions.HulkStoreException;
import com.hulkstore.hulkstoreapi.jsons.MovementActionRest;

public interface MovementHistoryService {

	String addMovement(MovementActionRest movementActionRest) throws HulkStoreException;
	
	void addFirstMovement(MovementActionDTO movementActionDTO) throws HulkStoreException;
}
