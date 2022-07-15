package com.Proyecto.EloeApp.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6061795685690041644L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Usuid")
	private int usuId;
	
	@Column(name = "Usunombre")
	private String username;
	
	@Column(name = "Usupassword")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name="Usuariorol", joinColumns = @JoinColumn(name = "Usuid"), inverseJoinColumns = @JoinColumn(name = "Rolid"))
	private Collection<Rol> roles;
	
	public Usuario() {
		
	}
	
	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Usuario(String username, String password, Collection<Rol> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	
	
	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> collection) {
		this.roles = collection;
	}

	public int getUsuId() {
		return usuId;
	}

	public void setUsuId(int usuId) {
		this.usuId = usuId;
	}

	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<Rol> roles = this.roles;
		return roles;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
