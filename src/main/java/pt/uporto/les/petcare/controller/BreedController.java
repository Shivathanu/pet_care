package pt.uporto.les.petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pt.uporto.les.petcare.model.Breed;
import pt.uporto.les.petcare.service.BreedService;

@RestController
public class BreedController {

	@Autowired
	private BreedService service;

	@CrossOrigin
	@GetMapping(value = "/api/breeds", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Breed> list() {
		return service.findAll();
	}

	@CrossOrigin
	@GetMapping(value = "/api/breeds/{breedId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Breed find(@PathVariable("breedId") Long breedId) {
		return service.findById(breedId).orElseThrow(() -> new RuntimeException("Breed id not found: " + breedId));
	}

	@CrossOrigin
	@GetMapping(value = "/api/breeds/species/{speciesId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Breed> getBreedsBySpeciesId(@PathVariable("speciesId") Long speciesId) {
		return service.findBySpeciesId(speciesId);
	}

}
