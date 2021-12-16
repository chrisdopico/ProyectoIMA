package com.ima.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ima.fms.repository.RoleRepository;

@Controller
public class RoleController {

	private RoleRepository roleRepository;

	public RoleController(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@GetMapping("/rolesList")
	public String listRol(Model model) {
		model.addAttribute("rolesList", roleRepository.findAll());
		return "views_login/rolesList";
	}

	@GetMapping("/role/{id}")
	public String deleteRole(@PathVariable Long id) {
		roleRepository.deleteById(id);
		return "redirect:/rolesList";
	}
}
