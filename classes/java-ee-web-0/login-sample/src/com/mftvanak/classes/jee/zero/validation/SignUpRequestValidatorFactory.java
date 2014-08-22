package com.mftvanak.classes.jee.zero.validation;

public class SignUpRequestValidatorFactory {

	public static SignUpRequestValidator create() {
		return new DefaultSignUpRequestValiator();
	}
}
