/* implemented by Masoud */ 
package com.mftvanak.classes.jee.zero.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import com.mftvanak.classes.jee.zero.dao.UserDao;
import com.mftvanak.classes.jee.zero.domain.User;

public class FileUserDao implements UserDao {

	private String filePath = "C:\\users.txt";

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,true));) {
			bw.write(userToString(user) + "\n");
			System.out.println("1 user added to file: C:\\users.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		List<User> tempUsers=null;
		tempUsers = getUsers();
		int indx = tempUsers.indexOf(user);
		tempUsers.remove(indx);
		saveAll(tempUsers);

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
		
		

	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> users = null;
		String line = null;
		User user = null;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath));){
			while ((line = br.readLine()) != null){
				user = stringToUser(line);
				users.add(user);
			}
			if (users != null) return users;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		try {
			String line = null;
			User user = null;
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null){
				user = stringToUser(line);
				if (user.getUsername().equals(username)) {
					System.out.println("user \"" + username + "\" was found");
					return user;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private String userToString(User user) {
		String toReturn = user.getName() + "," + user.getFamily() + ","
				+ user.getUsername() + "," + user.getPassword();
		return toReturn;
	}

	private User stringToUser(String userString){
		String[] tokens = userString.split(",");
		User user = new User();
		user.setName(tokens[0]);
		user.setFamily(tokens[1]);
		user.setUsername(tokens[2]);
		user.setPassword(tokens[3]);
		return user;
	}
	
	private void saveAll (List<User> users){
		
	}
}
