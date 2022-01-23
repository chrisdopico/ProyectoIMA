package com.ima.fms.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
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
	private Date fecha;
	
	@Column(name= "nombre_circuito", nullable=true)
	private String nombre_circuito;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

	@JoinTable(name = "evento_circuito", joinColumns = @JoinColumn(name = "id_calendario", referencedColumnName = "idCalendario"), inverseJoinColumns = @JoinColumn(name = "id_circuito", referencedColumnName = "id"))

	Circuito circuito;
	

	public Calendario() {
		
	}
	
	public Calendario(String nombre, String pais, String ciudad, Date fecha, String nombre_circuito, Circuito circuito) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.ciudad = ciudad;
		this.fecha = fecha;
		this.circuito = circuito;
		this.nombre_circuito = nombre_circuito;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Circuito getCircuito() {
		return circuito;
	}

	public void setCircuito(Circuito circuito) {
		this.circuito = circuito;
	}

	public String getNombre_circuito() {
		return nombre_circuito;
	}

	public void setNombre_circuito(String nombre_circuito) {
		this.nombre_circuito = nombre_circuito;
	}
	
	
}
