package com.ima.fms.service;
import java.util.List;

import com.ima.fms.entity.Escuderia;
import com.ima.fms.entity.Piloto;

public interface PilotoService {
	
	List<Piloto> getAllPilotos();
	
	List<Piloto> getPilotosByTeam(Long id);
	
//	Escuderia getEscuderiaByNameUser(String name);
	
	Piloto savePilotos(Piloto piloto);
	
	Piloto getPilotoById(Long id);
	
	Piloto updatePiloto(Piloto piloto);
	
	void deletePilotoById(Long id);
}
