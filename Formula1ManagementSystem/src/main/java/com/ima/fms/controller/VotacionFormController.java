package com.ima.fms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ima.fms.entity.Piloto;
import com.ima.fms.entity.VotacionForm;
import com.ima.fms.service.PilotoService;
import com.ima.fms.service.VotacionFormService;


@Controller
public class VotacionFormController {
	
	private VotacionFormService votacionFormService;
	private PilotoService pilotoService;
	
	
	
	public VotacionFormController(VotacionFormService votacionFormService, PilotoService pilotoService) {
		super();
		this.votacionFormService = votacionFormService;
		this.pilotoService = pilotoService;
	}


	//
	@GetMapping("/votacionesIndex")
	public String listVotacionesFormIndex(Model model){
		 List<VotacionForm> idPilotos= votacionFormService.getAllPilotosVotacion();
		 List<Piloto> pilotosVotacion = new ArrayList<Piloto>();
		 
		 
		 for(VotacionForm pilotoId:idPilotos) {
			 Piloto piloto = pilotoService.getPilotoById(pilotoId.getIdPiloto());
			 pilotosVotacion.add(piloto);
		 }
		 
		 model.addAttribute("listadoPilotos", pilotosVotacion);
		 
		 return "views_votacion/votacionForm";
		 
	}
	
	
	@GetMapping("/votaciones")
	public String listVotacionesForm(Model model){
		
		
		List<Piloto> todosPilotos = pilotoService.getAllPilotos();
		List<VotacionForm> idPilotos= votacionFormService.getAllPilotosVotacion();
		
		
		List<Piloto> pilotosVotacion = new ArrayList<Piloto>();
		List <String> nombresCompletos = new ArrayList<String>();
		
		for(VotacionForm pilotoId:idPilotos) {
			 Piloto piloto = pilotoService.getPilotoById(pilotoId.getIdPiloto());
			 
			 //piloto.setId(pilotoId.getIdVotacionForm());
			 
			 String nombreCompleto = piloto.getNombre()+piloto.getApellidos();
			 nombresCompletos.add(nombreCompleto);
			 pilotosVotacion.add(piloto);
		}
		 
		 
		model.addAttribute("nombresCompletos", nombresCompletos);
		model.addAttribute("listadoPilotos", pilotosVotacion);
		model.addAttribute("todosPilotos", todosPilotos);
		 
		return "views_votacion/votacionFormAdmin";
	}
	
	
	
	@PostMapping("/votaciones")
	@ResponseBody
	public String saveVotacionForm(@ModelAttribute("pilotoSeleccionado") Piloto pilotoSeleccionado) {
		
		List<VotacionForm> idPilotos= votacionFormService.getAllPilotosVotacion();
		List<Long> idVotacion = new ArrayList<Long>();
		Piloto pilotoEscogido = pilotoService.getPilotoById(pilotoSeleccionado.getId());
		for(VotacionForm pilotoId:idPilotos) {
			idVotacion.add(pilotoId.getIdPiloto());
		}
		
		if(idVotacion.contains(pilotoSeleccionado.getId())==false){
			VotacionForm votacionForm = new VotacionForm(pilotoEscogido.getId());
			votacionFormService.saveVotacionForm(votacionForm);
			return "redirect:/votaciones";
			
		}
		
		else {
			return "Error";
		}
		
		
		
	}
	
	
	@GetMapping("/votaciones/{id}")
	public String deleteVotacionForm(@PathVariable Long id) {
		HashMap<Long,Long> idVotaciones = new HashMap<Long,Long>();
		List<VotacionForm> idPilotos= votacionFormService.getAllPilotosVotacion();
		
		for(VotacionForm pilotoId:idPilotos) {
			idVotaciones.put(pilotoId.getIdPiloto(), pilotoId.getIdVotacionForm());
		}
		
		Long idEliminar = idVotaciones.get(id);
		votacionFormService.deleteVotacionFormById(idEliminar);
		return "redirect:/votaciones";
	}
	
	
	
	
	
	
	
	
}
