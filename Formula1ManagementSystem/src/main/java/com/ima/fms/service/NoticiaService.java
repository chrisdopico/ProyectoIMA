package com.ima.fms.service;

import java.util.List;

import com.ima.fms.entity.Noticia;

public interface NoticiaService {

	List<Noticia> getAllNoticias();

	Noticia saveNoticias(Noticia noticia);

	Noticia getNoticiaById(Long id);

	Noticia updateNoticia(Noticia noticia);

	void deleteNoticiaById(Long id);
}
