package pt.uporto.les.petcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.uporto.les.petcare.model.Breed;
import pt.uporto.les.petcare.model.Species;
import pt.uporto.les.petcare.repository.BreedRepository;
import pt.uporto.les.petcare.repository.SpeciesRepository;

@Service
public class BreedService {

	@Autowired
	private BreedRepository repository;
	
	@Autowired
	private SpeciesRepository SpeciesRepository;
	
	public List<Breed> findAll() {
		return repository.findAll();
	}
	
	public Optional<Breed> findById(Long breedId) {
		return repository.findById(breedId);
	}
	
	public List<Breed> findBySpeciesId(Long speciesId){
		Optional<Species> species = SpeciesRepository.findById(speciesId);
		
		return repository.findBySpecies(species.get());
	}
}
