package com.ima.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_calendario")
public class Calendario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCalendario;
	
	@Column(name= "nombre_evento", nullable=false)
	private String nombre;
	
	@Column(name= "pais", nullable=false)
	private String pais;
	
	@Column(name= "ciudad", nullable=false)
	private String ciudad;
	
	@Column(name= "fecha", nullable=false)
	private String fecha;

	public Calendario() {
		
	}
	
	public Calendario(String nombre, String pais, String ciudad, String fecha) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.ciudad = ciudad;
		this.fecha = fecha;
	}
	
	

	public Long getIdCalendario() {
		return idCalendario;
	}

	public void setIdCalendario(Long idCalendario) {
		this.idCalendario = idCalendario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
