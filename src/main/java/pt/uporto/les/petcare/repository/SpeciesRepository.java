package pt.uporto.les.petcare.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import pt.uporto.les.petcare.model.Species;

public interface SpeciesRepository extends Repository<Species, Long> {
	List<Species> findAll();
    Optional<Species> findById(Long id);
}
