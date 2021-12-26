package com.ima.fms.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ima.fms.entity.Escuderia;
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
	
	
	@GetMapping("/escuderias")
	public String listEscuderias(@AuthenticationPrincipal Authentication auth, Model model) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<User> usuarios = userService.getAllUsers();
		Escuderia escuderia = null;
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getEmail().equals(username)) {
				escuderia = usuarios.get(i).getEscuderia();
			}
		}	
		System.out.println("usuario "+ escuderia);
		
		model.addAttribute("escuderias",escuderia);
		
		return "views_escuderia/escuderias";
		 
	}
	
	// Metodo validar usuario
	@GetMapping("/usuarios/validarUser/{id}")
	public String editRoleUserForm(@PathVariable("id") Long id, Model model) {
		User user = userService.getUserById(id);
		user.setEnabled(true);
		userService.updateUser(user);
		return "redirect:/usuarios";
	}

	// Metodo validar usuario
		@GetMapping("/usuarios/invalidarUser/{id}")
		public String editRoleUserForm2(@PathVariable("id") Long id, Model model) {
			User user = userService.getUserById(id);
			user.setEnabled(false);
			userService.updateUser(user);
			return "redirect:/usuarios";
		}
	
	// Handler method para delete
	@GetMapping("/usuarios/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/usuarios";
	}
}
