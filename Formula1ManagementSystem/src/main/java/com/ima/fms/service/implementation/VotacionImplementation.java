package com.ima.fms.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.fms.entity.Votacion;
import com.ima.fms.repository.VotacionRepository;
import com.ima.fms.service.VotacionService;

@Service
public class VotacionImplementation implements VotacionService {
	
	private VotacionRepository votacionRepository;


	
	
	public VotacionImplementation(VotacionRepository votacionRepository) {
		super();
		this.votacionRepository = votacionRepository;
	}




	@Override
	public List<Votacion> getAllVotaciones() {
		return votacionRepository.findAll();
	}




	@Override
	public void saveVotacion(Votacion votacion) {
		votacionRepository.save(votacion);
		
	}




	@Override
	public Votacion getVotacionById(Long votacionId) {
		return votacionRepository.getById(votacionId);
	}




	@Override
	public void deleteVotacionById(Long votacionId) {
		votacionRepository.deleteById(votacionId);
		
	}

	
	
	
	
	
	
}
