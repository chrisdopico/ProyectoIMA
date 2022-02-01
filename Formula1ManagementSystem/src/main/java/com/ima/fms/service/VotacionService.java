package com.ima.fms.service;
import java.util.List;

import com.ima.fms.entity.Escuderia;
import com.ima.fms.entity.Votacion;

public interface VotacionService {
	
	List<Votacion> listVotaciones();
	
	Votacion getVotacionById(Long id) ;
	
	void deleteVotacionById(Long id);
	
	Votacion saveVotaciones(Votacion votacion);

}
