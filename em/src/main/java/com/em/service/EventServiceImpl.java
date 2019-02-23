package com.em.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.model.Event;
import com.em.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventRepository eventRepo;

	@Override
	public List<Event> getAllEvents() {
		List<Event> events = new ArrayList<>();
		eventRepo.findAll().forEach(events::add);
		return events;
	}

	@Override
	public Event getEvent(Long id) {
		return eventRepo.findById(id).get();
	}

	@Override
	public void addEvent(Event event) {
		eventRepo.save(event);
	}

	@Override
	public void updateEvent(Long id, Event event) {
		eventRepo.save(event);
	}

	@Override
	public void deleteEvent(Long id) {
		eventRepo.deleteById(id);
	}
	

}
