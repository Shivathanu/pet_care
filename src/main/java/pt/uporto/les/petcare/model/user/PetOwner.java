package pt.uporto.les.petcare.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pt.uporto.les.petcare.model.Pet;

@Entity
@DiscriminatorValue("PET_OWNER")
@JsonIgnoreProperties({ "pets" })
public class PetOwner extends User {

	@OneToMany(mappedBy = "petOwner", fetch = FetchType.LAZY)
	private List<Pet> pets = new ArrayList<>();

	public PetOwner() {
	}

	public PetOwner(User user, String role, List<Pet> pets) {
		super(user, role);
		this.pets = pets;
	}

//	public PetOwner(String email, String name, String mobile, String password, String region, List<Pet> pets) {
//		super(email, name, mobile, password, region);
//		this.pets = pets;
//	}

	public PetOwner(String email, String name, String mobile, String password, String region, String image,
			List<Pet> pets, String comment) {
		super(email, name, mobile, password, region, image, comment);
		this.pets = pets;
	}

	public PetOwner(User user, List<Pet> pets) {
		super(user);
		this.pets = pets;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
}
