package com.udemy.learn.blogging.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	String role;
	@ManyToMany(mappedBy="role")
	Set<User> user;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	public Role(long id, String role, Set<User> user) {
		super();
		this.id = id;
		this.role = role;
		this.user = user;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

}
