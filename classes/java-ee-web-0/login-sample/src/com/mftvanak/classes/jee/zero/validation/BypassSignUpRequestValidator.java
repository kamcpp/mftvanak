package com.mftvanak.classes.jee.zero.validation;

import com.mftvanak.classes.jee.zero.controllers.SignUpData;

public class BypassSignUpRequestValidator implements SignUpRequestValidator {

	public ValidationResult validate(SignUpData data) {
		return new ValidationResult();
	}
}
