package com.ima.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ima.fms.repository.RoleRepository;
import com.ima.fms.service.RoleService;

@Controller
public class RoleController {

	private RoleService roleService;

	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}

	@GetMapping("/rolesList")
	public String listRol(Model model) {
		model.addAttribute("rolesList", roleService.findAll());
		return "views_login/rolesList";
	}

	@GetMapping("/role/{id}")
	public String deleteRole(@PathVariable Long id) {
		roleService.deleteById(id);
		return "redirect:/rolesList";
	}
}
