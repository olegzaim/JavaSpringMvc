package com.em.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.em.model.Event;
import com.em.model.User;

public interface EventRepository extends JpaRepository<Event, Long>{
	
	Event findByName(String name);
	

}
