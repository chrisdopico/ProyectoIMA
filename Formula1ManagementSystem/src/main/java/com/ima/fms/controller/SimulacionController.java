package com.ima.fms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ima.fms.entity.Coche;
import com.ima.fms.service.CocheService;

import com.ima.fms.entity.Circuito;
import com.ima.fms.service.CircuitoService;



import org.springframework.ui.Model;

@Controller
public class SimulacionController {
	
	private CocheService cocheService;
	private CircuitoService circuitoService;


	public SimulacionController(CocheService cocheService, CircuitoService circuitoService) {
		super();
		this.cocheService = cocheService;
		this.circuitoService = circuitoService;

	}
	
	
	@GetMapping("/simulacion")
	public String simulacionIndex() {
		return "views_simulacion/simulacion";
	}
	
	@GetMapping("/simulacion/gasolina")
	public String gasolinaIndex(Model model) {
		model.addAttribute("listaCoches",cocheService.getAllCoches());
		model.addAttribute("listaCircuitos",circuitoService.getAllCircuitos());
		return "views_simulacion/gasolina";
	}
	
	@PostMapping("/simulacion/gasolina/calculo")
	public String calculoGasolina(@ModelAttribute("cocheSeleccionado") Coche coche,@ModelAttribute("circuitoSeleccionado") Circuito circuito, Model model) {
		Coche cocheEscogido = cocheService.getCocheById(coche.getCocheId());
		Circuito circuitoEscogido = circuitoService.getCircuitoById(circuito.getId());
		float totalVuelta = cocheEscogido.getConsumo()*circuitoEscogido.getLongitud()/100;
		float totalCarrera = totalVuelta*circuitoEscogido.getNumero_de_vueltas();
		
		String totalVueltaString = String.format("%.2f",totalVuelta);
		String totalCarreraString = String.format("%.2f",totalCarrera);
		
		model.addAttribute("totalVuelta", totalVueltaString);
		model.addAttribute("totalCarrera",totalCarreraString);
		return "views_simulacion/calculogasolina";
	}
	
	
	@GetMapping("/simulacion/ERS")
	public String ersIndex(Model model) {
		List<String> tipoConductor = new ArrayList<String>();
		tipoConductor.add("Ahorrador");
		tipoConductor.add("Normal");
		tipoConductor.add("Deportivo");
		model.addAttribute("listaCoches",cocheService.getAllCoches());
		model.addAttribute("listaCircuitos",circuitoService.getAllCircuitos());
		model.addAttribute("tipoConductor",tipoConductor);
		return "views_simulacion/ers";
	}
	
	@PostMapping("/simulacion/ERS/calculo")
	public String calculoERS(@RequestParam("tipoConductor") String tipoConductor,@ModelAttribute("cocheSeleccionado") Coche coche,@ModelAttribute("circuitoSeleccionado") Circuito circuito, Model model) {
		Coche cocheEscogido = cocheService.getCocheById(coche.getCocheId());
		Circuito circuitoEscogido = circuitoService.getCircuitoById(circuito.getId());
		float totalEnergia=(cocheEscogido.getERS_CurvaLenta()*circuitoEscogido.getCurvas_lentas())+(cocheEscogido.getERS_CurvaMedia()*circuitoEscogido.getCurvas_medias())+(cocheEscogido.getERS_CurvaRapida()*circuitoEscogido.getCurvas_rapidas());
		float totalAlmacenadoPorVuelta=0f;
		float totalVueltasParaCargarBateria=0f;
		if(totalEnergia>0.6f) {
			totalAlmacenadoPorVuelta=0.6f;
		}else {
			totalAlmacenadoPorVuelta=totalEnergia;
		}
		
		if(tipoConductor.equals("Ahorrador")) {
			totalAlmacenadoPorVuelta=(totalAlmacenadoPorVuelta*0.05f)+totalAlmacenadoPorVuelta;
		}else if(tipoConductor.equals("Normal")) {
			totalAlmacenadoPorVuelta=(totalAlmacenadoPorVuelta*-0.25f)+totalAlmacenadoPorVuelta;
		}else if (tipoConductor.equals("Deportivo")){
			totalAlmacenadoPorVuelta=(totalAlmacenadoPorVuelta*-0.60f)+totalAlmacenadoPorVuelta;
		}
		
		totalVueltasParaCargarBateria=1.2f/totalAlmacenadoPorVuelta;
		String totalAlmacenadoPorVueltaString = String.format("%.2f", totalAlmacenadoPorVuelta);
		String totalVueltasParaCargarBateriaString = String.format("%.2f", totalVueltasParaCargarBateria);
		
		model.addAttribute("totalAlmacenadoPorVuelta",totalAlmacenadoPorVueltaString);
		model.addAttribute("totalVueltasParaCargarBateria",totalVueltasParaCargarBateriaString);
		model.addAttribute("");
		
		return "views_simulacion/calculoers";
	}
	
	
	
	
	
	
	
	
	
}