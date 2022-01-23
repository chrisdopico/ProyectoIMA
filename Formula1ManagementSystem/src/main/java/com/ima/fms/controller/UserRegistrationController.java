package com.ima.fms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ima.fms.entity.Escuderia;
import com.ima.fms.entity.User;
import com.ima.fms.service.EscuderiaService;
import com.ima.fms.service.UserService;
import com.ima.fms.controller.EscuderiaController;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;
	private EscuderiaService escuderiaService;

	public UserRegistrationController(UserService userService, EscuderiaService escuderiaService) {
		super();
		this.userService = userService;
		this.escuderiaService = escuderiaService;
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
	public String registerUserAccount(@ModelAttribute("user") User user, Model model) {
		userService.save(user);
		if(user.getRoles().toString().equals("[Responsable]")) {
			return "views_login/advisor_by_resp";
		}
		
		return "redirect:/registration?success";
	}
}
