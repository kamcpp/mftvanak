package com.mftvanak.classes.jee.zero.controllers;

public class LoginControllerFactory {

	public static LoginController create() {
		return new DefaultLoginController();
	}
}
