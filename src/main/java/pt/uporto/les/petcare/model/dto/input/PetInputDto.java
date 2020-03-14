package pt.uporto.les.petcare.model.dto.input;

import java.time.LocalDate;

import pt.uporto.les.petcare.model.Breed;
import pt.uporto.les.petcare.model.Pet;
import pt.uporto.les.petcare.model.Species;
import pt.uporto.les.petcare.model.user.PetOwner;

public class PetInputDto {
	private long id;
	
	private String name;

	private Species species;

	private Breed breed;

	private LocalDate birthDate;
	
	private long age;

	private String comment;

	private String image;

	private PetOwner petOwner;

	public PetInputDto() {

	}

	public PetInputDto(long id, String name, Species species, Breed breed, LocalDate birthDate, long age, String comment, String image,
			PetOwner petOwner) {
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

	public PetInputDto(Pet pet) {
		this(pet.getId(), pet.getName(), pet.getSpecies(), pet.getBreed(), pet.getBirthDate(),
				pet.getAge(), pet.getComment(), pet.getImage(), pet.getPetOwner());
		this.petOwner.setPets(null);
	}

	public Pet build() {
		Pet pet = new Pet();
		
		pet.setId(this.id);
		pet.setName(this.name);
		pet.setSpecies(this.species);
		pet.setBreed(this.breed);
		pet.setBirthDate(this.birthDate);
		pet.setAge(this.age);
		pet.setComment(this.comment);
		pet.setImage(this.image);
		pet.setPetOwner(this.petOwner);

		return pet;
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

	public PetOwner getPetOwner() {
		return petOwner;
	}

	public void setPetOwner(PetOwner petOwner) {
		this.petOwner = petOwner;
	}

}
