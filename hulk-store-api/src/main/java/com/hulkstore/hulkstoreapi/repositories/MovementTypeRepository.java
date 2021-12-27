package com.hulkstore.hulkstoreapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulkstore.hulkstoreapi.entities.MovementType;

@Repository
public interface MovementTypeRepository extends JpaRepository<MovementType, Long>{

	Optional<MovementType> findById(Long id);
}
