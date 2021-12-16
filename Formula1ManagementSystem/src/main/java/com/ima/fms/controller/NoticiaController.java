package com.ima.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ima.fms.entity.Noticia;
import com.ima.fms.service.NoticiaService;
import org.springframework.ui.Model;

@Controller
public class NoticiaController {
	
	private NoticiaService noticiaService;

	public NoticiaController(NoticiaService noticiaService) {
		super();
		this.noticiaService = noticiaService;
	}
	
	//Metodo index page
	
	@GetMapping("/")
	public String listNoticiasIndex(Model model) {
		model.addAttribute("noticias",noticiaService.getAllNoticias());
		return "index";
		 
	}
	
	//Metodo para leer noticias
	@GetMapping("/leer/{id}")
	public String leerNoticiasForm(@PathVariable Long id,Model model) {
		model.addAttribute("noticia",noticiaService.getNoticiaById(id));
		return "views_noticias/leer_noticias";
	}
	
	
	//Metodo para obtener administración de noticias para administrador
	
	@GetMapping("/noticias")
	public String listNoticias(Model model) {
		model.addAttribute("noticias",noticiaService.getAllNoticias());
		return "views_noticias/noticias";
		 
	}
	
	
	//Metodo para obtener fomrulario de creación de noticias para administador
	
	@GetMapping("/noticias/crear")
	public String createNoticiaForm(Model model) {
		//Crear objeto noticia para guardar información del formulario
		Noticia noticia= new Noticia();
		model.addAttribute("noticia",noticia);
		return "views_noticias/create_noticia";
	}
	
	
	//Método para guardar noticias en BBDD para administrador
	
	@PostMapping("/noticias")
	public String saveNoticia(@ModelAttribute("noticia") Noticia noticia) {
		noticiaService.saveNoticias(noticia);
		return "redirect:/noticias";
	}
	
	//Metodo para obtener pantalla de editar noticias para administrador
	
	@GetMapping("/noticias/edit/{id}")
	public String editNoticiasForm(@PathVariable Long id,Model model) {
		model.addAttribute("noticia",noticiaService.getNoticiaById(id));
		return "views_noticias/edit_noticia";
	}  
	
	//Metodo para editar (guardar) noticias para administrador
	
	@PostMapping("/noticias/{id}")
	public String updateNoticia(@PathVariable Long id, @ModelAttribute("noticia") Noticia noticia, Model model) {
		//get noticia por id
		Noticia noticiaExistente = noticiaService.getNoticiaById(id);
		noticiaExistente.setId(id);
		noticiaExistente.setTitulo(noticia.getTitulo());
		noticiaExistente.setTexto(noticia.getTexto());
		noticiaExistente.setLink(noticia.getLink());
		noticiaExistente.setImagen(noticia.getImagen());
		
		noticiaService.updateNoticia(noticiaExistente);
	
		return "redirect:/noticias";
	}
	
	//Metodo para eliminar noticias para el administrador
	
	@GetMapping("/noticias/{id}")
	public String deleteNoticia(@PathVariable Long id) {
		noticiaService.deleteNoticiaById(id);
		return "redirect:/noticias";
	}
	
	
}