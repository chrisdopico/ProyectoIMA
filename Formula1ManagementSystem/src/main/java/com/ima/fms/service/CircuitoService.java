package com.ima.fms.service;
import java.util.List;

import com.ima.fms.entity.Circuito;

public interface CircuitoService {
	
	List<Circuito> getAllCircuitos();
	
	Circuito saveCircuito(Circuito circuito);
	
	Circuito getCircuitoById(Long id);
	
	Circuito updateCircuito(Circuito circuito);
	
	void deleteCircuitoById(Long id);
}
