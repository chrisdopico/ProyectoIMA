package com.ima.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ima.fms.entity.Circuito;
import com.ima.fms.service.CircuitoService;
import org.springframework.ui.Model;

@Controller
public class CircuitoController {
	
	private CircuitoService circuitoService;

	public CircuitoController(CircuitoService circuitoService) {
		super();
		this.circuitoService = circuitoService;
	}
	
	
	
	@GetMapping("/circuitos")
	public String listCircuitos(Model model) {
		model.addAttribute("circuitos",circuitoService.getAllCircuitos());		
		return "views_circuitos/circuitos";
		 
	}
	
	@GetMapping("/circuitos_views")
	public String CircuitosViews(Model model) {
		model.addAttribute("circuitos",circuitoService.getAllCircuitos());		
		return "views_circuitos/circuitos_views";
		 
	}
	
	@GetMapping("/circuitos/crear")
	public String createCircuitoForm(Model model) {
		Circuito circuito= new Circuito();
		model.addAttribute("circuito",circuito);
		return "views_circuitos/create_circuito";
	}
	
	

	
	@PostMapping("/circuitos")
	public String saveCircuito(@ModelAttribute("circuito") Circuito circuito) {
		circuitoService.saveCircuito(circuito);
		return "redirect:/circuitos";
	}
	
	
	@GetMapping("/circuitos/edit/{id}")
	public String editCircuitosForm(@PathVariable Long id,Model model) {
		model.addAttribute("circuito",circuitoService.getCircuitoById(id));
		return "views_circuitos/edit_circuito";
	}  
	

	
	@PostMapping("/circuitos/{id}")
	public String updateCircuito(@PathVariable Long id, @ModelAttribute("circuito") Circuito circuito, Model model) {

		Circuito circuitoExistente = circuitoService.getCircuitoById(id);
		circuitoExistente.setId(id);
		circuitoExistente.setCiudad(circuito.getCiudad());
		circuitoExistente.setNombre(circuito.getNombre());
		circuitoExistente.setPais(circuito.getPais());
		circuitoExistente.setTrazado(circuito.getTrazado());
		circuitoExistente.setLongitud(circuito.getLongitud());
		circuitoExistente.setNumero_de_vueltas(circuito.getNumero_de_vueltas());
		circuitoExistente.setCurvas_lentas(circuito.getCurvas_lentas());
		circuitoExistente.setCurvas_medias(circuito.getCurvas_medias());
		circuitoExistente.setCurvas_rapidas(circuito.getCurvas_rapidas());
		
		circuitoService.updateCircuito(circuitoExistente);
	
		return "redirect:/circuitos";
	}
	
	
	@GetMapping("/circuitos/{id}")
	public String deleteCircuito(@PathVariable Long id) {
		circuitoService.deleteCircuitoById(id);
		return "redirect:/circuitos";
	}
	
	
}