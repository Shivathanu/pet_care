package pt.uporto.les.petcare.model.dto.output;

import java.time.LocalDate;

import pt.uporto.les.petcare.model.Breed;
import pt.uporto.les.petcare.model.Pet;
import pt.uporto.les.petcare.model.Species;
import pt.uporto.les.petcare.model.dto.input.PetOwnerInputDto;

public class PetOutputDto {
	private long id;
	
	private String name;

	private Species species;

	private Breed breed;

	private LocalDate birthDate;
	
	private long age;

	private String comment;

	private String image;

	private PetOwnerInputDto petOwner;

	public PetOutputDto() {

	}

	public PetOutputDto(long id, String name, Species species, Breed breed, LocalDate birthDate, long age, String comment, String image,
			PetOwnerInputDto petOwner) {
		this.id = id;
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.birthDate = birthDate;
		this.age = age;
		this.comment = comment;
		this.image = image;
		this.petOwner = petOwner;
	}

	public PetOutputDto(Pet pet) {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public PetOwnerInputDto getPetOwner() {
		return petOwner;
	}

	public void setPetOwner(PetOwnerInputDto petOwner) {
		this.petOwner = petOwner;
	}

}
