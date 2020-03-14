package pt.uporto.les.petcare.repository;

import org.springframework.data.repository.Repository;
import pt.uporto.les.petcare.model.user.Country;
import pt.uporto.les.petcare.model.user.Region;

import java.util.List;
import java.util.Optional;

public interface RegionRepository extends Repository<Region, Long> {

	List<Region> findAll();

	Region save(Region region);

	Optional<Region> findById(Long id);

	long count();

	void delete(Region region);

	Optional<Region> findByName(String name);
	
	List<Region> findByCountry(Country countries);
}