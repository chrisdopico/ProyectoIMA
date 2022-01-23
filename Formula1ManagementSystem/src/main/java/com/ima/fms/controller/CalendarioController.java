package com.ima.fms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ima.fms.entity.Calendario;
import com.ima.fms.entity.Circuito;
import com.ima.fms.service.CalendarioService;
import com.ima.fms.service.CircuitoService;

import org.springframework.ui.Model;

@Controller
public class CalendarioController {

	private CalendarioService calendarioService;
	private CircuitoService circuitoService;

	public CalendarioController(CalendarioService calendarioService, CircuitoService circuitoService) {
		super();
		this.calendarioService = calendarioService;
		this.circuitoService = circuitoService;
	}

	@GetMapping("/calendarios")
	public String listCalendarios(Model model) {

		List<Calendario> calendarios = calendarioService.getAllCalendarios();

		for (int i = 0; i < calendarios.size(); ++i) {
			for (int j = 1; j < calendarios.size() - i; ++j) {
				if (calendarios.get(j - 1).getFecha().getTime() - calendarios.get(j).getFecha().getTime() > 0) {
					Calendario ci = calendarios.get(j - 1);
					Calendario cj = calendarios.get(j);
					calendarios.set(j, ci);
					calendarios.set(j - 1, cj);
				}
			}
		}

		model.addAttribute("calendarios", calendarios);
		return "views_calendario/calendarios";

	}

	@GetMapping("/calendarios_admin")
	public String listCalendariosAdmin(Model model) {
		
		List<Calendario> calendarios = calendarioService.getAllCalendarios();

		for (int i = 0; i < calendarios.size(); ++i) {
			for (int j = 1; j < calendarios.size() - i; ++j) {
				if (calendarios.get(j - 1).getFecha().getTime() - calendarios.get(j).getFecha().getTime() > 0) {
					Calendario ci = calendarios.get(j - 1);
					Calendario cj = calendarios.get(j);
					calendarios.set(j, ci);
					calendarios.set(j - 1, cj);
				}
			}
		}

		model.addAttribute("calendarios", calendarios);
		return "views_calendario/calendarios_admin";

	}

	@GetMapping("/calendarios/crear")
	public String createCalendarioForm(Model model) {
		Calendario calendario = new Calendario();
		model.addAttribute("circuitosList", circuitoService.getAllCircuitos());
		model.addAttribute("calendario", calendario);
		return "views_calendario/create_calendario";
	}

	@PostMapping("/save_evento")
	public String saveCalendario(@ModelAttribute("calendario") Calendario calendario,
			@ModelAttribute("circuito") Circuito circuito) {
		Circuito circuito_2 = circuitoService.getCircuitoById(circuito.getId());
		calendario.setCircuito(circuito_2);
		calendario.setNombre_circuito(circuito_2.getNombre());
		calendarioService.saveCalendario(calendario);
		return "redirect:/calendarios_admin";
	}

	@GetMapping("/calendarios/edit/{id}")
	public String editCalendariosForm(@PathVariable Long id, Model model) {
		model.addAttribute("circuitosList", circuitoService.getAllCircuitos());
		model.addAttribute("calendario", calendarioService.getCalendarioById(id));
		return "views_calendario/edit_calendario";
	}

	@PostMapping("/calendarios/{id}")
	public String updateCalendario(@PathVariable Long id, @ModelAttribute("calendario") Calendario calendario,
			@ModelAttribute("circuito") Circuito circuito, Model model) {

		Circuito circuito_2 = circuitoService.getCircuitoById(circuito.getId());

		Calendario calendarioExistente = calendarioService.getCalendarioById(id);
		calendarioExistente.setIdCalendario(id);
		calendarioExistente.setCiudad(calendario.getCiudad());
		calendarioExistente.setFecha(calendario.getFecha());
		calendarioExistente.setNombre(calendario.getNombre());
		calendarioExistente.setPais(calendario.getPais());
		calendarioExistente.setCircuito(circuito_2);
		calendarioExistente.setNombre_circuito(circuito_2.getNombre());

		calendarioService.updateCalendario(calendarioExistente);

		return "redirect:/calendarios_admin";
	}

	@GetMapping("/calendarios/{id}")
	public String deleteCalendario(@PathVariable Long id) {
		calendarioService.getCalendarioById(id).setCircuito(null);
		calendarioService.deleteCalendarioById(id);
		return "redirect:/calendarios_admin";
	}

}