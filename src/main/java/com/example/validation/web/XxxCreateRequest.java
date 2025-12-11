package com.example.validation.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class XxxCreateRequest {

	@NotBlank
	private String name;

	@NotNull
	private Long yyyId;

	// --- getters / setters ---

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getYyyId() {
		return yyyId;
	}

	public void setYyyId(Long yyyId) {
		this.yyyId = yyyId;
	}
}
