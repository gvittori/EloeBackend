package com.Proyecto.EloeApp.Models;

import java.util.Collection;

public class EmpresaUpdateDto {

	private int empresaId;
	private String nombre;
	private String nombreUpdate;
	private String emailUpdate;
	private String cnpjUpdate;
	private double tazaUpdate;
	public int getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(int empresaId) {
		this.empresaId = empresaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreUpdate() {
		return nombreUpdate;
	}
	public void setNombreUpdate(String nombreUpdate) {
		this.nombreUpdate = nombreUpdate;
	}
	public String getEmailUpdate() {
		return emailUpdate;
	}
	public void setEmailUpdate(String emailUpdate) {
		this.emailUpdate = emailUpdate;
	}
	public String getCnpjUpdate() {
		return cnpjUpdate;
	}
	public void setCnpjUpdate(String cnpjUpdate) {
		this.cnpjUpdate = cnpjUpdate;
	}
	public double getTazaUpdate() {
		return tazaUpdate;
	}
	public void setTazaUpdate(double tazaUpdate) {
		this.tazaUpdate = tazaUpdate;
	}
	
	
}
