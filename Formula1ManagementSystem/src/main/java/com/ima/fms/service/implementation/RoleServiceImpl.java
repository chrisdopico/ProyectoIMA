package com.ima.fms.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.fms.entity.Role;
import com.ima.fms.repository.RoleRepository;
import com.ima.fms.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@Override
	public Role getRoleById(Long id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	public void deleteById(Long id) {
		roleRepository.deleteById(id);		
	}
	
}
