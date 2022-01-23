package com.ima.fms.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ima.fms.entity.Escuderia;
import com.ima.fms.entity.User;
import com.ima.fms.service.EscuderiaService;
import com.ima.fms.service.PilotoService;
import com.ima.fms.service.UserService;

import org.springframework.ui.Model;

@Controller
public class EscuderiaController {

	private EscuderiaService escuderiaService;

	public EscuderiaController(EscuderiaService escuderiaService) {
		super();
		this.escuderiaService = escuderiaService;
	}

	@GetMapping("/all_escuderias")
	public String listEscuderias(Model model) {
		model.addAttribute("escuderias", escuderiaService.getAllEscuderias());
		return "views_escuderia/all_escuderias";

	}

	@GetMapping("/escuderias/crear")
	public String createEscuderiaForm(Model model) {
		Escuderia escuderia = new Escuderia();
		model.addAttribute("escuderia", escuderia);
		return "viewEscuderia/create_escuderia";
	}

	@PostMapping("/save_escuderias")
	public String saveEscuderia(@ModelAttribute("escuderia") Escuderia escuderia) {
		escuderiaService.saveEscuderia(escuderia);
		return "redirect:/escuderias";
	}

	@GetMapping("/escuderias/edit/{id}")
	public String editEscuderiaForm(@PathVariable Long id, Model model) {
		model.addAttribute("escuderia", escuderiaService.getEscuderiaById(id));
		return "views_escuderia/edit_escuderia";
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

	@GetMapping("/escuderias/{id}")
	public String deleteEscuderia(@PathVariable Long id) {
		escuderiaService.deleteEscuderiaById(id);
		return "redirect:/escuderia";
	}

	@GetMapping("/escuderias/show")
	public String showEscuderias(Model model) {

		List<Escuderia> escuderias = escuderiaService.getAllEscuderias();
		List<Escuderia> escuderias_2 = escuderiaService.getAllEscuderias();
		int a = escuderias_2.size();

		while (a != 0) {
			escuderias_2.remove(a - 1);
			a--;
		}
		for (int i = 0; i < escuderias.size(); i++) {
			if (((escuderias.get(i).getNombre_responsable()) == (null))) {
				escuderias_2.add(escuderias.get(i));
			}
		}

		model.addAttribute("escuderias", escuderias_2);
		return "views_login/select_escuderia";

	}
}
