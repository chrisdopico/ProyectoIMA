package com.ima.fms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name = "t_pilotos")
public class Piloto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "apellidos", nullable = false)
	private String apellidos;

	@Column(name = "siglas", nullable = false)
	private String siglas;

	@Column(name = "dorsal", nullable = false)
	private String dorsal;

	@Column(name = "foto", nullable = false, length = 999999)
	private String foto;

	@Column(name = "pais", nullable = false)
	private String pais;

	@Column(name = "twitter", nullable = false, length = 999999)
	private String twitter;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

	@JoinTable(name = "pilotos_escuderia", joinColumns = @JoinColumn(name = "piloto_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "escuderia_id", referencedColumnName = "id"))

	Escuderia escuderia;
	
	
	public Piloto (Long id) {
		this.id=id;
	}

	public Piloto() {

	}

	public Piloto(String nombre, String apellidos, String siglas, String dorsal, String foto, String pais,
			String twitter, Escuderia escuderia) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.siglas = siglas;
		this.dorsal = dorsal;
		this.foto = foto;
		this.pais = pais;
		this.twitter = twitter;
		this.escuderia = escuderia;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}

	public String getDorsal() {
		return dorsal;
	}

	public void setDorsal(String dorsal) {
		this.dorsal = dorsal;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public Escuderia getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(Escuderia escuderia) {
		this.escuderia = escuderia;
	}

}
