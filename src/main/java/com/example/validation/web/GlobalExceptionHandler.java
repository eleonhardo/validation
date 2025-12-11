package com.example.validation.web;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.validation.service.XxxNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Bean Validation Fehler (z.B. @Valid)
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail handleValidation(MethodArgumentNotValidException ex) {

		ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
		problem.setTitle("Validation failed");
		problem.setType(URI.create("https://example.com/errors/validation-failed"));
		problem.setDetail("Request validation failed");

		Map<String, List<String>> fieldErrors = new HashMap<>();

		for (FieldError fe : ex.getBindingResult().getFieldErrors()) {
			fieldErrors.computeIfAbsent(fe.getField(), k -> new java.util.ArrayList<>()).add(fe.getDefaultMessage());
		}

		problem.setProperty("errors", fieldErrors);

		return problem;
	}

	/**
	 * Business-Fehler: Resource not found
	 */
	@ExceptionHandler(XxxNotFoundException.class)
	public ProblemDetail handleXxxNotFound(XxxNotFoundException ex) {

		ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
		problem.setTitle("Xxx not found");
		problem.setType(URI.create("https://example.com/errors/xxx-not-found"));
		problem.setDetail(ex.getMessage());

		return problem;
	}

	/**
	 * Generische Fehler (500)
	 */
	@ExceptionHandler(Exception.class)
	public ProblemDetail handleGeneric(Exception ex) {

		ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		problem.setTitle("Internal server error");
		problem.setType(URI.create("https://example.com/errors/internal-server-error"));
		problem.setDetail("Unexpected system error occurred");

		// Für Logging / Monitoring
		ex.printStackTrace();

		return problem;
	}
}
