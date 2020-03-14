package pt.uporto.les.petcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.uporto.les.petcare.model.Species;
import pt.uporto.les.petcare.repository.SpeciesRepository;

@Service
public class SpeciesService {
	
	@Autowired
	private SpeciesRepository repository;
	
	public List<Species> findAll() {
		return repository.findAll();
	}
	
	public Optional<Species> findById(Long speciesId) {
		return repository.findById(speciesId);
	}
}
