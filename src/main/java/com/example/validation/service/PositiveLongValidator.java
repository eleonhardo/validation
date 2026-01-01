package com.example.validation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class PositiveLongValidator implements ConstraintValidator<PositiveLong, Long> {

	@Autowired
	private YyyService yyyService;

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		return yyyService.isPositive(value);
	}
}
