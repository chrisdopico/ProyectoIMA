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
import com.ima.fms.service.PilotoService;
import com.ima.fms.service.UserService;

import org.springframework.ui.Model;


@Controller
public class PilotoController {

	private PilotoService pilotoService;

	public PilotoController(PilotoService pilotoService) {
		super();
		this.pilotoService = pilotoService;
	}

	@GetMapping("/pilotos")
	public String listPilotos(Model model) {
		/*String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		UserService userService = null;
		
		Escuderia escuderia = userService.getEscuderiaByNameUser();

		List<Piloto> pilotos = pilotoService.getAllPilotos();
		List<Piloto> pilotos2 = pilotoService.getAllPilotos();
		
		int a = pilotos2.size();

		while (a != 0) {
			pilotos2.remove(a - 1);
			a--;
		}
		
		for(int i = 0; i < pilotos.size(); i++) {
			if(pilotos.get(i).getEscuderia() == escuderia) {
				pilotos2.add(pilotos.get(i));
			}
		}
		
		*/
		model.addAttribute("pilotos", pilotoService.getAllPilotos());
//		model.addAttribute("pilotos",pilotos2);
		return "views_pilotos/pilotos";

	}

	@GetMapping("/pilotos/crear")
	public String createPilotoForm(Model model) {
		Piloto piloto = new Piloto();
		model.addAttribute("piloto", piloto);
		return "views_pilotos/create_piloto";
	}

	@PostMapping("/save_pilotos")
	public String savePiloto(@ModelAttribute("piloto") Piloto piloto) {
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
		pilotoService.deletePilotoById(id);
		return "redirect:/pilotos";
	}

}