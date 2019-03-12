package com.em.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.repository.EventRepository;
import com.em.repository.EventUserRepository;

@Service
public class EventUserService {

	
	@Autowired
	private EventUserRepository eventUserRepo;
	
}
