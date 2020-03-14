package pt.uporto.les.petcare.model;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import pt.uporto.les.petcare.model.user.PetOwner;

@Entity
public class Pet extends AbstractEntity {

	@Column(nullable = false)
	private String name;

	@ManyToOne
	private Species species;

	@ManyToOne
	private Breed breed;

	private LocalDate birthDate;

	//@Column(columnDefinition = "int default -1")
	private long age;

	private String comment;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private String image;

	@ManyToOne
	private PetOwner petOwner;

	public Pet(String name, Species species, Breed breed, LocalDate birthDate, String comment, String image,
			PetOwner petOwner) {
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.birthDate = birthDate;
		this.comment = comment;
		this.image = image;
		this.petOwner = petOwner;
	}

	public Pet() {
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

	@Override
	public String toString() {
		return "Pet [id=" + super.getId() + ", name=" + name + ", species=" + species + ", breed=" + breed
				+ ", birthDate=" + birthDate + ", comment=" + comment + ", image=" + image + ", petOwner=" + petOwner
				+ "]";
	}

}