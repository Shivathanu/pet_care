package pt.uporto.les.petcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.uporto.les.petcare.model.dto.input.PetSitterInputDto;
import pt.uporto.les.petcare.model.dto.output.PetSitterOutputDto;
import pt.uporto.les.petcare.model.user.PetSitter;
import pt.uporto.les.petcare.repository.RegionRepository;
import pt.uporto.les.petcare.service.PetSitterService;

import java.util.List;

@RestController
public class PetSitterController {
	@Autowired
	private PetSitterService petSitterService;

	@Autowired
	private RegionRepository regionRepository;

	@CrossOrigin
	@GetMapping(value = "/api/pet_sitter", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PetSitterOutputDto> list() {
		return PetSitterOutputDto.listFrom(petSitterService.findAll());
	}

	@CrossOrigin
	@GetMapping(value = "/api/pet_sitter/find/{region}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PetSitterOutputDto> findByRegionAndPeriod(@PathVariable("region") String region) {
		return PetSitterOutputDto.listFrom(petSitterService.findAllByRegionAndPeriod(region));
	}
	
	@CrossOrigin
	@GetMapping(value = "/api/pet_sitter/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PetSitter find(@PathVariable("id") Long id) {
		return petSitterService.findById(id).orElseThrow(() -> new RuntimeException("Not found id:" + id));
	}
	
	@CrossOrigin
	@GetMapping(value = "/api/pet_sitter/{id}/image", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getImage(@PathVariable("id") Long id) {
		return petSitterService.getImage(id);
	}
	
	@CrossOrigin
	@PostMapping(value = "/api/pet_sitter", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody PetSitterInputDto petSitterInputDto) {
		PetSitter petSitterSaved = this.petSitterService.save(petSitterInputDto.build(regionRepository));
		return ResponseEntity.ok(petSitterSaved);
	}
	
	@CrossOrigin
	@PutMapping(value = "/api/pet_sitter", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody PetSitterInputDto petSitterInputDto) {
		petSitterService.update(petSitterInputDto.build(regionRepository));
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/api/pet_sitter/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {

		try {
			this.petSitterService.delete(id);
			return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
		} catch (RuntimeException exception) {
			return new ResponseEntity<String>("DELETE Response", HttpStatus.BAD_REQUEST);
		}
	}
}
