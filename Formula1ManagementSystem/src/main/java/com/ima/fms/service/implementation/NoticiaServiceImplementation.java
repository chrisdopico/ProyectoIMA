package com.ima.fms.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.fms.entity.Noticia;
import com.ima.fms.repository.NoticiaRepository;
import com.ima.fms.service.NoticiaService;

@Service
public class NoticiaServiceImplementation implements NoticiaService {

	private NoticiaRepository noticiaRepository;

	public NoticiaServiceImplementation(NoticiaRepository noticiaRepository) {
		super();
		this.noticiaRepository = noticiaRepository;
	}

	@Override
	public List<Noticia> getAllNoticias() {
		return noticiaRepository.findAll();
	}

	@Override
	public Noticia saveNoticias(Noticia noticia) {
		return noticiaRepository.save(noticia);
	}

	@Override
	public Noticia getNoticiaById(Long id) {
		return noticiaRepository.findById(id).get();
	}

	@Override
	public Noticia updateNoticia(Noticia noticia) {
		return noticiaRepository.save(noticia);
	}

	@Override
	public void deleteNoticiaById(Long id) {
		noticiaRepository.deleteById(id);
	}

}
