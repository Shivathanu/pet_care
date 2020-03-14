package pt.uporto.les.petcare.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import pt.uporto.les.petcare.model.user.Region;

@Entity
public class Species extends AbstractEntity {
	
	@Column(nullable = false, unique=true)
	private String description;
	
	@OneToMany(mappedBy = "species")
    private List<Breed> breeds = new ArrayList<Breed>();
	
	public Species(String description) {
		this.description = description;
	}
	
	public Species() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Species [description=" + description + ", breeds=" + breeds + "]";
	}
}
