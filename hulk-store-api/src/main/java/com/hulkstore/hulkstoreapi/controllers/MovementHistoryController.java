package com.hulkstore.hulkstoreapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hulkstore.hulkstoreapi.exceptions.HulkStoreException;
import com.hulkstore.hulkstoreapi.jsons.MovementActionRest;
import com.hulkstore.hulkstoreapi.responses.HulkStoreResponse;
import com.hulkstore.hulkstoreapi.services.MovementHistoryService;

@RestController
@RequestMapping(path = "/hulk-store" + "/v1")
public class MovementHistoryController {

	@Autowired
	MovementHistoryService movementHistoryService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "movement-action", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HulkStoreResponse<String> createProduct(@Valid @RequestBody MovementActionRest movementRest)
			throws HulkStoreException {
		return new HulkStoreResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
				movementHistoryService.addMovement(movementRest));
	}
}
