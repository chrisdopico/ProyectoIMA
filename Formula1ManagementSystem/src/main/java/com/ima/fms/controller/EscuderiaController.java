package com.ima.fms.controller;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ima.fms.entity.Escuderia;
import com.ima.fms.entity.User;
import com.ima.fms.service.EscuderiaService;
import com.ima.fms.service.PilotoService;
import com.ima.fms.service.UserService;

import org.springframework.ui.Model;

@Controller
public class EscuderiaController {

	private EscuderiaService escuderiaService;

	private UserService userService;

	public EscuderiaController(EscuderiaService escuderiaService, UserService userService) {
		super();
		this.escuderiaService = escuderiaService;
		this.userService = userService;
	}

	@GetMapping("/all_escuderias")
	public String listEscuderias(Model model) {
		model.addAttribute("escuderias", escuderiaService.getAllEscuderias());
		return "views_escuderia/all_escuderias";

	}

	@GetMapping("/escuderias_admin")
	public String listEscuderiasAdmin(Model model) {
		model.addAttribute("escuderias", escuderiaService.getAllEscuderias());
		return "views_escuderia/admin_escuderias";

	}

	@GetMapping("/escuderias/create")
	public String createEscuderiaForm(Model model) {
		Escuderia escuderia = new Escuderia();
		model.addAttribute("escuderia", escuderia);
		return "views_escuderia/create_escuderia";
	}

	@PostMapping("/save_escuderias")
	public String saveEscuderia(@ModelAttribute("escuderia") Escuderia escuderia) {
		escuderiaService.saveEscuderia(escuderia);
		return "redirect:/escuderias";
	}

	@PostMapping("/save_escuderias_admin")
	public String saveEscuderiaAdmin(@ModelAttribute("escuderia") Escuderia escuderia) {
		escuderiaService.saveEscuderia(escuderia);
		return "redirect:/escuderias_admin";
	}

	@GetMapping("/escuderias/edit/{id}")
	public String editEscuderiaForm(@PathVariable Long id, Model model) {
		model.addAttribute("escuderia", escuderiaService.getEscuderiaById(id));
		return "views_escuderia/edit_escuderia";
	}

	@GetMapping("/escuderias/editAdmin/{id}")
	public String editEscuderiaFormAdmin(@PathVariable Long id, Model model) {
		model.addAttribute("escuderia", escuderiaService.getEscuderiaById(id));
		return "views_escuderia/edit_escuderia_admin";
	}

	@PostMapping("/escuderias/{id}")
	public String updateEscuderia(@PathVariable Long id, @ModelAttribute("escuderia") Escuderia escuderia,
			Model model) {

		Escuderia escuderiaExistente = escuderiaService.getEscuderiaById(id);
		escuderiaExistente.setId(id);
		escuderiaExistente.setNombre(escuderia.getNombre());
		escuderiaExistente.setLogo(escuderia.getLogo());
		escuderiaExistente.setTwitter(escuderia.getTwitter());

		escuderiaService.updateEscuderia(escuderiaExistente);

		return "redirect:/escuderias";
	}

	@PostMapping("/escuderiasAdmin/{id}")
	public String updateEscuderiaAdmin(@PathVariable Long id, @ModelAttribute("escuderia") Escuderia escuderia,
			Model model) {

		Escuderia escuderiaExistente = escuderiaService.getEscuderiaById(id);
		escuderiaExistente.setId(id);
		escuderiaExistente.setNombre(escuderia.getNombre());
		escuderiaExistente.setLogo(escuderia.getLogo());
		escuderiaExistente.setTwitter(escuderia.getTwitter());

		escuderiaService.updateEscuderia(escuderiaExistente);

		return "redirect:/escuderias_admin";
	}

	@GetMapping("/escuderias/{id}")
	public String deleteEscuderia(@PathVariable Long id, RedirectAttributes redirectAttrs) {
		Escuderia escuderia = escuderiaService.getEscuderiaById(id);
		if (escuderia.getNombre_responsable() == null) {
			escuderiaService.deleteEscuderiaById(id);
		} else {
			redirectAttrs.addFlashAttribute("mensaje", "No puede eliminar la escudería porque tiene responsable")
					.addFlashAttribute("clase", "success");
		}
		return "redirect:/escuderias_admin";
	}

	@GetMapping("/escuderias/show")
	public String showEscuderias(Model model) {

		List<Escuderia> escuderias = escuderiaService.getAllEscuderias();
		List<Escuderia> escuderias_2 = new ArrayList<>();
		for (int i = 0; i < escuderias.size(); i++) {
			if (((escuderias.get(i).getNombre_responsable()) == (null))) {
				escuderias_2.add(escuderias.get(i));
			}

		}

		boolean flag = false;

		if (escuderias_2.size() == 0) {
			flag = true;
			model.addAttribute("flag", flag);
			flag = false;

			List<User> usuarios = userService.getAllUsers();

			for (int i = 0; i <= usuarios.size(); i++) {
				if (i == usuarios.size() - 1) {
					User user = usuarios.get(i);
					userService.deleteUserById(user.getId());
				}

			}
		}
		
		model.addAttribute("escuderias", escuderias_2);
		return "views_login/select_escuderia";

	}
}
