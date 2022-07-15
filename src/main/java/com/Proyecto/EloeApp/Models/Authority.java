package com.Proyecto.EloeApp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Authority implements GrantedAuthority {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8338501134974696640L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String authority;
	@ManyToOne(optional = false )  
	private Usuario user;

	
	public Authority() {}
	
	public Authority(String authority) {
		this.authority = authority;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		authority = authority;
	}
	
	
}
