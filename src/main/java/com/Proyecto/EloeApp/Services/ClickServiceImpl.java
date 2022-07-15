package com.Proyecto.EloeApp.Services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.EloeApp.Models.Click;
import com.Proyecto.EloeApp.Models.ClickCreateDto;
import com.Proyecto.EloeApp.Models.Empresa;
import com.Proyecto.EloeApp.Models.RangoFechasDto;
import com.Proyecto.EloeApp.Repositorios.ClickRepository;
import com.Proyecto.EloeApp.Repositorios.EmpresaRepository;

@Service
public class ClickServiceImpl implements ClickService{

	@Autowired
	private ClickRepository clickRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Override
	public Optional<Click> findById(int clickId) {
		return clickRepository.findById(clickId);
	}

	@Override
	public List<Click> findAll() {
		return clickRepository.findAll();
	}
	
	@Override
	public List<Click> findByFechaHoraBetween(RangoFechasDto rangoFechasDto) {
		LocalDateTime inicio = LocalDateTime.parse(rangoFechasDto.getFechaInicio(),formatter);
		LocalDateTime fin = LocalDateTime.parse(rangoFechasDto.getFechaFin(),formatter);
		return clickRepository.findByFechaHoraBetween(inicio, fin);
	}
	
	
	@Override
	public String createClick(ClickCreateDto clickCreateDto) {
		Click nuevoClick = new Click();
		Empresa empresa = empresaRepository.findById(clickCreateDto.getEmpresaId()).orElse(null);
		if(!empresa.equals(null)) {
			nuevoClick.setClickUrl(clickCreateDto.getClickUrl());
			nuevoClick.setFechaHora(LocalDateTime.parse(clickCreateDto.getFechaHora(),formatter));
			nuevoClick.setIpOrigen(clickCreateDto.getIpOrigen());
			nuevoClick.setPaisOrigen(clickCreateDto.getPaisOrigen());
			nuevoClick.setEmpresa(empresa);
		}
		
		return clickRepository.save(nuevoClick).getFechaHora();
	}

	@Override
	public String updateClick(ClickCreateDto clickCreateDto) {
		Click click = clickRepository.findById(clickCreateDto.getClickId()).orElse(null);
		if(!click.equals(null)) {
			String url = clickCreateDto.getClickUrl();
			String fecha = clickCreateDto.getFechaHora();
			String ip = clickCreateDto.getIpOrigen();
			String pais = clickCreateDto.getPaisOrigen();
			if(url.length()>0) {
				click.setClickUrl(url);
			}
			if(fecha.length()>0) {
				click.setFechaHora(LocalDateTime.parse(clickCreateDto.getFechaHora(),formatter));
			}
			if(ip.length()>0) {
				click.setIpOrigen(ip);
			}
			if(pais.length()>0) {
				click.setPaisOrigen(pais);
			}
			return clickRepository.save(click).getFechaHora();
		}
		return null;
	}

	@Override
	public boolean deleteClick(int id) {
		if(clickRepository.existsById(id)) {
			clickRepository.deleteById(id);
			return true;
		}
		return false;
	}


}
