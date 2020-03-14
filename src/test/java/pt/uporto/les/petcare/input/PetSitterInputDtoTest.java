package pt.uporto.les.petcare.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.uporto.les.petcare.model.dto.input.PetSitterInputDto;
import pt.uporto.les.petcare.model.user.Country;
import pt.uporto.les.petcare.model.user.PetSitter;
import pt.uporto.les.petcare.model.user.Region;
import pt.uporto.les.petcare.repository.CountryRepository;
import pt.uporto.les.petcare.repository.RegionRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PetSitterInputDtoTest {
	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private CountryRepository countryRepository;

	private Region savedRegion;

	@Before
	public void setup() {

		Country country = new Country("Portugal");

		countryRepository.save(country);

		Region region = new Region("Porto");
		region.setCountry(country);

		this.savedRegion = regionRepository.save(region);

	}

	@Test
	public void shouldConvertPetOwner() {
		String petSitterEmail = "diogopmelo@gmail.com";
		String petSitterName = "Diogo Melo";
		String petSitterMobile = "+351 123 123 123";
		String petSitterPass = "12345678";
		String petSitterRegion = "Porto";
		String petSitterCountry = "Portugal";

		PetSitterInputDto dto = new PetSitterInputDto();
		dto.setEmail(petSitterEmail);
		dto.setName(petSitterName);
		dto.setMobile(petSitterMobile);
		dto.setPassword(petSitterPass);
		//dto.setRegion(petSitterRegion);

		PetSitter petSitter = dto.build(regionRepository);

		assertThat(petSitter.getEmail()).isEqualTo(petSitterEmail);
		assertThat(petSitter.getName()).isEqualTo(petSitterName);
		assertThat(petSitter.getMobile()).isEqualTo(petSitterMobile);
		assertThat(petSitter.getPassword()).isEqualTo(petSitterPass);
		//assertThat(petSitter.getRegion().getName()).isEqualTo(petSitterRegion);
		//assertThat(petSitter.getRegion().getCountry().getName()).isEqualTo(petSitterCountry);
	}

	@Test
	public void shouldConvertPetSitterWithNullRegion() {

		String petSitterEmail = "diogopmelo@gmail.com";
		String petSitterName = "Diogo Melo";
		String petSitterMobile = "+351 123 123 123";
		String petSitterPass = "12345678";

		PetSitterInputDto dto = new PetSitterInputDto();
		dto.setEmail(petSitterEmail);
		dto.setName(petSitterName);
		dto.setMobile(petSitterMobile);
		dto.setPassword(petSitterPass);
		//dto.setRegion("");

		PetSitter petSitter = dto.build(regionRepository);

		assertThat(petSitter.getEmail()).isEqualTo(petSitterEmail);
		assertThat(petSitter.getName()).isEqualTo(petSitterName);
		assertThat(petSitter.getMobile()).isEqualTo(petSitterMobile);
		assertThat(petSitter.getPassword()).isEqualTo(petSitterPass);
		assertThat(petSitter.getRegion()).isNull();
	}
}
