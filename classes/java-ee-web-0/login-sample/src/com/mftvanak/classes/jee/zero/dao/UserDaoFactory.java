package com.mftvanak.classes.jee.zero.dao;

import com.mftvanak.classes.jee.zero.dao.impl.JPAUserDao;

public class UserDaoFactory {

	private static UserDao userDao;

	public static UserDao createSingleton() {
		if (userDao == null) {
			System.out.println("INFO Making a user dao ...");
			userDao = new JPAUserDao();
		}
		return userDao;
	}
}
