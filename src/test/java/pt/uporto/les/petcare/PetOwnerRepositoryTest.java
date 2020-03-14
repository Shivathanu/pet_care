package pt.uporto.les.petcare;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

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

@RunWith(SpringRunner.class)
@DataJpaTest
public class PetOwnerRepositoryTest {

	@Autowired
	private PetOwnerRepository petOwnerRepository;

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private TestEntityManager entityManager;

	private PetOwner savedPetOwner;

	@Before
	public void setup() {
		Country country = new Country("Portugal");

		countryRepository.save(country);

		Region region = new Region("Porto");
		region.setCountry(country);
		
//		String region = "Porto";
		

		regionRepository.save(region);

		PetOwner owner = new PetOwner();
		owner.setName("Mickey Mouse");
		owner.setEmail("mickey@disney.com");
		owner.setMobile("+351 123 123 123");
		owner.setPassword("12345678");
		owner.setRegion(region);

		savedPetOwner = this.petOwnerRepository.save(owner);

		String b64image = "";
		Species species = new Species("Cão");
		Breed breed = new Breed("Labrador", species);
		Pet pet1 = new Pet("Fiona", species, breed, LocalDate.now(), "cão muito querido", b64image, savedPetOwner);
		Pet pet2 = new Pet("Shrek", species, breed, LocalDate.now(), "cão bravo", b64image, savedPetOwner);

		savedPetOwner.getPets().add(pet1);
		savedPetOwner.getPets().add(pet2);

	}

	@Test
	public void shouldSavePetOwner() {

		PetOwner foundPetOwner = this.petOwnerRepository.findById(savedPetOwner.getId())
				.orElseThrow(() -> new RuntimeException("Não foi possível encontrar o Pet Owner!"));

		assertThat(foundPetOwner).isNotNull();
		assertThat(foundPetOwner.getName().equals(savedPetOwner.getName()));

	}

	@Test
	public void shouldFindAllPetOwner() {

		List<PetOwner> list = this.petOwnerRepository.findAll();

		assertThat(list).hasSize(1);

	}

	@Test
	public void shouldDeletePetOwner() {

		this.petOwnerRepository.delete(savedPetOwner);

		Optional<PetOwner> deletedPetOwner = this.petOwnerRepository.findById(savedPetOwner.getId());

		assertFalse(deletedPetOwner.isPresent());

	}

	@Test
	public void shouldPetOwnerHave2Pets() {
		PetOwner foundPetOwner = this.petOwnerRepository.findById(savedPetOwner.getId())
				.orElseThrow(() -> new RuntimeException("Não foi possível encontrar o Pet Owner!"));

		assertThat(foundPetOwner).isNotNull();
		assertThat(foundPetOwner.getPets()).hasSize(2);
		assertThat(foundPetOwner.getPets().get(0).getName()).isEqualTo("Pluto");
		assertThat(foundPetOwner.getPets().get(1).getName()).isEqualTo("Buster");
	}

}
