package com.enjoymadrid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Point {
	
	interface BasicPoint {}
	
	interface RoutePoint {}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(BasicPoint.class)
	private Long id;
	
	@JsonView(BasicPoint.class)
	private Double longitude;
	
	@JsonView(BasicPoint.class)
	private Double latitude;
	
	@JsonView(BasicPoint.class)
	private String name;
	
	@JsonView(BasicPoint.class)
	private String address;
	
	@JsonView(BasicPoint.class)
	private String phone;
	
	@JsonView(BasicPoint.class)
	private String description;
	
	@JsonView(BasicPoint.class)
	private String email;
	
	@JsonView(BasicPoint.class)
	private String opening_hours;
	
	@JsonView(BasicPoint.class)
	private String url;
	
	@JsonView(BasicPoint.class)
	private String wheelchair;
	
	@ManyToOne
	@JsonView(RoutePoint.class)
	private Route route;
	
	public Point() {}

	public Point(Long id, Double longitude, Double latitude, String name, String address, String phone,
			String description, String email, String opening_hours, String url, String wheelchair) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.description = description;
		this.email = email;
		this.opening_hours = opening_hours;
		this.url = url;
		this.wheelchair = wheelchair;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOpening_hours() {
		return opening_hours;
	}

	public void setOpening_hours(String opening_hours) {
		this.opening_hours = opening_hours;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWheelchair() {
		return wheelchair;
	}

	public void setWheelchair(String wheelchair) {
		this.wheelchair = wheelchair;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
}
