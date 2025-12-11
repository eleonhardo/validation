package com.example.validation.service;

import org.springframework.stereotype.Service;

@Service
public class YyyService {

	public boolean existsById(Long id) {
		return id.longValue() > 10;
	}
}
