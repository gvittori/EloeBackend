package com.Proyecto.EloeApp.Controllers;

import java.util.List;
import java.util.Optional;

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

import com.Proyecto.EloeApp.Models.Empresa;
import com.Proyecto.EloeApp.Models.EmpresaCreateDto;
import com.Proyecto.EloeApp.Models.EmpresaUpdateDto;
import com.Proyecto.EloeApp.Services.EmpresaService;
import com.Proyecto.EloeApp.Util.CustomException;

@RestController
@RequestMapping("api")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping(value = "/empresas", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })	
	public ResponseEntity<List<Empresa>> getEmpresas() {
        return ResponseEntity.ok(empresaService.findAll());
    }
	
	@PostMapping(value = "/empresas/clicks", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })	
	public ResponseEntity<?> getClicksEmpresa(@RequestBody Integer empresaId) {
		Optional<Empresa> emp = empresaService.findById(empresaId);
		return ResponseEntity.ok(emp.get().getClicks());
    }
	
	@PostMapping(value = "/empresas/create")
	@RolesAllowed({"ROLE_ADMIN", "ROLE_MANTENIMIENTO"})
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createEmpresa(@RequestBody EmpresaCreateDto empresaCreateDto){
        try {
			return new ResponseEntity<>(empresaService.createEmpresa(empresaCreateDto), HttpStatus.CREATED);
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }
	
	@PutMapping(value = "/empresas/update")
	@RolesAllowed({"ROLE_ADMIN", "ROLE_MANTENIMIENTO"})
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> updateEmpresa(@RequestBody EmpresaUpdateDto empresaUpdateDto){
        try {
			return new ResponseEntity<>(empresaService.updateEmpresa(empresaUpdateDto), HttpStatus.CREATED);
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }
	
	@PostMapping(value = "/empresas/delete")
	@RolesAllowed({"ROLE_ADMIN", "ROLE_MANTENIMIENTO"})
	@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> deleteEmpresa(@RequestBody String empresaNombre){
        try {
			return new ResponseEntity<>(empresaService.deleteEmpresa(empresaNombre), HttpStatus.CREATED);
		} catch (CustomException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
    }
	
	
	
}

