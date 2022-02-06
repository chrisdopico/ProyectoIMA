package com.ima.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="t_noticias")
public class Noticia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "titulo", nullable=false)
	private String titulo;
	@Column(name= "texto", nullable=false, length = 999999)
	private String texto;
	@Column(name= "link", nullable=true, length = 999999)
	private String link;
	@Column(name= "imagen", nullable=false, length = 999999)
	private String imagen;
	
	
	public Noticia(){
		
	}
	
	public Noticia(String titulo, String texto, String link, String imagen) {
		super();
		this.titulo = titulo;
		this.texto = texto;
		this.link = link;
		this.imagen= imagen;
	}
	public Long getId() {
		return id;
	}
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}