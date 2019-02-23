package com.em.service;

import java.util.List;

import com.em.model.Event;
import com.em.model.User;

public interface EventService {
	
	public List<Event> getAllEvents();
	
	public Event getEvent(Long id);
	
	public void addEvent(Event Event);
	
	public void updateEvent(Long id, Event Event);
	
	public void deleteEvent(Long id);

}
