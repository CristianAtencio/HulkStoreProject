package com.hulkstore.hulkstoreapi.jsons;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovementActionRest {

	@JsonProperty("product_id")
	@NotNull(message = "The field product_id is a Long required.")
	private Long productId;
	
	@JsonProperty("movement_type_id")
	@NotNull(message = "The field movement_type_id is a Long required.")
	private Long movementTypeId;
	
	@JsonProperty("user_id")
	@NotNull(message = "The field user_id is a Long required.")
	private Long userId;
	
	@JsonProperty("cant")
	@NotNull(message = "The field cant is a Long required.")
	private Long cant;
	
	@JsonProperty("unit_cost")
	@NotNull(message = "The field unit_cost is a Long required.")
	private Long unitCost;
	
	@JsonProperty("total_cost")
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCant() {
		return cant;
	}

	public void setCant(Long cant) {
		this.cant = cant;
	}

	public Long getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Long unitCost) {
		this.unitCost = unitCost;
	}

	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}
}
