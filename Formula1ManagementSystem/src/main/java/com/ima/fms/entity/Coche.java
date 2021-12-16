package com.ima.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="t_coches")
public class Coche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "nombre", nullable=false)
	private String nombre;
	@Column(name= "ERS_CurvaLenta", nullable=false)
	private float ERS_CurvaLenta;
	@Column(name= "ERS_CurvaMedia", nullable=false)
	private float ERS_CurvaMedia;
	@Column(name= "ERS_CurvaRápida", nullable=false)
	private float ERS_CurvaRápida;
	@Column(name= "Consumo", nullable=false)
	private float Consumo;
	
	
	public Coche () {
		
	}
	
	
	public Coche(String nombre, float eRS_CurvaLenta, float eRS_CurvaMedia, float eRS_CurvaRápida,
			float consumo) {
		super();
		this.nombre = nombre;
		this.ERS_CurvaLenta = eRS_CurvaLenta;
		this.ERS_CurvaMedia = eRS_CurvaMedia;
		this.ERS_CurvaRápida = eRS_CurvaRápida;
		this.Consumo = consumo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getERS_CurvaLenta() {
		return ERS_CurvaLenta;
	}
	public void setERS_CurvaLenta(float eRS_CurvaLenta) {
		ERS_CurvaLenta = eRS_CurvaLenta;
	}
	public float getERS_CurvaMedia() {
		return ERS_CurvaMedia;
	}
	public void setERS_CurvaMedia(float eRS_CurvaMedia) {
		ERS_CurvaMedia = eRS_CurvaMedia;
	}
	public float getERS_CurvaRápida() {
		return ERS_CurvaRápida;
	}
	public void setERS_CurvaRápida(float eRS_CurvaRápida) {
		ERS_CurvaRápida = eRS_CurvaRápida;
	}
	public float getConsumo() {
		return Consumo;
	}
	public void setConsumo(float consumo) {
		Consumo = consumo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
}
