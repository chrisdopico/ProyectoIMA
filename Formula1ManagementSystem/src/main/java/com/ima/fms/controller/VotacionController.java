package com.ima.fms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ima.fms.entity.Votacion;
import com.ima.fms.service.VotacionService;

@RestController
public class VotacionController {
	
	private VotacionService votacionService;

	public VotacionController(VotacionService votacionService) {
		this.votacionService = votacionService;
	}
	
	
	@GetMapping("/votaciones")
    public List<Votacion> listVotaciones(){

        return votacionService.listVotaciones();
    }
	
	@GetMapping("/votaciones/{votacionId}")
    public Votacion findVotacionById(@PathVariable("votacionId") Long votacionId){
        return votacionService.getVotacionById(votacionId);
    }
	
	@PostMapping("/votaciones")
	public Votacion saveVotacion(@RequestBody Votacion votacion){
        return votacionService.saveVotaciones(votacion);
    }
	
	
	@DeleteMapping("/votaciones/{votacionId}")
	public void deleteVotacion(@PathVariable("votacionId") Long votacionId){
        votacionService.deleteVotacionById(votacionId);
    }
	
	
	
}