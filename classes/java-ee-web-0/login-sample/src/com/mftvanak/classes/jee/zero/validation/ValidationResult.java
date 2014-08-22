package com.mftvanak.classes.jee.zero.validation;

import java.util.Hashtable;
import java.util.Map;

public class ValidationResult {

	private Map<String, String> errors;

	public ValidationResult() {
		errors = new Hashtable<String, String>();
	}

	public void addError(String field, String message) {
		errors.put(field, message);
	}

	public String getMessage(String field) {
		return errors.get(field);
	}

	public boolean hasErrorForField(String field) {
		return errors.containsKey(field);
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public boolean hasError() {
		return errors.size() > 0;
	}
}
