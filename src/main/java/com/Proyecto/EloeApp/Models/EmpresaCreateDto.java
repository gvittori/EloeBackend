package com.Proyecto.EloeApp.Models;

import java.util.Collection;

public class EmpresaCreateDto {

	private int empresaId;
	private String empresaNombre;
	private String empresaMail;
	private String empresaCnpj;
	private double tazaClicks;
	private Collection<Click> clicks;
	
	
	public int getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(int empresaId) {
		this.empresaId = empresaId;
	}
	public String getEmpresaNombre() {
		return empresaNombre;
	}
	public void setEmpresaNombre(String empresaNombre) {
		this.empresaNombre = empresaNombre;
	}
	public String getEmpresaMail() {
		return empresaMail;
	}
	public void setEmpresaMail(String empresaMail) {
		this.empresaMail = empresaMail;
	}
	public String getEmpresaCnpj() {
		return empresaCnpj;
	}
	public void setEmpresaCnpj(String empresaCnpj) {
		this.empresaCnpj = empresaCnpj;
	}
	public double getTazaClicks() {
		return tazaClicks;
	}
	public void setTazaClicks(double tazaClicks) {
		this.tazaClicks = tazaClicks;
	}
	public Collection<Click> getClicks() {
		return clicks;
	}
	public void setClicks(Collection<Click> clicks) {
		this.clicks = clicks;
	}
		
	
}
