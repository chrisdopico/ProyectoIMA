package com.ima.fms.service;

import java.util.List;

import com.ima.fms.entity.Votacion;

public interface VotacionService {
	
	List<Votacion> getAllVotaciones();
	
	void saveVotacion(Votacion votacion);
	
	Votacion getVotacionById(Long votacionId);
	
	void deleteVotacionById(Long votacionId);

}
