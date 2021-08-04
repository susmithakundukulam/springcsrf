package com.ocp.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "users")
public class Users implements Serializable{
	
	//@Column(name = "username")
	private String username;
	
	//@Column(name = "password")
	private String password;
	
	//@Column(name = "enabled")
	private int enabled;
	
	//@Column(name = "role")
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) { 
		this.username = username;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
