package com.Proyecto.EloeApp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proyecto.EloeApp.Models.Rol;
import com.Proyecto.EloeApp.Models.RolCreateDto;
import com.Proyecto.EloeApp.Repositorios.RolRepository;
import com.Proyecto.EloeApp.Util.CustomException;

@Service
public class RolServiceImpl implements RolService{
	
	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public Optional<Rol> findById(int rolId) {
		return rolRepository.findById(rolId);
	}
	
	@Override
	public Optional<Rol> findByAuthority(String authority) {
		return rolRepository.findByAuthority(authority);
	}

	@Override
	public List<Rol> findAll() {
		return rolRepository.findAll();
	}

	@Override
	public String createRol(RolCreateDto rolCreateDto) throws CustomException{
		String authority = rolCreateDto.getAuthority();
		if(authority.length()==0) throw new CustomException("Nombre de rol invalido");
		if(findByAuthority(authority).orElse(null) != null) throw new CustomException("Rol ya existe");
		Rol nuevoRol = new Rol();			
		nuevoRol.setAuthority(authority);
		return rolRepository.save(nuevoRol).getAuthority();
	}

	@Override
	public String updateRol(RolCreateDto rolCreateDto) {
		Rol rol = rolRepository.findById(rolCreateDto.getRolId()).orElse(null);
		if(!rol.equals(null)) {
			String authority = rolCreateDto.getAuthority();
			if (authority.length()>0) {
				rol.setAuthority(authority);
			}
			return rolRepository.save(rol).getAuthority();
		}
		return null;
	}

	@Override
	public boolean deleteRol(int id) {
		if(rolRepository.existsById(id)) {
			rolRepository.deleteById(id);
		}
		return false;
	}

}
