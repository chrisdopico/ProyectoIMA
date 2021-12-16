package com.ima.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ima.fms.entity.User;
import com.ima.fms.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public User user() {
		return new User();
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("listRoles", userService.getRoles());
		return "views_login/registration";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/registration?success";
	}
}
