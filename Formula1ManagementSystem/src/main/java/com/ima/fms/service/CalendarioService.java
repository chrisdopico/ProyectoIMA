package com.ima.fms.service;
import java.util.List;

import com.ima.fms.entity.Calendario;

public interface CalendarioService {
	
	List<Calendario> getAllCalendarios();
	
	Calendario saveCalendario(Calendario calendario);
	
	Calendario getCalendarioById(Long id);
	
	Calendario updateCalendario(Calendario calendario);
	
	void deleteCalendarioById(Long id);
}
