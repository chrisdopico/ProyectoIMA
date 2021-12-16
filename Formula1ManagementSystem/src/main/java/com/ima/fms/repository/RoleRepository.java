package com.ima.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ima.fms.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	List<Role> findAll();
}
