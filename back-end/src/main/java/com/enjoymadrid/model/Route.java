package com.enjoymadrid.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Route {
	
	interface BasicRoute {}
	
	interface PointsRoute {}
	
	interface UserRoute {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(BasicRoute.class)
	private Long id;
	
	@JsonView(BasicRoute.class)
	private String name; 
	
	@OneToMany(mappedBy = "route")
	@JsonView(PointsRoute.class)
	private List<Point> points;
	
	@ManyToOne
	@JsonView(UserRoute.class)
	private User user;
	
	public Route() {
		this.points = new LinkedList<Point>();
	}

	public Route(String name) {
		this();
		this.name = name;
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

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
