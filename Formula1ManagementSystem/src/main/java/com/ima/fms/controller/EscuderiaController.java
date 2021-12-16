package com.ima.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ima.fms.entity.Escuderia;
import com.ima.fms.service.EscuderiaService;
import org.springframework.ui.Model;

@Controller
public class EscuderiaController {
	
	private EscuderiaService escuderiaService;

	public EscuderiaController(EscuderiaService escuderiaService) {
		super();
		this.escuderiaService = escuderiaService;
	}
	
	
	
	@GetMapping("/escuderias")
	public String listEscuderias(Model model) {
		model.addAttribute("escuderia",escuderiaService.getAllEscuderias());
		return "viewEscuderia/escuderias";
		 
	}
	
	
	
	@GetMapping("/escuderias/crear")
	public String createEscuderiaForm(Model model) {
		Escuderia escuderia= new Escuderia();
		model.addAttribute("escuderia",escuderia);
		return "viewEscuderia/create_escuderia";
	}
	
	

	
	@PostMapping("/escuderias")
	public String saveEscuderia(@ModelAttribute("escuderia")Escuderia escuderia) {
		escuderiaService.saveEscuderia(escuderia);
		return "redirect:/escuderias";
	}
	
	
	@GetMapping("/escuderias/edit/{id}")
	public String editEscuderiaForm(@PathVariable Long id,Model model) {
		model.addAttribute("escuderia",escuderiaService.getEscuderiaById(id));
		return "viewEscuderia/edit_escuderia";
	}  
	

	
	@PostMapping("/escuderias/{id}")
	public String updateEscuderia(@PathVariable Long id, @ModelAttribute("escuderia") Escuderia escuderia, Model model) {

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
	
	
}
