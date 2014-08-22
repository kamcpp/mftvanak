package com.mftvanak.classes.jee.zero.dao.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.mftvanak.classes.jee.zero.dao.UserDao;
import com.mftvanak.classes.jee.zero.domain.User;

public class InMemoryUserDao implements UserDao {

	private Hashtable<String, User> users;

	public InMemoryUserDao() {
		users = new Hashtable<String, User>();
	}

	@Override
	public void save(User user) {
		if (!users.containsKey(user.getUsername())) {
			users.put(user.getUsername(), user);
			System.out.println("A new user is added.");
		}
	}

	@Override
	public void delete(User user) {
		users.remove(user.getUsername());
	}

	@Override
	public void update(User user) {
		if (users.containsKey(user.getUsername())) {
			users.put(user.getUsername(), user);
		}
	}

	@Override
	public List<User> getUsers() {
		return new ArrayList<User>(users.values());
	}

	@Override
	public User getUserByUsername(String username) {
		return users.get(username);
	}
}
