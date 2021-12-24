package com.hulkstore.hulkstoreapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hulkstore.hulkstoreapi.entities.MovementHistory;

@Repository
public interface MovementHistoryRepository extends JpaRepository<MovementHistory, Long>{

	Optional<MovementHistory> findById(Long id);

	Optional<List<MovementHistory>> findByProductIdAndUserId(Long productId, Long userId);
	
	Optional<List<MovementHistory>> findByUserIdAndMovementTypeId(Long userId, Long movementTypeId);
	
	Optional<List<MovementHistory>> findByProductIdAndUserIdAndMovementTypeId(Long productId, Long userId, Long movementTypeId);
}
