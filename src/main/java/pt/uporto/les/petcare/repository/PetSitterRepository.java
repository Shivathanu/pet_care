package pt.uporto.les.petcare.repository;

import org.springframework.data.repository.Repository;
import pt.uporto.les.petcare.model.user.PetSitter;

import java.util.List;
import java.util.Optional;

public interface PetSitterRepository extends Repository<PetSitter, Long>{
	List<PetSitter> findAll();
	Optional<PetSitter> findById(Long id);
	PetSitter save(PetSitter petSitter);
	void delete(PetSitter petSitter);
	List<PetSitter> findAllByRegionNameContainingIgnoreCaseOrderByNameDesc(String name);

}
