package com.example.validation.web;

import com.example.validation.service.PositiveLong;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class XxxCreateRequest {

	@NotBlank
	private String name;

	@NotNull
	private Long yyyId;

	@PositiveLong
	private Long orderId;

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

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
