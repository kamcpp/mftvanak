package com.mftvanak.classes.jee.zero.dao;

import java.util.List;

import com.mftvanak.classes.jee.zero.domain.User;

public interface UserDao {

	void save(User user);

	void delete(User user);

	void update(User user);

	List<User> getUsers();

	User getUserByUsername(String username);
}
