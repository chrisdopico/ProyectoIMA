package com.ima.fms.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.fms.entity.Circuito;
import com.ima.fms.repository.CircuitoRepository;
import com.ima.fms.service.CircuitoService;


@Service
public class CircuitoServiceImplementation implements CircuitoService{
		
	private CircuitoRepository  circuitoRepository;
	
	
	public CircuitoServiceImplementation(CircuitoRepository circuitoRepository) {
		super();
		this.circuitoRepository = circuitoRepository;
	}


	@Override
	public List<Circuito> getAllCircuitos(){
		return circuitoRepository.findAll();
	}
	
	@Override
	public Circuito saveCircuito(Circuito circuito) {
		return circuitoRepository.save(circuito);
	}
	
	@Override
	public Circuito getCircuitoById(Long id) {
		return circuitoRepository.findById(id).get();
	}
	
	@Override
	public Circuito updateCircuito(Circuito circuito) {
		return circuitoRepository.save(circuito);
	}
	
	@Override
	public void deleteCircuitoById(Long id) {
		circuitoRepository.deleteById(id);
	}
	
}
