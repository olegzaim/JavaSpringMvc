package com.em.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.em.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	

}
