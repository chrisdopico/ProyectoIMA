package com.ima.fms.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.fms.entity.VotacionForm;
import com.ima.fms.repository.VotacionFormRepository;
import com.ima.fms.service.VotacionFormService;

@Service
public class VotacionFormImplementation implements VotacionFormService {
	
	private VotacionFormRepository votacionFormRepository;


	
	
	public VotacionFormImplementation(VotacionFormRepository votacionFormRepository) {
		super();
		this.votacionFormRepository = votacionFormRepository;
	}

	@Override
	public List<VotacionForm> getAllPilotosVotacion() {
		return votacionFormRepository.findAll();
	}

	@Override
	public void saveVotacionForm(VotacionForm votacionForm) {
		votacionFormRepository.save(votacionForm);
	}

	@Override
	public VotacionForm getVotacionFormById(Long votacionFormId) {
		return votacionFormRepository.getById(votacionFormId);
		
	}

	@Override
	public void deleteVotacionFormById(Long votacionIdForm) {
		votacionFormRepository.deleteById(votacionIdForm);
		
	}
	
	
	
	
	
}
