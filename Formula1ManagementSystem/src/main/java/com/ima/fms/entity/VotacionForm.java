package com.ima.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_votacionForm")
public class VotacionForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVotacionForm")
	private Long idVotacionForm;

	
	@Column(name = "idPiloto")
	private Long idPiloto;

	
	

	public VotacionForm() {
	}
	


	public VotacionForm(Long idPiloto) {
		this.idPiloto = idPiloto;
	}





	public Long getIdVotacionForm() {
		return idVotacionForm;
	}



	public void setIdVotacionForm(Long idVotacionForm) {
		this.idVotacionForm = idVotacionForm;
	}



	public Long getIdPiloto() {
		return idPiloto;
	}


	public void setIdPiloto(Long idPiloto) {
		this.idPiloto = idPiloto;
	}
	
	
	

}
