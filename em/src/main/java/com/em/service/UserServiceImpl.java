package com.em.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.RedirectUrlBuilder;
import org.springframework.stereotype.Service;

import com.em.model.Role;
import com.em.model.User;
import com.em.model.UserRole;
import com.em.repository.RoleRepository;
import com.em.repository.UserRepository;
import com.em.repository.UserRoleRepository;

@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}

	public void addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		user.setRole(new ArrayList<>(roleRepository.findAll()));
		userRepository.save(user);
	}

	public void updateUser(Long id, User user) {
		userRepository.save(user);
	}
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	
	
}
