package com.mftvanak.classes.jee.zero.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.mftvanak.classes.jee.zero.dao.UserDao;
import com.mftvanak.classes.jee.zero.domain.User;

public class JPAUserDao implements UserDao {

	private EntityManager entityManager;

	public JPAUserDao() {
		entityManager = Persistence.createEntityManagerFactory("unit1")
				.createEntityManager();
	}

	@Override
	public void save(User user) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
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
		try {
			Query q = entityManager
					.createQuery("from User u where u.username = ?");
			q.setParameter(1, username);
			User u = (User) q.getSingleResult();
			return u;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
