package com.ima.fms.service;

import java.util.List;

import com.ima.fms.entity.VotacionForm;

public interface VotacionFormService {
	
	List<VotacionForm> getAllPilotosVotacion();
	
	void saveVotacionForm(VotacionForm votacionForm);
	
	VotacionForm getVotacionFormById(Long votacionFormId);
	
	void deleteVotacionFormById(Long votacionIdForm);

}
