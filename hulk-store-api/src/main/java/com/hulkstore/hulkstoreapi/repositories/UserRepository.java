package com.hulkstore.hulkstoreapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulkstore.hulkstoreapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findById(Long id);
	
	Optional<User> findByUsername(String username);
}
