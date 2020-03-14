package pt.uporto.les.petcare.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.uporto.les.petcare.model.Breed;
import pt.uporto.les.petcare.model.Pet;
import pt.uporto.les.petcare.model.Species;
import pt.uporto.les.petcare.model.user.Country;
import pt.uporto.les.petcare.model.user.PetOwner;
import pt.uporto.les.petcare.model.user.Region;
import pt.uporto.les.petcare.repository.CountryRepository;
import pt.uporto.les.petcare.repository.PetOwnerRepository;
import pt.uporto.les.petcare.repository.PetRepository;
import pt.uporto.les.petcare.repository.RegionRepository;

@RestController
public class UtilsController {
	
	@Autowired
	private PetOwnerRepository petOwnerRepository;

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private CountryRepository countryRepository;

	private PetOwner savedPetOwner;
	
	@CrossOrigin
	@GetMapping(value = "/api/utils/fillrecords", produces = MediaType.APPLICATION_JSON_VALUE)
	public String fillRecords() {
		//System.out.println("teste aqui");
		
		Country country = new Country("Portugal");

		countryRepository.save(country);

		Region region = new Region("Porto");
		region.setCountry(country);
		

		regionRepository.save(region);

		PetOwner owner = new PetOwner();
		owner.setName("Mickey Mouse");
		owner.setEmail("mickey@disney.com");
		owner.setMobile("+351 123 123 123");
		owner.setPassword("12345678");
		owner.setRegion(region);

		savedPetOwner = this.petOwnerRepository.save(owner);

		String b64image = null;
		Species species = new Species("Cão");
		Breed breed = new Breed("Labrador", species);
		Pet pet1 = new Pet("Fiona", species, breed, LocalDate.now(), "cão muito querido", b64image, savedPetOwner);
		Pet pet2 = new Pet("Shrek", species, breed, LocalDate.now(), "cão bravo", b64image, savedPetOwner);

		savedPetOwner.getPets().add(pet1);
		savedPetOwner.getPets().add(pet2);
		
		return "ok";
	}
}
