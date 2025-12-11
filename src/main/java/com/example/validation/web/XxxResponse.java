package com.example.validation.web;

import org.springframework.hateoas.RepresentationModel;

public class XxxResponse extends RepresentationModel<XxxResponse> {

	private Long id;
	private String name;
	private Long yyyId;

	// --- getters / setters ---

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
}
