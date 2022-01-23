package com.ima.fms.service.implementation;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ima.fms.service.UserService;

import com.ima.fms.entity.User;
import com.ima.fms.entity.Escuderia;
import com.ima.fms.entity.Role;
import com.ima.fms.repository.RoleRepository;
import com.ima.fms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	RoleRepository roleRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(User userReg) {

		for (int i = 0; i < userReg.getRoles().size(); i++) {

			if (userReg.getRoles().toString().equals("[Administrador]")
					|| userReg.getRoles().toString().equals("[Corresponsable]")) {

				User user = new User(userReg.getName(), userReg.getUser(), userReg.getEmail(),
						passwordEncoder.encode(userReg.getPassword()), userReg.isEnabled(), userReg.getRoles());
				return userRepository.save(user);
			}

		}
		for (int i = 0; i < userReg.getRoles().size(); i++) {
			if (userReg.getRoles().toString().equals("[Responsable]")) {
/*				Escuderia escuderia = new Escuderia();
				escuderia.setLogo("https://th.bing.com/th/id/OIP.IAcZdfxtyq4z1ts6R0AbCgHaHa?pid=ImgDet&rs=1");
				escuderia.setNombre("En espera de creación");
				escuderia.setTwitter("En espera de creación");
*/
				User user = new User(userReg.getName(), userReg.getUser(), userReg.getEmail(),
						passwordEncoder.encode(userReg.getPassword()), userReg.isEnabled(), userReg.getRoles());
/*				user.setEscuderia(escuderia);
				user.setName_escu(escuderia.getNombre());*/
				return userRepository.save(user);
			}
		}
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUser(username);

		if (user == null || user.isEnabled() == false) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
				
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public String getEmailS(Long id) {
		return getUserById(id).getEmail();
	}

	public List<Role> getRoles() {
		return roleRepo.findAll();
	}

	@Override
	public Escuderia getEscuderiaByNameUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		List<User> usuarios = userRepository.findAll();
		
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getName().equals(username)) {
				return usuarios.get(i).getEscuderia();
			}
		}
		
		return null;
	}
	
	
	public User getUserByName(String name) {
		
		List<User> usuarios = userRepository.findAll();
		
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getName().equals(name)) {
				return usuarios.get(i);
			}
		}
		
		return null;
	}
}
