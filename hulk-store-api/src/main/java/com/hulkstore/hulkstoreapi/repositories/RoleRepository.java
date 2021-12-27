package com.hulkstore.hulkstoreapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulkstore.hulkstoreapi.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Optional<Role> findById(Long id);
	
	Optional<Role> findByName(String name);
}
