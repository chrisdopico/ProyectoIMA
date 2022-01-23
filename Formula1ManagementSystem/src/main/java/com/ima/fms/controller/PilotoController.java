package com.ima.fms.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ima.fms.entity.Escuderia;
import com.ima.fms.entity.Piloto;
import com.ima.fms.entity.User;
import com.ima.fms.service.EscuderiaService;
import com.ima.fms.service.PilotoService;
import com.ima.fms.service.UserService;

import org.springframework.ui.Model;


@Controller
public class PilotoController {

	private PilotoService pilotoService;
	private EscuderiaService escuderiaService;
	private UserService userService;

	public PilotoController(PilotoService pilotoService, EscuderiaService escuderiaService, UserService userService) {
		super();
		this.pilotoService = pilotoService;
		this.escuderiaService = escuderiaService;
		this.userService = userService;
	}

	@GetMapping("/pilotos")
	public String listPilotos(Model model) {
		
		List<Piloto> pilotos = pilotoService.getAllPilotos();
		List<Piloto> pilotos_2 = pilotoService.getAllPilotos();
		List<User> usuarios = userService.getAllUsers();
		Escuderia escuderia = null;
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		int a = pilotos_2.size();
		
		while (a != 0) {
			pilotos_2.remove(a - 1);
			a--;
		}
		
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getEmail().equals(username)) {
				escuderia = usuarios.get(i).getEscuderia();
			}
		}
		
		for(int i = 0; i < pilotos.size(); i++) {
			if(pilotos.get(i).getEscuderia().getNombre().equals(escuderia.getNombre())) {
				pilotos_2.add(pilotos.get(i));
			}
		}
		
		model.addAttribute("pilotos", pilotos_2);
		
		return "views_pilotos/pilotos";

	}	
	//a
	@GetMapping("/all_pilots_escu/{id}")
	public String listPilotosUser(@PathVariable Long id, Model model) {
		
		List<Piloto> pilotos = pilotoService.getAllPilotos();
		List<Piloto> pilotos_2 = pilotoService.getAllPilotos();
		Escuderia escuderia = escuderiaService.getEscuderiaById(id);
		
		int a = pilotos_2.size();
		
		while (a != 0) {
			pilotos_2.remove(a - 1);
			a--;
		}
		
		for(int i = 0; i < pilotos.size(); i++) {
			if(pilotos.get(i).getEscuderia().getNombre().equals(escuderia.getNombre())) {
				pilotos_2.add(pilotos.get(i));
			}
		}
		
		model.addAttribute("pilotos", pilotos_2);
		
		return "views_pilotos/pilotos_escuderia";

	}

	@GetMapping("/pilotos/crear")
	public String createPilotoForm(Model model) {
		Piloto piloto = new Piloto();
		model.addAttribute("piloto", piloto);
		return "views_pilotos/create_piloto";
	}

	@PostMapping("/save_pilotos")
	public String savePiloto(@ModelAttribute("piloto") Piloto piloto) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<User> usuarios = userService.getAllUsers();
		
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getEmail().equals(username)) {
				piloto.setEscuderia(usuarios.get(i).getEscuderia());
			}
		}
				
		pilotoService.savePilotos(piloto);
		return "redirect:/pilotos";
	}

	@GetMapping("/pilotos/edit/{id}")
	public String editPilotosForm(@PathVariable Long id, Model model) {
		model.addAttribute("piloto", pilotoService.getPilotoById(id));
		return "views_pilotos/edit_piloto";
	}

	@PostMapping("/pilotos/{id}")
	public String updatePiloto(@PathVariable Long id, @ModelAttribute("piloto") Piloto piloto, Model model) {

		Piloto pilotoExistente = pilotoService.getPilotoById(id);
		pilotoExistente.setId(id);
		pilotoExistente.setApellidos(piloto.getApellidos());
		pilotoExistente.setNombre(piloto.getNombre());
		pilotoExistente.setSiglas(piloto.getSiglas());
		pilotoExistente.setDorsal(piloto.getDorsal());
		pilotoExistente.setFoto(piloto.getFoto());
		pilotoExistente.setPais(piloto.getPais());

		pilotoService.updatePiloto(pilotoExistente);

		return "redirect:/pilotos";
	}

	@GetMapping("/pilotos/{id}")
	public String deletePiloto(@PathVariable Long id) {
		pilotoService.getPilotoById(id).setEscuderia(null);
		pilotoService.deletePilotoById(id);
		return "redirect:/pilotos";
	}

}