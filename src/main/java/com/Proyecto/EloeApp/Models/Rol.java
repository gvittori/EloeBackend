package com.Proyecto.EloeApp.Models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="Rol")
public class Rol implements GrantedAuthority{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4562526829709849322L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Rolid")
	private Long rolId;
	
	@Column(name = "Rolnombre")
	private String authority;
	
	
	public Rol() {
		
	}
	
	public Rol(String authority) {
		this.authority = authority;
	}

	public Long getRolId() {
		return rolId;
	}

	public void setRolId(Long rolId) {
		this.rolId = rolId;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	
	

}
