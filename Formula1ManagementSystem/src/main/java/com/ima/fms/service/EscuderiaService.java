package com.ima.fms.service;
import java.util.List;

import com.ima.fms.entity.Escuderia;

public interface EscuderiaService {
	
	List<Escuderia> getAllEscuderias();
	
	Escuderia saveEscuderia(Escuderia escuderia);
	
	Escuderia getEscuderiaById(Long id);
	
	Escuderia updateEscuderia(Escuderia escuderia);
	
	void deleteEscuderiaById(Long id);
}
