package com.hulkstore.hulkstoreapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hulkstore.hulkstoreapi.exceptions.HulkStoreException;
import com.hulkstore.hulkstoreapi.jsons.UserCreateRest;
import com.hulkstore.hulkstoreapi.jsons.UserRest;
import com.hulkstore.hulkstoreapi.responses.HulkStoreResponse;
import com.hulkstore.hulkstoreapi.services.UserService;

@RestController
@RequestMapping(path = "/hulk-store" + "/v1")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "user" + "/{" + "userId"
			+ "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HulkStoreResponse<UserRest> getUserById(@PathVariable Long userId) throws HulkStoreException{
		return new HulkStoreResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
				userService.getUserById(userId));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public HulkStoreResponse<String> createUser(@Valid @RequestBody UserCreateRest userRest) throws HulkStoreException{
		return new HulkStoreResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
				userService.createUser(userRest));
	}
}
