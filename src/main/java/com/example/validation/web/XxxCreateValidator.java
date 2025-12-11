package com.example.validation.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.validation.service.YyyService;

@Component
public class XxxCreateValidator implements Validator {

	private final YyyService yyyService;

	public XxxCreateValidator(YyyService yyyService) {
		this.yyyService = yyyService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return XxxCreateRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		XxxCreateRequest request = (XxxCreateRequest) target;

		// Falls Bean Validation (@NotNull) bereits angeschlagen hat,
		// müssen wir nicht weiter prüfen.
		if (errors.hasFieldErrors("yyyId")) {
			return;
		}

		Long yyyId = request.getYyyId();
		if (yyyId != null && !yyyService.existsById(yyyId)) {
			errors.rejectValue("yyyId", "yyy.notFound", "Yyy with id " + yyyId + " does not exist");
		}
	}
}
