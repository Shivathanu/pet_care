package pt.uporto.les.petcare.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import pt.uporto.les.petcare.model.Breed;
import pt.uporto.les.petcare.model.Species;

public interface BreedRepository extends Repository<Breed, Long>{
	List<Breed> findAll();
	Optional<Breed> findById(Long id);
	List<Breed> findBySpecies(Species species);
}
