package com.em.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.em.model.User;
import com.em.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
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
        //userValidator.validate(userForm, bindingResult);

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
    public String logout(Map<String,Object> model) {
    	
		return "/login";
    	
    }
    @GetMapping("/home")
    public String home(Map<String,Object> model) {
    	
		return "home";
    	
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