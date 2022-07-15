package com.Proyecto.EloeApp.Controllers;

import java.util.List;

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

import com.Proyecto.EloeApp.Models.Click;
import com.Proyecto.EloeApp.Models.ClickCreateDto;
import com.Proyecto.EloeApp.Models.RangoFechasDto;
import com.Proyecto.EloeApp.Services.ClickService;

@RestController
@RequestMapping("api")
public class ClickController {

	@Autowired
	private ClickService clickService;
	
	@GetMapping(value = "/clicks", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })	
	public ResponseEntity<List<Click>> getClicks() {
        return ResponseEntity.ok(clickService.findAll());
    }
	
	@GetMapping(value = "/clicks/rango", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })	
	public ResponseEntity<List<Click>> getClicksRango(@RequestBody RangoFechasDto rangoFechasDto) {
        return ResponseEntity.ok(clickService.findByFechaHoraBetween(rangoFechasDto));
    }
	
	@PostMapping(value = "/clicks/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createClick(@RequestBody ClickCreateDto clickCreateDto){
        return new ResponseEntity<>(clickService.createClick(clickCreateDto), HttpStatus.CREATED);
    }
	
	@PutMapping(value = "/clicks/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> updateClick(@RequestBody ClickCreateDto clickCreateDto){
        return new ResponseEntity<>(clickService.updateClick(clickCreateDto), HttpStatus.CREATED);
    }
	
	@PostMapping(value = "/clicks/delete")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> deleteClick(@RequestBody int id){
        return new ResponseEntity<>(clickService.deleteClick(id), HttpStatus.CREATED);
    }
}
