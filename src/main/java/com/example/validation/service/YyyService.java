package com.example.validation.service;

import org.springframework.stereotype.Service;

@Service
public class YyyService {

	public boolean existsById(Long id) {
		return id.longValue() > 10;
	}

	public boolean isPositive(Long value) {
		if (value == null) {
			return true;
		}
		return value.longValue() > 0;
	}
}
