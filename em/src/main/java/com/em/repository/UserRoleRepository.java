package com.em.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.em.model.Role;
import com.em.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	 UserRole findByRoleId(int role);
	 
	 UserRole findByUserId(int user);
	}
