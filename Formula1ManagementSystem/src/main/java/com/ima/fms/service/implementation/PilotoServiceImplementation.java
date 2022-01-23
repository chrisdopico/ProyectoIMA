package com.ima.fms.service.implementation;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ima.fms.entity.Escuderia;
import com.ima.fms.entity.Piloto;
import com.ima.fms.entity.User;
import com.ima.fms.repository.EscuderiaRepository;
import com.ima.fms.repository.PilotoRepository;
import com.ima.fms.repository.UserRepository;
import com.ima.fms.service.PilotoService;
import com.ima.fms.service.UserService;


@Service
public class PilotoServiceImplementation implements PilotoService{
		
	private PilotoRepository  pilotoRepository;
	private UserRepository  userRepository;
	
	
	public PilotoServiceImplementation(PilotoRepository pilotoRepository, UserRepository  userRepository) {
		super();
		this.pilotoRepository = pilotoRepository;
		this.userRepository = userRepository;
	}


	@Override
	public List<Piloto> getAllPilotos(){
		return pilotoRepository.findAll();
	}
	
	@Override
	public Piloto savePilotos(Piloto piloto) {
		return pilotoRepository.save(piloto);
	}
	
	@Override
	public Piloto getPilotoById(Long id) {
		return pilotoRepository.findById(id).get();
	}
	
	@Override
	public Piloto updatePiloto(Piloto piloto) {
		return pilotoRepository.save(piloto);
	}
	
	@Override
	public void deletePilotoById(Long id) {
		pilotoRepository.deleteById(id);
	}
	
}
