package pt.uporto.les.petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pt.uporto.les.petcare.model.Breed;
import pt.uporto.les.petcare.model.user.Region;
import pt.uporto.les.petcare.service.RegionService;

@RestController
public class RegionController {

	@Autowired
	private RegionService service;

	@CrossOrigin
	@GetMapping(value = "/api/region", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Region> list() {
		return service.findAll();
	}

	@CrossOrigin
	@GetMapping(value = "/api/region/{regionId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Region find(@PathVariable("regionId") Long regionId) {
		return service.findById(regionId).orElseThrow(() -> new RuntimeException("Region id not found: " + regionId));
	}
	
	/*
	 * @GetMapping(value = "/api/region/{regionName}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public Region
	 * find(@PathVariable("regionName") String regionName) { return
	 * service.findByName(regionName).orElseThrow(() -> new
	 * RuntimeException("Region name not found: " + regionName)); }
	 */
	@CrossOrigin
	@GetMapping(value = "/api/region/country/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Region> getRegionsByCountryId(@PathVariable("countryId") Long countryId) {
		return service.findByCountryId(countryId);
	}
}
