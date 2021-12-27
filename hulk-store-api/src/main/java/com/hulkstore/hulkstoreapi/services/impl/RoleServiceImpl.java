package com.hulkstore.hulkstoreapi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hulkstore.hulkstoreapi.entities.Role;
import com.hulkstore.hulkstoreapi.exceptions.HulkStoreException;
import com.hulkstore.hulkstoreapi.exceptions.NotFoundException;
import com.hulkstore.hulkstoreapi.repositories.RoleRepository;
import com.hulkstore.hulkstoreapi.services.RoleService;

public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	public Role getRoleById(Long roleId) throws HulkStoreException {
		return roleRepository.findById(roleId).orElseThrow(() -> new NotFoundException("ROLE_NOT_FOUND", "ROLE_NOT_FOUND"));
	}

}
