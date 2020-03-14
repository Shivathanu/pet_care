package pt.uporto.les.petcare.repository;

import org.springframework.data.repository.Repository;
import pt.uporto.les.petcare.model.user.PetOwner;

import java.util.List;
import java.util.Optional;

public interface PetOwnerRepository extends Repository<PetOwner, Long> {

	List<PetOwner> findAll();

	PetOwner save(PetOwner petOwner);

	Optional<PetOwner> findById(Long id);
	
	long count();

	void delete(PetOwner savedPetOwner);
}