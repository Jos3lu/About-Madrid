package com.enjoymadrid.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class User {
	
	interface BasicUser {}
	
	interface RoutesUser {}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(BasicUser.class)
	private Long id;
	
	@JsonView(BasicUser.class)
	private String name;
	
	@JsonView(BasicUser.class)
	private String email;
	
	@JsonView(BasicUser.class)
	private String password;
	
	@JsonView(BasicUser.class)
	private List<String> comments;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonView(RoutesUser.class)
	private List<Route> routes;
	
	public User() {
		this.comments = new LinkedList<String>();
		this.routes = new LinkedList<Route>();
	}

	public User(Long id, String name, String email, String password, String... comments) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.comments = new LinkedList<>(Arrays.asList(comments));
		this.routes = new LinkedList<Route>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		this.password = new BCryptPasswordEncoder().encode(password);
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

}
