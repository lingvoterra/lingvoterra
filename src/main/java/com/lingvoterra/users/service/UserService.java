package com.lingvoterra.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lingvoterra.users.dao.User;
import com.lingvoterra.users.dao.UserDao;

@Service
public class UserService {

	@Autowired
	@Qualifier("userDao")
	public UserDao userDao;

	public void create(User user) {
		userDao.create(user);
	};

	public User find(int userId) {
		return userDao.find(userId);
	};

	public void delete(int userId) {
		userDao.delete(userId);
	};

	public void update(User user) {
		userDao.update(user);
	};

}
