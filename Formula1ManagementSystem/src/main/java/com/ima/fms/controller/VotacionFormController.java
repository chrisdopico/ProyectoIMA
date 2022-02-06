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
import com.ima.fms.entity.Votacion;
import com.ima.fms.entity.VotacionForm;
import com.ima.fms.service.PilotoService;
import com.ima.fms.service.VotacionFormService;
import com.ima.fms.service.VotacionService;


@Controller
public class VotacionFormController {
	
	private VotacionFormService votacionFormService;
	private PilotoService pilotoService;
	private VotacionService votacionService;
	
	
	
	public VotacionFormController(VotacionFormService votacionFormService, PilotoService pilotoService, VotacionService votacionService) {
		super();
		this.votacionFormService = votacionFormService;
		this.pilotoService = pilotoService;
		this.votacionService = votacionService;
	}

	@PostMapping("/guardarVotacion")
	public String guardarVotacion(@RequestParam("nombreVotacion") String nombreVotacion,
			@RequestParam("correoVotacion") String correoVotacion,
			@RequestParam("idPiloto") Long idPiloto) {
		
		List<Votacion> todasVotaciones = votacionService.getAllVotaciones();
		List<String> nombreUsuarios = new ArrayList<String>();
		List<String> correosUsuarios = new ArrayList<String>();
		
		for(Votacion votacion:todasVotaciones) {
			nombreUsuarios.add(votacion.getNombreVotacion());
			correosUsuarios.add(votacion.getCorreoVotacion());
		}
		
		if(nombreUsuarios.contains(nombreVotacion)==false || correosUsuarios.contains(correoVotacion)==false) {
			Votacion votacion = new Votacion(nombreVotacion, correoVotacion, idPiloto);
			votacionService.saveVotacion(votacion);
			return "redirect:/votacionesIndex";
		}
		else {
			return "views_votacion/errorIndex";
		}
	}
	
	//
	@GetMapping("/votacionesIndex")
	public String listVotacionesFormIndex(Model model){
		 List<VotacionForm> idPilotos= votacionFormService.getAllPilotosVotacion();
		 List<Piloto> pilotosVotacion = new ArrayList<Piloto>();
		 Votacion votacion = new Votacion();
		 
		 
		 for(VotacionForm pilotoId:idPilotos) {
			 Piloto piloto = pilotoService.getPilotoById(pilotoId.getIdPiloto());
			 pilotosVotacion.add(piloto);
		 }
		 
		 model.addAttribute("listadoPilotos", pilotosVotacion);
		 model.addAttribute("votacion",votacion);
		 
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
			return "views_votacion/error";
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
