package com.andersonfb.todoapi.resource.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldsErrorsMessage> errors = new ArrayList<>();

	public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public List<FieldsErrorsMessage> getErrors() {
		return errors;
	}

	public void addError(String field, String messagem) {
		errors.add(new FieldsErrorsMessage(field, messagem));
	}
}
