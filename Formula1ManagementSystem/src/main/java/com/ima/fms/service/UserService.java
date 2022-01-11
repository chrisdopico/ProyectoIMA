package com.ima.fms.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ima.fms.entity.Escuderia;
import com.ima.fms.entity.Role;
import com.ima.fms.entity.User;

public interface UserService extends UserDetailsService {

	List<User> getAllUsers();

	User getUserById(Long id);
	
	User getUserByName(String name);
	
	Escuderia getEscuderiaByNameUser();

	String getEmailS(Long id);

	User updateUser(User user);

	void deleteUserById(Long id);
	
	User save(User user);

	List<Role> getRoles();
}
