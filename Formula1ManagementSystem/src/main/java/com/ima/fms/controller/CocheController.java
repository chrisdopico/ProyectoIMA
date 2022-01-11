package com.ima.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ima.fms.entity.Coche;
import com.ima.fms.service.CocheService;
import org.springframework.ui.Model;

@Controller
public class CocheController {
	
	private CocheService cocheService;

	public CocheController(CocheService cocheService) {
		super();
		this.cocheService = cocheService;
	}
	
	
	
	@GetMapping("/coches")
	public String listCoches(Model model) {
		model.addAttribute("coches",cocheService.getAllCoches());
		return "views_coches/coches";
		 
	}
	
	
	
	@GetMapping("/coches/crear")
	public String createCocheForm(Model model) {
		Coche coche= new Coche();
		model.addAttribute("coche",coche);
		return "viewCoches/create_coche";
	}
	
	

	
	@PostMapping("/coches")
	public String saveCoche(@ModelAttribute("coche")Coche coche) {
		cocheService.saveCoche(coche);
		return "redirect:/coches";
	}
	
	
	@GetMapping("/coches/edit/{id}")
	public String editCochesForm(@PathVariable Long id,Model model) {
		model.addAttribute("coche",cocheService.getCocheById(id));
		return "viewCoches/edit_coche";
	}  
	

	
	@PostMapping("/coches/{id}")
	public String updateCoche(@PathVariable Long id, @ModelAttribute("coche") Coche coche, Model model) {

		Coche cocheExistente = cocheService.getCocheById(id);
		cocheExistente.setCocheId(id);
		cocheExistente.setNombre(coche.getNombre());
		cocheExistente.setERS_CurvaLenta(coche.getERS_CurvaLenta());
		cocheExistente.setERS_CurvaMedia(coche.getERS_CurvaMedia());
		cocheExistente.setERS_CurvaRapida(coche.getERS_CurvaRapida());
		cocheExistente.setConsumo(coche.getConsumo());
		
		
		cocheService.updateCoche(cocheExistente);
	
		return "redirect:/coches";
	}
	
	
	@GetMapping("/coches/{id}")
	public String deleteCoche(@PathVariable Long id) {
		cocheService.deleteCocheById(id);
		return "redirect:/coche";
	}
	
	
}
