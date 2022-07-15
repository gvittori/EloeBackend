package com.Proyecto.EloeApp.Models;

import java.time.LocalDateTime;

public class ClickCreateDto {
	
	private int clickId;
	private String ipOrigen;
	private String paisOrigen;
	private String fechaHora;
	private String clickUrl;
	private int empresaId;
	
	
	
	public int getClickId() {
		return clickId;
	}
	public void setClickId(int clickId) {
		this.clickId = clickId;
	}
	public String getIpOrigen() {
		return ipOrigen;
	}
	public void setIpOrigen(String ipOrigen) {
		this.ipOrigen = ipOrigen;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getClickUrl() {
		return clickUrl;
	}
	public void setClickUrl(String clickUrl) {
		this.clickUrl = clickUrl;
	}
	public int getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(int empresaId) {
		this.empresaId = empresaId;
	}
	
	
}
