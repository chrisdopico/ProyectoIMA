package com.ima.fms.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "user")
//(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "user"))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;

	@Column(name = "name")
	private String name;

	@Column(name = "user")
	private String user;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "name_escu")
	private String name_escu;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))

	Collection<Role> roles;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

	@JoinTable(name = "users_escuderia", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "escuderia_id", referencedColumnName = "id"))

	Escuderia escuderia;

	public User() {

	}

	public User(String name, String user, String email, String password, Boolean enabled, Collection<Role> roles, Escuderia escuderia, String name_escu) {
		super();
		this.name = name;
		this.user = user;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
		this.escuderia = escuderia;
		this.name_escu = name_escu;
	}
	
	public User(String name, String user, String email, String password, Boolean enabled, Collection<Role> roles) {
		super();
		this.name = name;
		this.user = user;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}

	public Long getId() {
		return user_id;
	}

	public void setId(Long id) {
		this.user_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Escuderia getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(Escuderia escuderia) {
		this.escuderia = escuderia;
	}

	public String getName_escu() {
		return name_escu;
	}

	public void setName_escu(String name_escu) {
		this.name_escu = name_escu;
	}

}