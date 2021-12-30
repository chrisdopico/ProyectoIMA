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

	// Método Get Para miembros
	@GetMapping("/miembros")
	public String listMiembros(Model model) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<User> usuarios = userService.getAllUsers();
		List<User> usuarios2 = userService.getAllUsers();

		int a = usuarios2.size();
		
		while(a != 0) {
			usuarios2.remove(a-1);
			a--;
		}

		Escuderia escuderia = null;

		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getEmail().equals(username)) {
				escuderia = usuarios.get(i).getEscuderia();
			}
		}

		for (int i = 0; i < usuarios.size(); i++) {
			User user = usuarios.get(i);
			if (((usuarios.get(i).getEscuderia() == null)
					&& !(usuarios.get(i).getRoles().toString().equals("[Administrador]"))
					&& !(usuarios.get(i).getRoles().toString().equals("[Responsable]")))
					|| (!(usuarios.get(i).getEscuderia() == null)
							&& (usuarios.get(i).getRoles().toString().equals("[Corresponsable]"))
							&& (usuarios.get(i).getEscuderia().equals(escuderia)))) {
				usuarios2.add(user);
			}

		}

		model.addAttribute("usuarios", usuarios2);
		return "views_miembros/miembros";
	}

	// Método Get Para escuderias.
	@GetMapping("/escuderias")
	public String listEscuderias(@AuthenticationPrincipal Authentication auth, Model model) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<User> usuarios = userService.getAllUsers();
		Escuderia escuderia = null;
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getEmail().equals(username)) {
				escuderia = usuarios.get(i).getEscuderia();
			}
		}
		System.out.println("usuario " + escuderia);

		model.addAttribute("escuderias", escuderia);

		return "views_escuderia/escuderias";

	}

	// Metodo validar usuario
	@GetMapping("/usuarios/validarUser/{id}")
	public String validarUser(@PathVariable("id") Long id, Model model) {
		User user = userService.getUserById(id);
		user.setEnabled(true);
		userService.updateUser(user);
		return "redirect:/usuarios";
	}

	// Metodo validar usuario
	@GetMapping("/usuarios/invalidarUser/{id}")
	public String invalidarUser(@PathVariable("id") Long id, Model model) {
		User user = userService.getUserById(id);
		user.setEnabled(false);
		userService.updateUser(user);
		return "redirect:/usuarios";
	}

	// Handler method para delete
	@GetMapping("/usuarios/{id}")
	public String deleteUser(@PathVariable Long id) {
		if (userService.getRoles() == null) {
			userService.deleteUserById(id);
		} else {
			userService.getUserById(id).setEscuderia(null);
			userService.getUserById(id).setRoles(null);
			userService.deleteUserById(id);
		}
		return "redirect:/usuarios";
	}

	// Handler method para agregar un miembro a una escuderia
	@GetMapping("/usuarios/agregarAEscuderia/{id}")
	public String agregarAEscuderia(@PathVariable("id") Long id, Model model) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<User> usuarios = userService.getAllUsers();
		Escuderia escuderia = null;
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getEmail().equals(username)) {
				escuderia = usuarios.get(i).getEscuderia();
			}
		}

		User user = userService.getUserById(id);
		user.setEscuderia(escuderia);
		user.setName_escu(escuderia.getNombre());

		userService.updateUser(user);
		return "redirect:/miembros";
	}

	// Handler method para eliminar un miembro de una escuderia
	@GetMapping("/eliminarDeEscuderia/{id}")
	public String eliminarDeEscuderia(@PathVariable("id") Long id, Model model) {
		User user = userService.getUserById(id);
		user.setEscuderia(null);
		user.setName_escu(null);
		userService.updateUser(user);
		return "redirect:/miembros";
	}
}
