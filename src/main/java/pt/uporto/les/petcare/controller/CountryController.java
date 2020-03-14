package pt.uporto.les.petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pt.uporto.les.petcare.model.user.Country;
import pt.uporto.les.petcare.service.CountryService;

@RestController
public class CountryController {
	@Autowired
	private CountryService service;

	@CrossOrigin
	@GetMapping(value = "/api/country", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Country> list() {
		return service.findAll();
	}
	
	@CrossOrigin
	@GetMapping(value = "/api/country/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Country find(@PathVariable("countryId") Long countryId) {
		return service.findById(countryId).orElseThrow(() -> new RuntimeException("Country id not found: " + countryId));
	}
}
