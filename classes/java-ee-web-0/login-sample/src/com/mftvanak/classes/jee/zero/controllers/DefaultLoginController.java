package com.mftvanak.classes.jee.zero.controllers;

import com.mftvanak.classes.jee.zero.dao.UserDao;
import com.mftvanak.classes.jee.zero.dao.UserDaoFactory;
import com.mftvanak.classes.jee.zero.domain.User;

public class DefaultLoginController implements LoginController {

	@Override
	public boolean login(LoginData data) {
		if (data instanceof DefaultLoginData) {
			DefaultLoginData d = (DefaultLoginData) data;
			UserDao userDao = UserDaoFactory.createSingleton();
			User u = userDao.getUserByUsername(d.getUsername());
			if (u == null) {
				return false;
			}
			return u.getPassword().equals(d.getPassword());
		} else {
			throw new RuntimeException("LoginData implementation not supprted.");
		}
	}
}
