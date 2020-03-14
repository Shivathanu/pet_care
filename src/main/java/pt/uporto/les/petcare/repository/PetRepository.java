package pt.uporto.les.petcare.repository;

import org.springframework.data.repository.Repository;
import pt.uporto.les.petcare.model.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends Repository<Pet, Long> {

	List<Pet> findAll();
	
	List<Pet> findByPetOwnerId(Long id);

	Pet save(Pet pet);

	Optional<Pet> findById(Long id);

	void delete(Pet savedPet);
}
