package com.ima.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="t_circuitos")
public class Circuito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "nombre", nullable=false)
	private String nombre;
	
	@Column(name= "ciudad", nullable=false)
	private String ciudad;
	
	@Column(name= "pais", nullable=false)
	private String pais;
	
	@Column(name= "trazado", nullable=false, length = 999999)
	private String trazado;
	
	@Column(name= "numero_de_vueltas", nullable=false)
	private Long numero_de_vueltas;
	
	@Column(name= "longitud", nullable=false)
	private float longitud;
	
	@Column(name= "curvas_lentas", nullable=false)
	private Long curvas_lentas;
	
	@Column(name= "curvas_medias", nullable=false)
	private Long curvas_medias;
	
	@Column(name= "curvas_rapidas", nullable=false)
	private Long curvas_rapidas;
	
	public Circuito () {
		
	}

	public Circuito(String nombre, String ciudad, String pais, String trazado, Long numero_de_vueltas, float longitud,
			Long curvas_lentas, Long curvas_medias, Long curvas_rapidas) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.trazado = trazado;
		this.numero_de_vueltas = numero_de_vueltas;
		this.longitud = longitud;
		this.curvas_lentas = curvas_lentas;
		this.curvas_medias = curvas_medias;
		this.curvas_rapidas = curvas_rapidas;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTrazado() {
		return trazado;
	}

	public void setTrazado(String trazado) {
		this.trazado = trazado;
	}

	public Long getNumero_de_vueltas() {
		return numero_de_vueltas;
	}

	public void setNumero_de_vueltas(Long numero_de_vueltas) {
		this.numero_de_vueltas = numero_de_vueltas;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public Long getCurvas_lentas() {
		return curvas_lentas;
	}

	public void setCurvas_lentas(Long curvas_lentas) {
		this.curvas_lentas = curvas_lentas;
	}

	public Long getCurvas_medias() {
		return curvas_medias;
	}

	public void setCurvas_medias(Long curvas_medias) {
		this.curvas_medias = curvas_medias;
	}

	public Long getCurvas_rapidas() {
		return curvas_rapidas;
	}

	public void setCurvas_rapidas(Long curvas_rapidas) {
		this.curvas_rapidas = curvas_rapidas;
	}
}
