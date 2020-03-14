package pt.uporto.les.petcare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.uporto.les.petcare.model.user.Country;
import pt.uporto.les.petcare.repository.CountryRepository;

@Service
public class CountryService {
	@Autowired
	private CountryRepository repository;
	
	public List<Country> findAll() {
		return repository.findAll();
	}
	
	public Optional<Country> findById(Long countryId) {
		return repository.findById(countryId);
	}
}
