package com.ima.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ima.fms.entity.Calendario;
import com.ima.fms.service.CalendarioService;
import org.springframework.ui.Model;

@Controller
public class CalendarioController {
	
	private CalendarioService calendarioService;

	public CalendarioController(CalendarioService calendarioService) {
		super();
		this.calendarioService = calendarioService;
	}
	
	
	
	@GetMapping("/calendarios")
	public String listCalendarios(Model model) {
		model.addAttribute("calendarios",calendarioService.getAllCalendarios());		
		return "views_calendarios/calendarios";
		 
	}
	
	
	@GetMapping("/calendarios/crear")
	public String createCalendarioForm(Model model) {
		Calendario calendario= new Calendario();
		model.addAttribute("calendario",calendario);
		return "views_calendarios/create_calendario";
	}
	
	

	
	@PostMapping("/calendarios")
	public String saveCalendario(@ModelAttribute("calendario") Calendario calendario) {
		calendarioService.saveCalendario(calendario);
		return "redirect:/calendarios";
	}
	
	
	@GetMapping("/calendarios/edit/{id}")
	public String editCalendariosForm(@PathVariable Long id,Model model) {
		model.addAttribute("calendario",calendarioService.getCalendarioById(id));
		return "views_calendarios/edit_calendario";
	}  
	

	
	@PostMapping("/calendarios/{id}")
	public String updateCalendario(@PathVariable Long id, @ModelAttribute("calendario") Calendario calendario, Model model) {

		Calendario calendarioExistente = calendarioService.getCalendarioById(id);
		calendarioExistente.setIdCalendario(id);
		calendarioExistente.setCiudad(calendario.getCiudad());
		calendarioExistente.setFecha(calendario.getFecha());
		calendarioExistente.setNombre(calendario.getNombre());
		calendarioExistente.setPais(calendario.getPais());
		
		
		calendarioService.updateCalendario(calendarioExistente);
	
		return "redirect:/calendarios";
	}
	
	
	@GetMapping("/calendarios/{id}")
	public String deleteCalendario(@PathVariable Long id) {
		calendarioService.deleteCalendarioById(id);
		return "redirect:/calendarios";
	}
	
	
}