package com.example.validation.web;

import jakarta.validation.constraints.NotBlank;

public class XxxUpdateRequest {

	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
