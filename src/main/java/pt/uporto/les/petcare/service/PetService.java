package pt.uporto.les.petcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.uporto.les.petcare.model.Pet;
import pt.uporto.les.petcare.repository.PetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

	@Autowired
	private PetRepository repository;

	public List<Pet> findAll() {
		return repository.findAll();
	}
	
	public List<Pet> findPetsByPetOwnerId(Long id) {
		return repository.findByPetOwnerId(id);
	}

	public Optional<Pet> findById(Long petId) {
		return repository.findById(petId);
	}

	public Pet save(Pet pet) {
		return repository.save(pet);
	}

	public void update(Pet pet) {
		try {
			Optional<Pet> toUpdateRecord = repository.findById(pet.getId());

			toUpdateRecord.get().setName(pet.getName());
			toUpdateRecord.get().setSpecies(pet.getSpecies());
			toUpdateRecord.get().setBreed(pet.getBreed());
			toUpdateRecord.get().setBirthDate(pet.getBirthDate());
			toUpdateRecord.get().setAge(pet.getAge());
			toUpdateRecord.get().setComment(pet.getComment());
			toUpdateRecord.get().setImage(pet.getImage());

			save(toUpdateRecord.get());
		} catch (RuntimeException e) {
			throw (e);
		}

	}

	public void delete(Long petId) {
		repository.delete(
				repository.findById(petId).orElseThrow(() -> new RuntimeException("Pet id not found: " + petId)));
	}

}
