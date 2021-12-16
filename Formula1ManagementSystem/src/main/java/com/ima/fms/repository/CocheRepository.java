package com.ima.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ima.fms.entity.Coche;

public interface CocheRepository extends JpaRepository<Coche, Long>{
	
}
