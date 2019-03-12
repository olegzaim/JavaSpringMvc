package com.em.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.em.model.EventUser;

public interface EventUserRepository extends JpaRepository<EventUser, Integer> {
	
	List<EventUser> findByUserId(Integer id);

	List<EventUser> findByEventId(Integer id);
}
