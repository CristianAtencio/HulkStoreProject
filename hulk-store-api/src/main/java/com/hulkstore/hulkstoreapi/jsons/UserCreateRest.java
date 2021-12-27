package com.hulkstore.hulkstoreapi.jsons;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCreateRest {

	@JsonProperty("username")
	@NotBlank(message = "The field username is a String required.")
	private String username;
	
	@JsonProperty("name")
	@NotBlank(message = "The field name is a String required.")
	private String name;
	
	@JsonProperty("role_id")
	@NotNull(message = "The field role_id is a Long required.")
	private Long roleId;
	
	@JsonProperty("password")
	@NotBlank(message = "The field password is a String required.")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
