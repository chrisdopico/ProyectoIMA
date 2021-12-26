package com.ima.fms.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.fms.entity.Piloto;
import com.ima.fms.repository.PilotoRepository;
import com.ima.fms.service.PilotoService;


@Service
public class PilotoServiceImplementation implements PilotoService{
		
	private PilotoRepository  pilotoRepository;
	
	
	public PilotoServiceImplementation(PilotoRepository pilotoRepository) {
		super();
		this.pilotoRepository = pilotoRepository;
	}


	@Override
	public List<Piloto> getAllPilotos(){
		return pilotoRepository.findAll();
	}
	
	public List<Piloto> getPilotosByTeam(Long id){
	/*	List<Piloto> pilotos = pilotoRepository.findAll();
		List<Piloto> pilotos2;
		
		for(int i = 0; i <= pilotos.size(); i++) {
			if(pilotos)
		}*/
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
