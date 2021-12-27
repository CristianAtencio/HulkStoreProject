package com.hulkstore.hulkstoreapi.jsons;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductUpdateRest {
	
	@JsonProperty("name")
	@NotBlank(message = "The field name is a Long required.")
	private String name;

	@JsonProperty("description")
	@NotBlank(message = "The field description is a Long required.")
	private String description;

	@JsonProperty("price")
	@NotNull(message = "The field price is a Long required.")
	private Long price;

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

}
