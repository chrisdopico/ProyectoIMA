package com.ima.fms.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.fms.entity.Coche;
import com.ima.fms.entity.Votacion;
import com.ima.fms.repository.CocheRepository;
import com.ima.fms.repository.PilotoRepository;
import com.ima.fms.repository.VotacionRepository;
import com.ima.fms.service.CocheService;
import com.ima.fms.service.VotacionService;


@Service
public class VotacionServiceImplementation implements VotacionService{
		
	private final PilotoRepository pilotoRepository;
	private final VotacionRepository votacionRepository;
	
	
	public VotacionServiceImplementation(PilotoRepository pilotoRepository, VotacionRepository votacionRepository) {
		this.pilotoRepository = pilotoRepository;
		this.votacionRepository = votacionRepository;
	}
	
	
	public List<Votacion> listVotaciones(){
		return votacionRepository.findAll();
	}
	
	public Votacion getVotacionById(Long id) {
		return votacionRepository.findById(id).get();
	}
	
	
	public void deleteVotacionById(Long id) {
		votacionRepository.deleteById(id);
	}
	
	
	public Votacion saveVotaciones(Votacion votacion) {
		return votacionRepository.save(votacion);
	}
	
	
}
