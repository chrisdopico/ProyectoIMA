package com.ima.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "t_detallesVotacion")
public class DetalleVotacion {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetallesVotacion")
	private Long idDetalleVotacion;
	
	
	
	@JoinColumn(name = "idVotacion", referencedColumnName = "idVotacion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("detallesVotacion")
	private Votacion votacion;
	
	
	
	@Column(name = "piloto_id")
	private Long pilotoId;

	
	public DetalleVotacion () {

    }
	
	public DetalleVotacion (Long idDetalleVotacion) {
        this.idDetalleVotacion= idDetalleVotacion;
    }



	public DetalleVotacion(Votacion votacion, Long pilotoId, String nombreUsuario,
			String email_usuario) {
		this.votacion = votacion;
		this.pilotoId = pilotoId;
	}



	public Long getIdDetalleVotacion() {
		return idDetalleVotacion;
	}



	public void setIdDetalleVotacion(Long idDetalleVotacion) {
		this.idDetalleVotacion = idDetalleVotacion;
	}



	public Votacion getVotacion() {
		return votacion;
	}



	public void setVotacion(Votacion votacion) {
		this.votacion = votacion;
	}



	public Long getPilotoId() {
		return pilotoId;
	}



	public void setPilotoId(Long pilotoId) {
		this.pilotoId = pilotoId;
	}

	
	
	
}
