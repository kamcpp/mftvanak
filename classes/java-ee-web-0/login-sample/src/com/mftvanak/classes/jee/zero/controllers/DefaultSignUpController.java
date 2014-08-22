package com.mftvanak.classes.jee.zero.controllers;

import com.mftvanak.classes.jee.zero.dao.UserDao;
import com.mftvanak.classes.jee.zero.dao.UserDaoFactory;
import com.mftvanak.classes.jee.zero.domain.User;

public class DefaultSignUpController implements SignUpController {

	@Override
	public void signUp(SignUpData data) {
		if (data instanceof DefaultSignUpData) {
			DefaultSignUpData d = (DefaultSignUpData) data;

			User u = new User();
			u.setName(d.getName());
			u.setFamily(d.getFamily());
			u.setPassword(d.getPassword());
			u.setUsername(d.getUsername());

			UserDao userDao = UserDaoFactory.createSingleton();
			userDao.save(u);

		} else {
			throw new RuntimeException(
					"SignUpData implementation is not supported."); // This is
																	// wrong !!!
		}
	}
}
