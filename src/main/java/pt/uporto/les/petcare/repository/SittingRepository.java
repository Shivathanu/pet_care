package pt.uporto.les.petcare.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import pt.uporto.les.petcare.model.Sitting;

public interface SittingRepository extends Repository<Sitting, Long> {

	Sitting save(Sitting sitting);

	List<Sitting> findByPetSitterId(Long id);

	List<Sitting> findByPetPetOwnerId(Long id);

	Optional<Sitting> findById(Long id);

	void delete(Sitting rejectedSitting);
}