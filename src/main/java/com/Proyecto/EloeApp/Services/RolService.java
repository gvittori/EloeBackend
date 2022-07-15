package com.Proyecto.EloeApp.Services;

import java.util.List;
import java.util.Optional;

import com.Proyecto.EloeApp.Models.Rol;
import com.Proyecto.EloeApp.Models.RolCreateDto;
import com.Proyecto.EloeApp.Util.CustomException;

public interface RolService {
	Optional<Rol> findById(int rolId);
	Optional<Rol> findByAuthority(String authority);
	List<Rol> findAll();
	public String createRol(RolCreateDto rolCreateDto) throws CustomException;
	public String updateRol(RolCreateDto rolCreateDto);
	public boolean deleteRol(int id);
}
