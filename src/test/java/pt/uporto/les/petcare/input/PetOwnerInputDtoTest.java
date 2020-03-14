package pt.uporto.les.petcare.input;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import pt.uporto.les.petcare.model.user.Country;
import pt.uporto.les.petcare.model.user.PetOwner;
import pt.uporto.les.petcare.model.user.Region;
import pt.uporto.les.petcare.model.dto.input.PetOwnerInputDto;
import pt.uporto.les.petcare.repository.CountryRepository;
import pt.uporto.les.petcare.repository.RegionRepository;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PetOwnerInputDtoTest {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private CountryRepository countryRepository;

    private Region savedRegion;

    @Before
    public void setup(){

        Country country=new Country("Portugal");

        countryRepository.save(country);

        Region region=new Region("Porto");
        region.setCountry(country);

        this.savedRegion=regionRepository.save(region);

    }

    @Test
    public void shouldConvertPetOwner(){

        PetOwnerInputDto dto=new PetOwnerInputDto();
        dto.setEmail("mickey@mouse.com");
        dto.setName("Mickey Mouse");
        dto.setMobile("+351 123 123 123");
        dto.setPassword("12345678");
        //dto.setRegion("Porto");

        PetOwner petOwner=dto.build(regionRepository);

        assertThat(petOwner.getEmail()).isEqualTo("mickey@mouse.com");
        assertThat(petOwner.getName()).isEqualTo("Mickey Mouse");
        assertThat(petOwner.getMobile()).isEqualTo("+351 123 123 123");
        assertThat(petOwner.getPassword()).isEqualTo("12345678");
        //assertThat(petOwner.getRegion().getName()).isEqualTo("Porto");
        //assertThat(petOwner.getRegion().getCountry().getName()).isEqualTo("Portugal");

    }

    @Test
    public void shouldConvertPetOwnerWithNullRegion(){

        PetOwnerInputDto dto=new PetOwnerInputDto();
        dto.setEmail("mickey@mouse.com");
        dto.setName("Mickey Mouse");
        dto.setMobile("+351 123 123 123");
        dto.setPassword("12345678");
        //dto.setRegion("");

        PetOwner petOwner=dto.build(regionRepository);

        assertThat(petOwner.getEmail()).isEqualTo("mickey@mouse.com");
        assertThat(petOwner.getName()).isEqualTo("Mickey Mouse");
        assertThat(petOwner.getMobile()).isEqualTo("+351 123 123 123");
        assertThat(petOwner.getPassword()).isEqualTo("12345678");
        assertThat(petOwner.getRegion()).isNull();

    }

}