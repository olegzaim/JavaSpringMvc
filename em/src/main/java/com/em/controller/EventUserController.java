package com.em.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.em.model.Event;
import com.em.model.EventUser;
import com.em.model.User;
import com.em.repository.EventRepository;
import com.em.repository.EventUserRepository;
import com.em.repository.UserRepository;

@Controller
public class EventUserController {

	@Autowired
	private EventUserRepository evenUserRepo;
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EventRepository eventRepo;

	@GetMapping("/userEvent")
	public String addEventUser(Model model, EventUser eventUser, Integer eventId, HttpServletRequest request) {
		// Long idl = ids.longValue();
		Principal principal = request.getUserPrincipal();
		User user = userRepo.findByUsername(principal.getName());
		Integer id1 = new Integer(user.getId());
		eventUser.setUserId(id1);
		eventUser.setEventId(eventId);

		List<EventUser> eventUsers = evenUserRepo.findByUserId(id1);

		if (eventUsers != null) {
			for (EventUser eu : eventUsers) {
				if (eu.getEventId().equals(eventId)) {
					return "redirect:/user";
				}
			}
		}
		model.addAttribute("eventUsers", eventUsers);
		evenUserRepo.save(eventUser);
		return "redirect:/user";
	}
//	
//	@GetMapping("/eventUser")
//	public String getEventUser(EventUser eventUser, Integer eventId, HttpServletRequest request) {
//		// Long idl = ids.longValue();
//		Principal principal = request.getUserPrincipal();
//		User user = userRepo.findByUsername(principal.getName());
//		Integer id1 = new Integer(user.getId());
//		eventUser.setUserId(id1);
//		eventUser.setEventId(eventId);
//		
//		List<EventUser> eventUsers = evenUserRepo.findByUserId(id1);
//
//		if(eventUsers != null) {
//			for(EventUser eu: eventUsers) {
//				if(eu.getEventId().equals(eventId)) {
//					return "redirect:/user";
//				}
//			}
//		}
//		evenUserRepo.save(eventUser);
//		return "redirect:/eventUser";
//	}

	@GetMapping("/eventUsers/{id}")
	public String findOne(Model model, @PathVariable Long id) {

//		Event event = eventRepo.findById(id).get();
		Integer idI = (int) (long) id;
		List<EventUser> eventUsers = evenUserRepo.findByEventId(idI);

		List<User> users = new ArrayList();

		for (EventUser eUser : eventUsers) {
			Integer userId = eUser.getUserId();
			User user = userRepo.findById(eUser.getUserId()).get();
			users.add(user);
		}
		model.addAttribute("event", eventRepo.findById(id).get());
		model.addAttribute("users", users);
		return "eventUsers";
	}

	@GetMapping("/deleteUserEvent")
	public String delete(Model model, Integer eventId, HttpServletRequest request) {
		// Long idl = ids.longValue();
		Principal principal = request.getUserPrincipal();
		User user = userRepo.findByUsername(principal.getName());
		Integer id1 = new Integer(user.getId());
		List<EventUser> eventUsers = evenUserRepo.findAll();
		EventUser eventUser = eventUsers.stream()
				.filter(eu -> eu.getUserId().equals(id1) && eu.getEventId().equals(eventId)).findFirst().get();

		evenUserRepo.deleteById(eventUser.getId());
		return "redirect:/user";
	}

	@GetMapping("/deleteEventUser/{eventId}/user/{userId}")
	public String delete(Model model, @PathVariable Integer eventId, @PathVariable Integer userId) {
		List<EventUser> eventUsers = evenUserRepo.findAll();
		EventUser eventUser = eventUsers.stream()
				.filter(eu -> eu.getUserId().equals(userId) && eu.getEventId().equals(eventId)).findFirst().get();

		evenUserRepo.deleteById(eventUser.getId());
		return "redirect:/events";
	}
}
