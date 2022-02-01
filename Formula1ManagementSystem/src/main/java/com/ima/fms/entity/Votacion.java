package com.ima.fms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="t_votaciones")
public class Votacion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVotacion")
	private Long idVotacion;
	
	@Column(name= "tituloVotacion", nullable=false)
	private String tituloVotacion;
	
	@Column(name= "descripcionVotacion", nullable=false)
	private String descripcionVotacion;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "votacion", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("votacion")
    private List<DetalleVotacion> detallesVotacion = new ArrayList<>();

	
	public Votacion() {
	}
	
	public Votacion(Long idVotacion) {
		this.idVotacion = idVotacion;
	}

	public Long getIdVotacion() {
		return idVotacion;
	}

	public void setIdVotacion(Long idVotacion) {
		this.idVotacion = idVotacion;
	}

	public String getTituloVotacion() {
		return tituloVotacion;
	}

	public void setTituloVotacion(String tituloVotacion) {
		this.tituloVotacion = tituloVotacion;
	}

	public String getDescripcionVotacion() {
		return descripcionVotacion;
	}

	public void setDescripcionVotacion(String descripcionVotacion) {
		this.descripcionVotacion = descripcionVotacion;
	}

	public List<DetalleVotacion> getDetallesVotacion() {
		return detallesVotacion;
	}

	public void setDetallesVotacion(List<DetalleVotacion> detallesVotacion) {
		this.detallesVotacion = detallesVotacion;
		for(DetalleVotacion detalleVotacion : this.detallesVotacion) {
			detalleVotacion.setVotacion(this);
		}
	}
	
	

}
