package com.em.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.em.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	 Role findByRole(String role);
	}
