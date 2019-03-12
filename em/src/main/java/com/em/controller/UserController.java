package com.em.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.em.model.Event;
import com.em.model.EventUser;
import com.em.model.User;
import com.em.repository.EventRepository;
import com.em.repository.EventUserRepository;
import com.em.repository.UserRepository;
import com.em.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EventUserRepository eventUserRepository;

	@Autowired
	private EventRepository eventRepository;

//	@Autowired
//	private SecurityService securityService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String registration(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String registration(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		// userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "signup";
		}

		userService.addUser(user);

		// securityService.autologin(user.getEmail(), user.getPassword());

		model.addAttribute("user", user);

		return "redirect:/login";
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@GetMapping("/logout")
	public String logout(Map<String, Object> model) {

		return "redirect:/login";

	}

	@GetMapping("/home")
	public String home(Map<String, Object> model) {

		return "home";

	}

	@GetMapping("/user")
	public String getUser(Model model, HttpServletRequest request) {
		// Long idl = ids.longValue();
		Principal principal = request.getUserPrincipal();
		User user = userRepo.findByUsername(principal.getName());
		Integer id = new Integer(user.getId());
		request.setAttribute("user", userRepo.findById(id).get());
//		model.addAttribute("user", userRepo.findById(id).get());
		List<EventUser> eUsers = eventUserRepository.findByUserId(id);
		List<Event> events = new ArrayList();
		for (EventUser eventUser : eUsers) {
			Long ids = eventUser.getEventId().longValue();
			events.add(eventRepository.findById(ids).get());
		}
		request.setAttribute("events", events);

		request.setAttribute("allEvents", eventRepository.findAll());

		return "user";
	}

//	@RequestMapping("/users")
//	public List<User> getAllUsers() {
//		return userService.getAllUsers();
//
//	}
//
//	@RequestMapping("/users/{id}")
//	public User getTopic(@PathVariable Long id) {
//		return userService.getUser(id);
//
//	}
//
//	@RequestMapping(method = RequestMethod.POST, value = "/users")
//	public void addUser(@RequestBody User user) {
//		userService.addUser(user);
//
//	}
//
//	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
//	public void updateUser(@RequestBody User user, @PathVariable Long id) {
//		userService.updateUser(id, user);
//	}
//
//	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
//	public void deleteUser(@PathVariable Long id) {
//		userService.deleteUser(id);
//	}

}