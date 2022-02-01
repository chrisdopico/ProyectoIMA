package com.ima.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ima.fms.entity.Calendario;
import com.ima.fms.entity.DetalleVotacion;
import com.ima.fms.entity.Votacion;

public interface DetalleVotacionRepository extends JpaRepository<DetalleVotacion, Long>{
	
}
