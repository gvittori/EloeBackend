package com.Proyecto.EloeApp.Services;

import java.util.List;
import java.util.Optional;

import com.Proyecto.EloeApp.Models.Usuario;
import com.Proyecto.EloeApp.Models.UsuarioCreateDto;
import com.Proyecto.EloeApp.Models.UsuarioUpdateDto;
import com.Proyecto.EloeApp.Util.CustomException;

public interface UsuarioService {
	Optional<Usuario> findByUsername(String username);
	List<Usuario> findAll();
	public String createUsuario(UsuarioCreateDto usuarioCreateDto) throws CustomException;
	public String updateUsuario(UsuarioUpdateDto usuarioUpdateDto) throws CustomException;
	public boolean deleteUsuario(String username) throws CustomException;
}
