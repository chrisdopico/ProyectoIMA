package com.ima.fms.service;
import java.util.List;

import com.ima.fms.entity.Piloto;

public interface PilotoService {
	
	List<Piloto> getAllPilotos();
	
	List<Piloto> getPilotosByTeam(Long id);
	
	Piloto savePilotos(Piloto piloto);
	
	Piloto getPilotoById(Long id);
	
	Piloto updatePiloto(Piloto piloto);
	
	void deletePilotoById(Long id);
}
