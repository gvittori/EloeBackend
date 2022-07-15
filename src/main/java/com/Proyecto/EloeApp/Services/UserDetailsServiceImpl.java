package com.Proyecto.EloeApp.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Proyecto.EloeApp.Models.Usuario;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		Optional<Usuario> usuarioOpt = usuarioServiceImpl.findByUsername(username);
		return usuarioOpt.orElseThrow(()->new UsernameNotFoundException("Credenciales invalidas"));
		/*Usuario user = new Usuario();
		user.setUsername(username);
		user.setPassword(passwordEncoder.getPasswordEncoder().encode(username));
		user.setUsuId(1);
		return user;*/
	}

}
