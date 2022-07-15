package com.Proyecto.EloeApp.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto.EloeApp.Models.LoginDto;
import com.Proyecto.EloeApp.Models.Rol;
import com.Proyecto.EloeApp.Models.Usuario;
import com.Proyecto.EloeApp.Util.JwtUtil;

@RestController
@RequestMapping("api/auth/")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody LoginDto request) {
		try {
			Authentication authenticate = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

			Usuario usuario = (Usuario) authenticate.getPrincipal();
			usuario.setPassword(null);
			usuario.setRoles((Collection<Rol>) authenticate.getAuthorities());
			return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtUtil.generateToken(usuario)).body(usuario);
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
