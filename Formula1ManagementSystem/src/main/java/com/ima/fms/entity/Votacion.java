package com.ima.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_votaciones")
public class Votacion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVotacion;
	
	@Column(name= "nombreVotacion", nullable=false)
	private String nombreVotacion;
	
	@Column(name= "correoVotacion", nullable=false)
	private String correoVotacion;
	
	@Column(name= "pilotoVotado", nullable=false)
	private Long pilotoVotado;

	public Long getIdVotacion() {
		return idVotacion;
	}
	
	
	
	public Votacion() {
		
	}

	public Votacion(String nombreVotacion, String correoVotacion, Long pilotoVotado) {
		super();
		this.nombreVotacion = nombreVotacion;
		this.correoVotacion = correoVotacion;
		this.pilotoVotado = pilotoVotado;
	}



	public void setIdVotacion(Long idVotacion) {
		this.idVotacion = idVotacion;
	}

	public String getNombreVotacion() {
		return nombreVotacion;
	}

	public void setNombreVotacion(String nombreVotacion) {
		this.nombreVotacion = nombreVotacion;
	}

	public String getCorreoVotacion() {
		return correoVotacion;
	}

	public void setCorreoVotacion(String correoVotacion) {
		this.correoVotacion = correoVotacion;
	}

	public Long getPilotoVotado() {
		return pilotoVotado;
	}

	public void setPilotoVotado(Long pilotoVotado) {
		this.pilotoVotado = pilotoVotado;
	}
	
	
	
	
	
	

}
