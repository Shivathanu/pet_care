package pt.uporto.les.petcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Breed extends AbstractEntity{
	
	@Column(nullable = false)
	private String description;
	
	@ManyToOne
	private Species species;
	
	public Breed(String description, Species species) {
		this.description = description;
		this.species = species;
	}
	
	public Breed() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	@Override
	public String toString() {
		return "Breed [description=" + description + ", species=" + species + "]";
	}
	
}
