package pt.uporto.les.petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pt.uporto.les.petcare.model.Species;
import pt.uporto.les.petcare.service.SpeciesService;

@RestController
public class SpeciesController {

	@Autowired
	private SpeciesService service;

	@CrossOrigin
	@GetMapping(value = "/api/species", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Species> list() {
		return service.findAll();
	}
	
	@CrossOrigin
	@GetMapping(value = "/api/species/{speciesId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Species find(@PathVariable("speciesId") Long speciesId) {
		return service.findById(speciesId).orElseThrow(() -> new RuntimeException("Species id not found: " + speciesId));
	}
}
