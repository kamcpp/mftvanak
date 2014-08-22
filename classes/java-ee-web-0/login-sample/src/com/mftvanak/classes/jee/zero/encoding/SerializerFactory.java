package com.mftvanak.classes.jee.zero.encoding;

import com.mftvanak.classes.jee.zero.validation.ValidationResult;

public class SerializerFactory {

	public static Serializer<ValidationResult> createForValidationResult() {
		return new DefaultValidationResultSerializer();
	}
}
