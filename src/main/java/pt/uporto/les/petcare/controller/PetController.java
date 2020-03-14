package pt.uporto.les.petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pt.uporto.les.petcare.model.Pet;
import pt.uporto.les.petcare.model.dto.input.PetInputDto;
import pt.uporto.les.petcare.service.PetService;

@RestController
public class PetController {

	@Autowired
	private PetService service;

	@CrossOrigin
	@GetMapping(value = "/api/pet-management/pets", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pet> list() {
		return service.findAll();
	}

	@CrossOrigin
	@GetMapping(value = "/api/pet-management/pets/{petId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pet find(@PathVariable("petId") Long petId) {
		return service.findById(petId).orElseThrow(() -> new RuntimeException("Pet id not found: " + petId));
	}

	@CrossOrigin
	@PostMapping(value = "/api/pet-management/pets", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody PetInputDto petInputDto) {
		Pet savedPet = this.service.save(petInputDto.build());

		return ResponseEntity.ok(savedPet);
	}

	@CrossOrigin
	@PutMapping(value = "/api/pet-management/pets", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody PetInputDto petInputDto) {
		service.update(petInputDto.build());
	}

	@CrossOrigin
	@DeleteMapping(value = "/api/pet-management/pets/{petId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("petId") Long petId) {
		try {
			service.delete(petId);

			return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<String>("DELETE Response", HttpStatus.BAD_REQUEST);
		}

	}
	
	@CrossOrigin
	@GetMapping(value = "/api/pet-management/pets/petOwner/{petOwnerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pet> findPetsByPetOwnerId(@PathVariable("petOwnerId") Long petOwnerId) {
		return service.findPetsByPetOwnerId(petOwnerId);
	}
}
