package com.Proyecto.EloeApp.Models;

import java.util.Collection;

public class UsuarioUpdateDto {

	private int usuId;
	private String username;
	private String usernameUpdate;
    private String password;
    private String passwordUpdate;
    private Collection<Rol> roles;
    

    
	public String getUsernameUpdate() {
		return usernameUpdate;
	}
	public void setUsernameUpdate(String usernameUpdate) {
		this.usernameUpdate = usernameUpdate;
	}
	public String getPasswordUpdate() {
		return passwordUpdate;
	}
	public void setPasswordUpdate(String passwordUpdate) {
		this.passwordUpdate = passwordUpdate;
	}
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
