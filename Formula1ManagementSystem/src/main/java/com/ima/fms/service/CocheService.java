package com.ima.fms.service;
import java.util.List;

import com.ima.fms.entity.Coche;

public interface CocheService {
	
	List<Coche> getAllCoches();
	
	Coche saveCoche(Coche coche);
	
	Coche getCocheById(Long id);
	
	Coche updateCoche(Coche coche);
	
	void deleteCocheById(Long id);
}
