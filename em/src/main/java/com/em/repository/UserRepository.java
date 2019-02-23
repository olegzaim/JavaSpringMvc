package com.em.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.em.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	

}
