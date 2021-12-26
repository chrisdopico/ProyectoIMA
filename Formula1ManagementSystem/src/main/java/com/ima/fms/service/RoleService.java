package com.ima.fms.service;

import java.util.List;

import com.ima.fms.entity.Role;

public interface RoleService {

	List<Role> findAll();

	Role getRoleById(Long id);

	Role updateRole(Role role);
	
	void deleteById(Long id);
}
