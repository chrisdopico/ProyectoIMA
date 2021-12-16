package com.ima.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ima.fms.entity.User;
import com.ima.fms.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	// Método Get Para usuarios

	@GetMapping("/usuarios")
	public String listUser(Model model) {
		model.addAttribute("usuarios", userService.getAllUsers());
		return "views_login/usuarios";
	}

	// Metodo validar usuario
	@GetMapping("/usuarios/validarUser/{id}")
	public String editRoleUserForm(@PathVariable("id") Long id, Model model) {
		User user = userService.getUserById(id);
		user.setEnabled(true);
		userService.updateUser(user);
		return "redirect:/usuarios";
	}

	// Metodo para validar usuario
	@PostMapping("/usuarios/{id}")
	public String ValidarUsuario(@PathVariable("id") Long id, @ModelAttribute("user") User user, Model model) {

		return "redirect:/usuarios";

	}

	// Handler method para delete
	@GetMapping("/usuarios/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/usuarios";
	}
}
