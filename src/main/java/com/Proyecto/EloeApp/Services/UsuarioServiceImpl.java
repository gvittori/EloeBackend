package com.Proyecto.EloeApp.Services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Proyecto.EloeApp.Models.Rol;
import com.Proyecto.EloeApp.Models.Usuario;
import com.Proyecto.EloeApp.Models.UsuarioCreateDto;
import com.Proyecto.EloeApp.Models.UsuarioUpdateDto;
import com.Proyecto.EloeApp.Repositorios.UsuarioRepository;
import com.Proyecto.EloeApp.Util.CustomException;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private PasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}

	@Override
	public String createUsuario(UsuarioCreateDto usuarioCreateDto) throws CustomException{
		String nombre = usuarioCreateDto.getUsername();
		String password = usuarioCreateDto.getPassword();
		Collection<Rol> roles = usuarioCreateDto.getRoles();
		
		if(findByUsername(nombre).orElse(null) != null) throw new CustomException("Usuario ya existe");
		if(nombre.length()==0) throw new CustomException("Nombre de usuario invalido");
		if(password.length()==0) throw new CustomException("Contraseña invalida");
		if (roles == null)  throw new CustomException("Seleccione un rol");
		
		Usuario nuevoUsuario = new Usuario();
		nuevoUsuario.setUsername(nombre);
		nuevoUsuario.setPassword(encoder.encode(password));
		nuevoUsuario.setRoles(roles);

        return usuarioRepository.save(nuevoUsuario).getUsername();
	}

	@Override
	public String updateUsuario(UsuarioUpdateDto usuarioUpdateDto) throws CustomException{
		Usuario usuario = findByUsername(usuarioUpdateDto.getUsername()).orElse(null);
		if (usuario == null) throw new CustomException("Usuario no existe");
		
		String nombre = usuarioUpdateDto.getUsernameUpdate();
		String password = usuarioUpdateDto.getPasswordUpdate();
		Collection<Rol> roles = usuarioUpdateDto.getRoles();
		if (nombre.length() > 0) {
			usuario.setUsername(nombre);
		}
		if (password.length() > 0) {
			usuario.setPassword(encoder.encode(usuarioUpdateDto.getPassword()));
		}
		if (roles.size() > 0) {
			usuario.setRoles(usuarioUpdateDto.getRoles());
		}
		return usuarioRepository.save(usuario).getUsername();
		
	}

	@Override
	public boolean deleteUsuario(String username) throws CustomException {
		if(findByUsername(username).orElse(null) == null) throw new CustomException("Usuario no existe");
		usuarioRepository.deleteByUsername(username);
		return true;
	}

	

}
