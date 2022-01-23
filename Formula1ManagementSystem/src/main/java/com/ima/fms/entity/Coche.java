package com.ima.fms.entity;

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

@Entity
@Table(name="t_coches")
public class Coche {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CocheId;
	
	@Column(name= "nombre", nullable=false)
	private String nombre;
	@Column(name= "codigo", nullable=false)
	private String codigo;
	@Column(name= "ERS_CurvaLenta", nullable=false)
	private float ERS_CurvaLenta;
	@Column(name= "ERS_CurvaMedia", nullable=false)
	private float ERS_CurvaMedia;
	@Column(name= "ERS_CurvaRapida", nullable=false)
	private float ERS_CurvaRapida;
	@Column(name= "Consumo", nullable=false)
	private float Consumo;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

	@JoinTable(name = "coches_escuderia", joinColumns = @JoinColumn(name = "coche_id", referencedColumnName = "CocheId"), inverseJoinColumns = @JoinColumn(name = "escuderia_id", referencedColumnName = "id"))

	Escuderia escuderia;
	
	
	public Coche () {
		
	}
	
	
	public Coche(String nombre,String codigo, float eRS_CurvaLenta, float eRS_CurvaMedia, float eRS_CurvaRapida,
			float consumo, Escuderia escuderia) {
		super();
		this.nombre = nombre;
		this.codigo=codigo;
		this.ERS_CurvaLenta = eRS_CurvaLenta;
		this.ERS_CurvaMedia = eRS_CurvaMedia;
		this.ERS_CurvaRapida = eRS_CurvaRapida;
		this.Consumo = consumo;
		this.escuderia = escuderia;
	}
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public float getERS_CurvaRapida() {
		return ERS_CurvaRapida;
	}
	public void setERS_CurvaRapida(float eRS_CurvaRapida) {
		ERS_CurvaRapida = eRS_CurvaRapida;
	}
	public float getConsumo() {
		return Consumo;
	}
	public void setConsumo(float consumo) {
		Consumo = consumo;
	}
	public Long getCocheId() {
		return CocheId;
	}
	public void setCocheId(Long i) {
		this.CocheId = i;
	}


	public Escuderia getEscuderia() {
		return escuderia;
	}


	public void setEscuderia(Escuderia escuderia) {
		this.escuderia = escuderia;
	}
	
}
