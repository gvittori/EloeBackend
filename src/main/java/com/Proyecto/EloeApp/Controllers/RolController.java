package com.Proyecto.EloeApp.Controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Proyecto.EloeApp.Models.Rol;
import com.Proyecto.EloeApp.Models.RolCreateDto;
import com.Proyecto.EloeApp.Services.RolService;
import com.Proyecto.EloeApp.Util.CustomException;

@RestController
@RequestMapping("api")
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	@GetMapping(value = "/roles", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })	
	@RolesAllowed({"ROLE_ADMIN", "ROLE_MANTENIMIENTO"})
	public ResponseEntity<List<Rol>> getRoles() {
        return ResponseEntity.ok(rolService.findAll());
    }
	
	@PostMapping(value = "/roles/create")
	@RolesAllowed({"ROLE_ADMIN", "ROLE_MANTENIMIENTO"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createRol(@RequestBody RolCreateDto rolCreateDto){
        try {
			return new ResponseEntity<>(rolService.createRol(rolCreateDto), HttpStatus.CREATED);
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }
	
	@PutMapping(value = "/roles/update")
	@RolesAllowed({"ROLE_ADMIN", "ROLE_MANTENIMIENTO"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> updateRol(@RequestBody RolCreateDto rolCreateDto){
        return new ResponseEntity<>(rolService.updateRol(rolCreateDto), HttpStatus.CREATED);
    }
	
	@PostMapping(value = "/roles/delete")
	@RolesAllowed({"ROLE_ADMIN", "ROLE_MANTENIMIENTO"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> deleteRol(@RequestBody int id){
        return new ResponseEntity<>(rolService.deleteRol(id), HttpStatus.CREATED);
    }

}
