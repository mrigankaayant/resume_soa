package com.ayantsoft.resume.pojo;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class UserMst implements Serializable {
	
	/**
	 *serialVersionUID 
	 */
	private static final long serialVersionUID = -2671860557233971483L;
	
	private String name;
	private String username;
	private String password;
	private Boolean active;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
}