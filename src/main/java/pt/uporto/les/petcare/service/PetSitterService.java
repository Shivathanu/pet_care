package pt.uporto.les.petcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.uporto.les.petcare.model.user.PetSitter;
import pt.uporto.les.petcare.repository.PetSitterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PetSitterService {
	@Autowired
	private PetSitterRepository repository;

	public List<PetSitter> findAll() {
		return repository.findAll();
	}

	public Optional<PetSitter> findById(Long id) {
		return repository.findById(id);
	}

	public PetSitter save(PetSitter petSitter) {
		return repository.save(petSitter);
	}

	public String getImage(Long id) {
		return repository.findById(id).get().getImage();
	}

	public void update(PetSitter petSitter) {
		try {
			Optional<PetSitter> toUpdateRecord = repository.findById(petSitter.getId());

			toUpdateRecord.get().setName(petSitter.getName());
			toUpdateRecord.get().setEmail(petSitter.getEmail());
			toUpdateRecord.get().setMobile(petSitter.getMobile());
			toUpdateRecord.get().setRegion(petSitter.getRegion());
			toUpdateRecord.get().setPassword(petSitter.getPassword());
			toUpdateRecord.get().setImage(petSitter.getImage());
			toUpdateRecord.get().setComment(petSitter.getComment());

			save(toUpdateRecord.get());
		} catch (RuntimeException e) {
			throw (e);
		}
	}

	public void delete(Long id) {
		repository.delete(repository.findById(id).orElseThrow(() -> new RuntimeException("Not found id:" + id)));
	}

	public List<PetSitter> findAllByRegionAndPeriod(String region) {
		return repository.findAllByRegionNameContainingIgnoreCaseOrderByNameDesc(region);
	}
}
