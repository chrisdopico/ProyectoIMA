package com.ima.fms.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.fms.entity.Coche;
import com.ima.fms.repository.CocheRepository;
import com.ima.fms.service.CocheService;


@Service
public class CocheServiceImplementation implements CocheService{
		
	private CocheRepository  cocheRepository;
	
	
	public CocheServiceImplementation(CocheRepository cocheRepository) {
		super();
		this.cocheRepository = cocheRepository;
	}


	@Override
	public List<Coche> getAllCoches(){
		return cocheRepository.findAll();
	}
	
	@Override
	public Coche saveCoche(Coche coche) {
		return cocheRepository.save(coche);
	}
	
	@Override
	public Coche getCocheById(Long id) {
		return cocheRepository.findById(id).get();
	}
	
	@Override
	public Coche updateCoche(Coche coche) {
		return cocheRepository.save(coche);
	}
	
	@Override
	public void deleteCocheById(Long id) {
		cocheRepository.deleteById(id);
	}
	
}
