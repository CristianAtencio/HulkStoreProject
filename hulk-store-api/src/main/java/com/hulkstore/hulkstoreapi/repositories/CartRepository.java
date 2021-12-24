package com.hulkstore.hulkstoreapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulkstore.hulkstoreapi.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

	Optional<List<Cart>> findByUserId(Long userId);
	
}
