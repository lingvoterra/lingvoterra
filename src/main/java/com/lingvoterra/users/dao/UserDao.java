package com.lingvoterra.users.dao;

public interface UserDao {
	public void create(User user);

	public User find(int userId);

	public void delete(int userId);

	public void update(User user);
}
