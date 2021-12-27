package com.hulkstore.hulkstoreapi.jsons;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCreateRest {

	@JsonProperty("name")
	@NotBlank(message = "The field name is a String required.")
	private String name;

	@JsonProperty("description")
	@NotBlank(message = "The field description is a String required.")
	private String description;

	@JsonProperty("price")
	@NotNull(message = "The field price is a Long required.")
	private Long price;
	
	@JsonProperty("current_cost")
	@NotNull(message = "The field current_cost is a Long required.")
	private Long currentCost;
	
	@JsonProperty("cant_stock")
	@NotNull(message = "The field cant_stock is a Long required.")
	private Long cantStock;

	@JsonProperty("total_cost")
	private Long totalCost;
	
	@JsonProperty("user_id")
	@NotNull(message = "The field user_id is a Long required.")
	private Long userId;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getCurrentCost() {
		return currentCost;
	}

	public void setCurrentCost(Long currentCost) {
		this.currentCost = currentCost;
	}

	public Long getCantStock() {
		return cantStock;
	}

	public void setCantStock(Long cantStock) {
		this.cantStock = cantStock;
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
