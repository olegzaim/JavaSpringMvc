package com.em.service;

import java.util.List;

import com.em.model.User;

public interface UserService {

	public User findUserByEmail(String email);
	
	public List<User> getAllUsers();
	
	public User getUser(Integer id);
	
	public void addUser(User user);
	
	public void updateUser(Long id, User user);
	
	public void deleteUser(Long id);

	public User findUserByUsername(String username);
}
