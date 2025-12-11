package com.example.validation.service;

public class XxxNotFoundException extends RuntimeException {
	public XxxNotFoundException(Long id) {
		super("Xxx with id " + id + " not found");
	}
}
