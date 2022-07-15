package com.Proyecto.EloeApp.Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "Click")
public class Click {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Clickid")
	private int clickId;
	
	@Column(name = "Iporigen")
	private String ipOrigen;
	
	@Column(name = "Paisorigen")
	private String paisOrigen;
	
	@Column(name = "Fechahora")
	private LocalDateTime fechaHora;
	
	@Column(name = "Clickurl")
	private String clickUrl;
	
	@ManyToOne
    @JoinColumn(name="Empresaid", nullable=false)
    private Empresa empresa;

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
		DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return dateFormater.format(fechaHora).toString();
	}
	
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public LocalDateTime dateTime() {
		return fechaHora;
	}

	public String getClickUrl() {
		return clickUrl;
	}

	public void setClickUrl(String clickUrl) {
		this.clickUrl = clickUrl;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	
	
	

}
