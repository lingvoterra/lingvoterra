package com.lingvoterra.users.dao;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserDaoImpl implements UserDao {
	/* Get actual class name to be printed on */
	static Logger log = Logger.getLogger(UserDaoImpl.class.getName());

	@Autowired
	@Qualifier("entityManager")
	private EntityManager entitymanager;

	@Override
	public void create(User user) {
		log.info("Creating a new user...");

		entitymanager.getTransaction().begin();
		entitymanager.persist(user);
		entitymanager.getTransaction().commit();

		log.info("A user has been created!");
	}

	@Override
	public User find(int userId) {
		log.info("Starting to find a user...");

		entitymanager.getTransaction().begin();
		User user = entitymanager.find(User.class, userId);
		entitymanager.getTransaction().commit();

		return user;
	}

	@Override
	public void delete(int userId) {
		log.info("Starting to delete a user...");

		entitymanager.getTransaction().begin();
		User user = entitymanager.find(User.class, userId);
		entitymanager.remove(user);
		entitymanager.getTransaction().commit();

		log.info("A user has been deleted!");
	}

	@Override
	public void update(User newUser) {
		log.info("Starting to update a user...");

		entitymanager.getTransaction().begin();
		User user = entitymanager.find(User.class, newUser.getUserId());
		user = newUser;
		entitymanager.getTransaction().commit();

		log.info("A user has been updated!");
	}
}
