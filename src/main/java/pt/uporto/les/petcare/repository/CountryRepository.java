package pt.uporto.les.petcare.repository;

import org.springframework.data.repository.Repository;
import pt.uporto.les.petcare.model.user.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends Repository<Country, Long> {

	List<Country> findAll();

	Country save(Country country);

	Optional<Country> findById(Long id);

	long count();

	void delete(Country country);

	Optional<Country> findByName(String name);
}
