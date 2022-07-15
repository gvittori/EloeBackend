package com.Proyecto.EloeApp.Controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.Proyecto.EloeApp.Models.Usuario;
import com.Proyecto.EloeApp.Models.UsuarioCreateDto;
import com.Proyecto.EloeApp.Models.UsuarioUpdateDto;
import com.Proyecto.EloeApp.Services.UsuarioService;
import com.Proyecto.EloeApp.Util.CustomException;

@RestController
@RequestMapping("api")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/usuarios", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })	
	@RolesAllowed({"ROLE_ADMIN"})
	public ResponseEntity<List<Usuario>> getUsuarios() {
        return ResponseEntity.ok(usuarioService.findAll());
    }
	

	@PostMapping(value = "/usuarios/create")
	@RolesAllowed({"ROLE_ADMIN"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUsuario(@RequestBody UsuarioCreateDto usuarioCreateDto){
        try {
			return new ResponseEntity<>(usuarioService.createUsuario(usuarioCreateDto), HttpStatus.CREATED);
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }
	

	@PutMapping(value = "/usuarios/update")
	@RolesAllowed({"ROLE_ADMIN"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> updateUsuario(@RequestBody UsuarioUpdateDto usuarioUpdateDto){
        try {
			return new ResponseEntity<>(usuarioService.updateUsuario(usuarioUpdateDto), HttpStatus.CREATED);
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }
	

	@PostMapping(value = "/usuarios/delete")
	@RolesAllowed({"ROLE_ADMIN"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> deleteUsuario(@RequestBody String username){
        try {
			return new ResponseEntity<>(usuarioService.deleteUsuario(username), HttpStatus.CREATED);
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }
	
}














