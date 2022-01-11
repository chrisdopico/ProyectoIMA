package com.ima.fms.service.implementation;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ima.fms.entity.Escuderia;
import com.ima.fms.repository.EscuderiaRepository;
import com.ima.fms.service.EscuderiaService;


@Service
public class EscuderiaServiceImplementation implements EscuderiaService{
		
	private EscuderiaRepository  escuderiaRepository;
	
	
	public EscuderiaServiceImplementation(EscuderiaRepository escuderiaRepository) {
		super();
		this.escuderiaRepository = escuderiaRepository;
	}


	@Override
	public List<Escuderia> getAllEscuderias(){
		return escuderiaRepository.findAll();
	}
	
	@Override
	public Escuderia saveEscuderia(Escuderia escuderia) {
		return escuderiaRepository.save(escuderia);
	}
	
	@Override
	public Escuderia getEscuderiaById(Long id) {
		return escuderiaRepository.findById(id).get();
	}
	
	@Override
	public Escuderia updateEscuderia(Escuderia escuderia) {
		return escuderiaRepository.save(escuderia);
	}
	
	@Override
	public void deleteEscuderiaById(Long id) {
		escuderiaRepository.deleteById(id);
	}
	
}
