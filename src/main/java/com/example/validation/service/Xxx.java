package com.example.validation.service;

import jakarta.validation.constraints.NotBlank;

public class Xxx {

	private Long id;

	@NotBlank
	private String name;

	private Long yyyId;

	private Long orderId;

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

	public Long getYyyId() {
		return yyyId;
	}

	public void setYyyId(Long yyyId) {
		this.yyyId = yyyId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
