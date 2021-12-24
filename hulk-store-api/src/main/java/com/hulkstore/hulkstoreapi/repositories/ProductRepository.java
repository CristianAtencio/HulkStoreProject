package com.hulkstore.hulkstoreapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hulkstore.hulkstoreapi.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Optional<Product> findById(Long id);
	
	Optional<Product> findByName(String name);
	
	@Query("SELECT PRO FROM Product PRO WHERE cantStock > 0")
	public List<Product> findRestaurants();
}
