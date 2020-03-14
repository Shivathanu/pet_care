package pt.uporto.les.petcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.uporto.les.petcare.model.Breed;
import pt.uporto.les.petcare.model.Species;
import pt.uporto.les.petcare.model.user.Country;
import pt.uporto.les.petcare.model.user.Region;
import pt.uporto.les.petcare.repository.CountryRepository;
import pt.uporto.les.petcare.repository.RegionRepository;
import pt.uporto.les.petcare.repository.SpeciesRepository;

@Service
public class RegionService {

	@Autowired
	private RegionRepository repository;
	
	@Autowired
	private CountryRepository CountryRepository;

	public List<Region> findAll() {
		return repository.findAll();
	}

	public Optional<Region> findById(Long regionId) {
		return repository.findById(regionId);
	}

	public Optional<Region> findByName(String regionName) {
		return repository.findByName(regionName);
	}
	
	public List<Region> findByCountryId(Long countryId){
		Optional<Country> countries = CountryRepository.findById(countryId);
		
		return repository.findByCountry(countries.get());
	}

}
