package com.Proyecto.EloeApp.Models;

import java.time.LocalDate;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "Empresa")
public class Empresa {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Empresaid")
	private int empresaId;
	
	@Column(name = "Empresanombre")
	private String empresaNombre;
	
	@Column(name = "Empresamail")
	private String empresaMail;
	
	@Column(name = "Empresacnpj")
	private String empresaCnpj;
	
	@Column(name = "Empresataza")
	private double tazaClicks;
		
	@Transient
	private double deuda;
	
	@Transient
	private double totalAnual;
	
	
	@OneToMany(mappedBy="empresa")
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
	
	public double getDeuda() {
		double contador = 0.0;
		for (Click click : clicks) {
			if(click.dateTime().getMonth() == LocalDate.now().getMonth()) {
				contador++;
			}
		}
		return contador*tazaClicks;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}
	
	
	
	public double getTotalAnual() {
		double contador = 0.0;
		for (Click click : clicks) {
			if(click.dateTime().getYear() == LocalDate.now().getYear()) {
				contador++;
			}
		}
		return contador*tazaClicks;
	}

	public void setTotalAnual(double totalAnual) {
		this.totalAnual = totalAnual;
	}

	public double getTazaClicks() {
		return tazaClicks;
	}

	public void setTazaClicks(double tazaClicks) {
		this.tazaClicks = tazaClicks;
	}
	
	public String getEmpresaCnpj() {
		return empresaCnpj;
	}

	public void setEmpresaCnpj(String empresaCnpj) {
		this.empresaCnpj = empresaCnpj;
	}

	public Collection<Click> getClicks() {
		return clicks;
	}

	public void setClicks(Collection<Click> clicks) {
		this.clicks = clicks;
	}

	

	
	
	
	

}
