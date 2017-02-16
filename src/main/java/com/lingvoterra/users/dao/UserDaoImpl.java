package com.lingvoterra.users.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserDaoImpl implements UserDao {

	@Autowired
	@Qualifier("entityManager")
	private EntityManager entitymanager;

	@Override
	public void create(User user) {
		entitymanager.getTransaction().begin();
		entitymanager.persist(user);
		entitymanager.getTransaction().commit();
	}

	@Override
	public User find(int userId) {
		entitymanager.getTransaction().begin();
		User user = entitymanager.find(User.class, userId);
		entitymanager.getTransaction().commit();

		return user;
	}

	@Override
	public void delete(int userId) {
		entitymanager.getTransaction().begin();
		User user = entitymanager.find(User.class, userId);
		entitymanager.remove(user);
		entitymanager.getTransaction().commit();
	}

	@Override
	public void update(User newUser) {
		entitymanager.getTransaction().begin();
		User user = entitymanager.find(User.class, newUser.getUserId());
		user = newUser;
		entitymanager.getTransaction().commit();
	}
}
