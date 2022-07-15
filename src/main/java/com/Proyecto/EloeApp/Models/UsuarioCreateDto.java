package com.Proyecto.EloeApp.Models;

import java.util.Collection;

public class UsuarioCreateDto {

	private int usuId;
	private String username;
    private String password;
    private Collection<Rol> roles;
    

    
	public int getUsuId() {
		return usuId;
	}
	public void setUsuId(int usuId) {
		this.usuId = usuId;
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
	public Collection<Rol> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}
	
	
}
