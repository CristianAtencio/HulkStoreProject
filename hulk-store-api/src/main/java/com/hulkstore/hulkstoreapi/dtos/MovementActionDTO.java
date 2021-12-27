package com.hulkstore.hulkstoreapi.dtos;

import java.io.Serializable;

public class MovementActionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long productId;
	
	private Long movementTypeId;
	
	private Long userId;
	
	private Long currentCost;
	
	private Long cant;
	
	private Long totalCost;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getMovementTypeId() {
		return movementTypeId;
	}

	public void setMovementTypeId(Long movementTypeId) {
		this.movementTypeId = movementTypeId;
	}

	public Long getCurrentCost() {
		return currentCost;
	}

	public void setCurrentCost(Long currentCost) {
		this.currentCost = currentCost;
	}

	public Long getCant() {
		return cant;
	}

	public void setCant(Long cant) {
		this.cant = cant;
	}

	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
