package com.mftvanak.classes.jee.zero.dao;

import com.mftvanak.classes.jee.zero.dao.impl.DatabaseUserDao;

public class UserDaoFactory {

	private static UserDao userDao;

	public static UserDao createSingleton() {
		if (userDao == null) {
			System.out.println("INFO Making a user dao ...");
			userDao = new DatabaseUserDao();
		}
		return userDao;
	}
}
