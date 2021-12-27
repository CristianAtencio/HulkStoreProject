package com.hulkstore.hulkstoreapi.services;

import com.hulkstore.hulkstoreapi.exceptions.HulkStoreException;
import com.hulkstore.hulkstoreapi.jsons.UserCreateRest;
import com.hulkstore.hulkstoreapi.jsons.UserRest;

public interface UserService {
	
	UserRest getUserById(Long userId) throws HulkStoreException; 
	
	String createUser(UserCreateRest userRest) throws HulkStoreException;

}
