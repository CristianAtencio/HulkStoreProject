package com.hulkstore.hulkstoreapi.services;

import com.hulkstore.hulkstoreapi.entities.Role;
import com.hulkstore.hulkstoreapi.exceptions.HulkStoreException;

public interface RoleService {

	Role getRoleById(Long roleId) throws HulkStoreException;
}
