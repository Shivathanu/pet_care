package pt.uporto.les.petcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pt.uporto.les.petcare.model.dto.input.PetOwnerInputDto;
import pt.uporto.les.petcare.model.user.PetOwner;
import pt.uporto.les.petcare.repository.RegionRepository;
import pt.uporto.les.petcare.service.PetOwnerService;

@RestController
public class PetOwnerController {

	@Autowired
	private PetOwnerService petOwnerService;

	@Autowired
	private RegionRepository regionRepository;

	@CrossOrigin
	@GetMapping(value = "/api/pet_owner", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PetOwner> list() {
		return petOwnerService.findAll();
	}

	@CrossOrigin
	@GetMapping(value = "/api/pet_owner/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PetOwner find(@PathVariable("id") Long id) {
		return petOwnerService.findById(id).orElseThrow(() -> new RuntimeException("Not found id:" + id));
	}
	
	@CrossOrigin
	@GetMapping(value = "/api/pet_owner/{id}/image", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getImage(@PathVariable("id") Long id) {
		return petOwnerService.getImage(id);
	}

	@CrossOrigin
	@PostMapping(value = "/api/pet_owner", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody PetOwnerInputDto petOwnerInputDto) {
		PetOwner petOwnerSaved = this.petOwnerService.save(petOwnerInputDto.build(regionRepository));
		return ResponseEntity.ok(petOwnerSaved);
	}

	@CrossOrigin
	@PutMapping(value = "/api/pet_owner", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody PetOwnerInputDto petOwnerInputDto) {
		petOwnerService.update(petOwnerInputDto.build(regionRepository));
	}
	
	@CrossOrigin
	@DeleteMapping(value = "/api/pet_owner/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			this.petOwnerService.delete(id);
			return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
		} catch (RuntimeException exception) {
			return new ResponseEntity<String>("DELETE Response", HttpStatus.BAD_REQUEST);
		}
	}
}
