package com.hulkstore.hulkstoreapi.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompleteProductRest {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("price")
	private Long price;
	
	@JsonProperty("cant_stock")
	private Long cantStock;
	
	@JsonProperty("current_cost")
	private Long currentCost;
	
	@JsonProperty("total_cost")
	private Long totalCost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getCantStock() {
		return cantStock;
	}

	public void setCantStock(Long cantStock) {
		this.cantStock = cantStock;
	}

	public Long getCurrentCost() {
		return currentCost;
	}

	public void setCurrentCost(Long currentCost) {
		this.currentCost = currentCost;
	}

	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}
}
