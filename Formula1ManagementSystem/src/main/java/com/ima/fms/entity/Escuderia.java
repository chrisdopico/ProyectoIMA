package com.ima.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "t_escuderias")
public class Escuderia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "logo", length = 999999)
	private String logo;
	@Column(name = "twitter")
	private String twitter;
	@Column(name = "nombre_responsable")
	private String nombre_responsable;
	
	public Escuderia() {

	}

	public Escuderia(String nombre, String logo, String twitter, String nombre_responsable) {
		super();
		this.nombre = nombre;
		this.logo = logo;
		this.twitter = twitter;
		this.nombre_responsable = nombre_responsable;
	}

	public String getNombre_responsable() {
		return nombre_responsable;
	}

	public void setNombre_responsable(String nombre_responsable) {
		this.nombre_responsable = nombre_responsable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	
}
