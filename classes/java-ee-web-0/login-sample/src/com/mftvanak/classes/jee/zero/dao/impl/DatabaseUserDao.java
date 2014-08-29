package com.mftvanak.classes.jee.zero.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mftvanak.classes.jee.zero.dao.UserDao;
import com.mftvanak.classes.jee.zero.domain.User;

public class DatabaseUserDao implements UserDao {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void save(User user) {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO user (username, password, name, family) VALUES (?, ?, ?, ?);");) {
			preparedStatement.setObject(1, user.getUsername());
			preparedStatement.setObject(2, user.getPassword());
			preparedStatement.setObject(3, user.getName());
			preparedStatement.setObject(4, user.getFamily());

			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM user WHERE username = ?");
			preparedStatement.setObject(1, username);
			ResultSet results = preparedStatement.executeQuery();
			User toReturn = null;
			while (results.next()) {
				toReturn = new User();
				toReturn.setName(results.getString("name"));
				toReturn.setFamily(results.getString("family"));
				toReturn.setUsername(results.getString("username"));
				toReturn.setPassword(results.getString("password"));
				break;
			}
			return toReturn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://10.10.42.18/testdb",
				"normaluser", "normal12345");
	}
}
