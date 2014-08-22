package com.mftvanak.classes.jee.zero.controllers;

public class SignUpControllerFactory {

	public static SignUpController create() {
		return new DefaultSignUpController();
	}
}
