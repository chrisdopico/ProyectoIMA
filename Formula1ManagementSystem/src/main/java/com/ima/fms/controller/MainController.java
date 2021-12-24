package com.ima.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "views_login/login";
	}
	
	@GetMapping("/administrar")
	public String Admin() {
		return "views_usuarios/administrar";
	}
	
	@GetMapping("/responsable")
	public String Resp() {
		return "views_usuarios/responsable";
	}
}