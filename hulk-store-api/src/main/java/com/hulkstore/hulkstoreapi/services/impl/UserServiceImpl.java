package com.hulkstore.hulkstoreapi.services.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulkstore.hulkstoreapi.entities.User;
import com.hulkstore.hulkstoreapi.exceptions.HulkStoreException;
import com.hulkstore.hulkstoreapi.exceptions.InternalServerErrorException;
import com.hulkstore.hulkstoreapi.exceptions.NotFoundException;
import com.hulkstore.hulkstoreapi.jsons.UserCreateRest;
import com.hulkstore.hulkstoreapi.jsons.UserRest;
import com.hulkstore.hulkstoreapi.repositories.RoleRepository;
import com.hulkstore.hulkstoreapi.repositories.UserRepository;
import com.hulkstore.hulkstoreapi.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	public static final ModelMapper modelMapper = new ModelMapper();
	
	public String createUser(UserCreateRest userRest) throws HulkStoreException {
		
		if (userRepository.findByUsername(userRest.getUsername()).isPresent()) {
			throw new NotFoundException("USERNAME_ALREADY_EXIST", "USERNAME_ALREADY_EXIST");
		}
		
		User user = new User();
		user.setName(userRest.getName());
		user.setUsername(userRest.getUsername());
		user.setRole(roleRepository.findById(userRest.getRoleId())
				.orElseThrow(() -> new NotFoundException("ROLE_NOT_FOUND", "ROLE_NOT_FOUND")));
		user.setPassword(userRest.getPassword());
		user.setDateCreated(new Date());
		user.setDateUpdated(new Date());
		
		try {
			user = userRepository.save(user);
		} catch (final Exception e) {
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		
		return "USER_CREATED - ID : " + user.getId();
	}

	public UserRest getUserById(Long userId) throws HulkStoreException {
		return modelMapper.map(getUserEntityById(userId), UserRest.class);
	}

	private User getUserEntityById(Long userId) throws HulkStoreException {
		return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("USER_NOT_FOUND", "USER_NOT_FOUND"));
	}
	
	private User getUserEntityByUsername(String username) throws HulkStoreException {
		return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("USER_NOT_FOUND", "USER_NOT_FOUND"));
	}
}
