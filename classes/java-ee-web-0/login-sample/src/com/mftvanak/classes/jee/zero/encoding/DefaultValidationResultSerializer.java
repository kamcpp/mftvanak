package com.mftvanak.classes.jee.zero.encoding;

import java.nio.charset.Charset;
import java.util.Map;

import com.mftvanak.classes.jee.zero.validation.ValidationResult;

public class DefaultValidationResultSerializer implements
		Serializer<ValidationResult> {

	@Override
	public byte[] serialize(ValidationResult object) {
		String serialized = "";
		Map<String, String> errors = object.getErrors();
		for (String field : errors.keySet()) {
			String message = errors.get(field);
			serialized += field + "," + message + "#";
		}
		return serialized.getBytes(Charset.forName("UTF-8"));
	}

	@Override
	public ValidationResult deserialize(byte[] objectData) {
		ValidationResult result = new ValidationResult();
		String objectString = new String(objectData, Charset.forName("UTF-8"));
		String[] errorMessages = objectString.split("#");
		for (String errorMessage : errorMessages) {
			if (errorMessage.trim().length() > 0) {
				String[] pair = errorMessage.split(",");
				result.addError(pair[0], pair[1]);
			}
		}
		return result;
	}
}
