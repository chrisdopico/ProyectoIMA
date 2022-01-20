package com.ima.fms.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.fms.entity.Calendario;
import com.ima.fms.repository.CalendarioRepository;
import com.ima.fms.service.CalendarioService;


@Service
public class CalendarioServiceImplementation implements CalendarioService{
		
	private CalendarioRepository  calendarioRepository;
	
	
	public CalendarioServiceImplementation(CalendarioRepository calendarioRepository) {
		super();
		this.calendarioRepository = calendarioRepository;
	}


	@Override
	public List<Calendario> getAllCalendarios(){
		return calendarioRepository.findAll();
	}
	
	@Override
	public Calendario saveCalendario(Calendario calendario) {
		return calendarioRepository.save(calendario);
	}
	
	@Override
	public Calendario getCalendarioById(Long id) {
		return calendarioRepository.findById(id).get();
	}
	
	@Override
	public Calendario updateCalendario(Calendario calendario) {
		return calendarioRepository.save(calendario);
	}
	
	@Override
	public void deleteCalendarioById(Long id) {
		calendarioRepository.deleteById(id);
	}
	
}
