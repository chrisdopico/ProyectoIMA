package com.ima.fms.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ima.fms.entity.Coche;
import com.ima.fms.entity.Escuderia;
import com.ima.fms.entity.Piloto;
import com.ima.fms.entity.User;
import com.ima.fms.service.CocheService;
import com.ima.fms.service.EscuderiaService;
import com.ima.fms.service.UserService;

import org.springframework.ui.Model;

@Controller
public class CocheController {
	
	private CocheService cocheService;
	private EscuderiaService escuderiaService;
	private UserService userService;

	public CocheController(CocheService cocheService, EscuderiaService escuderiaService, UserService userService) {
		super();
		this.cocheService = cocheService;
		this.escuderiaService = escuderiaService;
		this.userService = userService;
	}
	
	@GetMapping("/all_coches_escu/{id}")
	public String listPilotosUser(@PathVariable Long id, Model model) {
		
		List<Coche> coches = cocheService.getAllCoches();
		List<Coche> coches_2 = cocheService.getAllCoches();
		Escuderia escuderia = escuderiaService.getEscuderiaById(id);
		
		int a = coches_2.size();
		
		while (a != 0) {
			coches_2.remove(a - 1);
			a--;
		}
		
		for(int i = 0; i < coches.size(); i++) {
			if(coches.get(i).getEscuderia().getNombre().equals(escuderia.getNombre())) {
				coches_2.add(coches.get(i));
			}
		}
		
		model.addAttribute("coches", coches_2);
		
		return "views_coches/coches_escuderia";

	}
	
	
	@GetMapping("/coches")
	public String listCoches(Model model) {
		
		List<Coche> coches = cocheService.getAllCoches();
		List<Coche> coches_2 = cocheService.getAllCoches();
		List<User> usuarios = userService.getAllUsers();
		Escuderia escuderia = null;
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		int a = coches_2.size();
		
		while (a != 0) {
			coches_2.remove(a - 1);
			a--;
		}
		
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getEmail().equals(username)) {
				escuderia = usuarios.get(i).getEscuderia();
			}
		}
		
		for(int i = 0; i < coches.size(); i++) {
			if(coches.get(i).getEscuderia().getNombre().equals(escuderia.getNombre())) {
				coches_2.add(coches.get(i));
			}
		}
		
		model.addAttribute("coches", coches_2);
		
		return "views_coches/coches";
		 
	}
	
	
	
	@GetMapping("/coches/crear")
	public String createCocheForm(Model model) {
		Coche coche= new Coche();
		model.addAttribute("coche",coche);
		return "views_coches/create_coche";
	}
	
	

	
	@PostMapping("/coches")
	public String saveCoche(@ModelAttribute("coche")Coche coche) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<User> usuarios = userService.getAllUsers();
		
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getEmail().equals(username)) {
				coche.setEscuderia(usuarios.get(i).getEscuderia());
			}
		}
		
		cocheService.saveCoche(coche);
		return "redirect:/coches";
	}
	
	
	@GetMapping("/coches/edit/{id}")
	public String editCochesForm(@PathVariable Long id,Model model) {
		model.addAttribute("coche",cocheService.getCocheById(id));
		return "views_coches/edit_coche";
	}  
	

	
	@PostMapping("/coches/{id}")
	public String updateCoche(@PathVariable Long id, @ModelAttribute("coche") Coche coche, Model model) {

		Coche cocheExistente = cocheService.getCocheById(id);
		cocheExistente.setCocheId(id);
		cocheExistente.setNombre(coche.getNombre());
		cocheExistente.setCodigo(coche.getCodigo());
		cocheExistente.setERS_CurvaLenta(coche.getERS_CurvaLenta());
		cocheExistente.setERS_CurvaMedia(coche.getERS_CurvaMedia());
		cocheExistente.setERS_CurvaRapida(coche.getERS_CurvaRapida());
		cocheExistente.setConsumo(coche.getConsumo());
		
		
		cocheService.updateCoche(cocheExistente);
	
		return "redirect:/coches";
	}
	
	
	@GetMapping("/coches/{id}")
	public String deleteCoche(@PathVariable Long id) {
		cocheService.getCocheById(id).setEscuderia(null);
		cocheService.deleteCocheById(id);
		return "redirect:/coches";
	}
	
	
}
