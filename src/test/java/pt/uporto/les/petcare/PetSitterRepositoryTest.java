package pt.uporto.les.petcare;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pt.uporto.les.petcare.model.user.Country;
import pt.uporto.les.petcare.model.user.PetSitter;
import pt.uporto.les.petcare.model.user.Region;
import pt.uporto.les.petcare.repository.CountryRepository;
import pt.uporto.les.petcare.repository.PetSitterRepository;
import pt.uporto.les.petcare.repository.RegionRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PetSitterRepositoryTest {
	@Autowired
	private PetSitterRepository petSitterRepository;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private CountryRepository countryRepository;

	private PetSitter savedPetSitter;

	@Before
	public void setup() {
		Country country = new Country("Portugal");
		countryRepository.save(country);

		Region region = new Region("Porto");
		region.setCountry(country);
		regionRepository.save(region);

		PetSitter sitter = new PetSitter();
		sitter.setName("Diogo Melo");
		sitter.setEmail("diogopmelo@gmail.com");
		sitter.setMobile("+351 123 123 123");
		sitter.setPassword("12345678");
		// sitter.setRegion(region);
		savedPetSitter = this.petSitterRepository.save(sitter);
	}

	@Test
	public void shouldFindAllPetSitter() {

		List<PetSitter> list = this.petSitterRepository.findAll();

		assertThat(list).hasSize(1);

	}

	@Test
	public void shouldSavePetSitter() {

		PetSitter foundPetSitter = this.petSitterRepository.findById(savedPetSitter.getId())
				.orElseThrow(() -> new RuntimeException("Não foi possível encontrar o Pet Sitter!"));

		assertThat(foundPetSitter).isNotNull();
		assertThat(foundPetSitter.getName().equals(savedPetSitter.getName()));

	}

	@Test
	public void shouldDeletePetSitter() {

		this.petSitterRepository.delete(savedPetSitter);

		Optional<PetSitter> deletedPetSitter = this.petSitterRepository.findById(savedPetSitter.getId());

		assertFalse(deletedPetSitter.isPresent());
	}
}
