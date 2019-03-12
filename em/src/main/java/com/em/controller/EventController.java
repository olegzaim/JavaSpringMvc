package com.em.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.em.model.Event;
import com.em.repository.EventRepository;
import com.em.service.EventServiceImpl;

@Controller
public class EventController {

	@Autowired
	private EventServiceImpl eventService;

	@Autowired
	private EventRepository eventRepo;

	@GetMapping("/events")
	public String event(HttpServletRequest request) {
		request.setAttribute("events", eventService.getAllEvents());
		return "events";
	}

	@PostMapping("/event")
	public String addEvent(Event event) {
		eventService.addEvent(event);
		return "redirect:/events";
	}

	@GetMapping("/findOne")
	@ResponseBody
	public Event findOne(Long id) {
		return eventRepo.findById(id).get();
	}

	@GetMapping("/allEvents")
	public String allEvent(Model model) {
		model.addAttribute("allEvents", eventService.getAllEvents());
		return "allEvents";
	}

	@GetMapping("/delete")
	public String delete(Long id) {
		eventService.deleteEvent(id);
		return "redirect:/events";
	}
}
