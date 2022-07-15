package com.Proyecto.EloeApp.Services;

import java.util.List;
import java.util.Optional;

import com.Proyecto.EloeApp.Models.Click;
import com.Proyecto.EloeApp.Models.ClickCreateDto;
import com.Proyecto.EloeApp.Models.RangoFechasDto;

public interface ClickService {
	Optional<Click> findById(int clickId);
	List<Click> findAll();
	List<Click> findByFechaHoraBetween(RangoFechasDto rangoFechasDto);
	public String createClick(ClickCreateDto clickCreateDto);
	public String updateClick(ClickCreateDto clickCreateDto);
	public boolean deleteClick(int id);
	
}
