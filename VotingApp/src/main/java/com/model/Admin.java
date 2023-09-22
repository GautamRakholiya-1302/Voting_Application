package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String password;

@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
@JoinTable(
		name = "admins_roles",
		joinColumns = {@JoinColumn(name = "aid")},
		inverseJoinColumns = {@JoinColumn(name = "rid")}
		)
List<Role> roles = new ArrayList<>();

public Admin() {
	
}

public Admin(int id, String name, String password, List<Role> roles) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.roles = roles;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public List<Role> getRoles() {
	return roles;
}

public void setRoles(List<Role> roles) {
	this.roles = roles;
}

@Override
public String toString() {
	return "Admin [id=" + id + ", name=" + name + ", password=" + password + ", roles=" + roles + "]";
}


	

}
