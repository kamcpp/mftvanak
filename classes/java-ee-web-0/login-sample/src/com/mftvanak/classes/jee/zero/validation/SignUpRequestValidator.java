package com.mftvanak.classes.jee.zero.validation;

import com.mftvanak.classes.jee.zero.controllers.SignUpData;

public interface SignUpRequestValidator {

	ValidationResult validate(SignUpData data);
	
}
