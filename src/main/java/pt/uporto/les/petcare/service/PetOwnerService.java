package pt.uporto.les.petcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.uporto.les.petcare.model.user.PetOwner;
import pt.uporto.les.petcare.model.user.PetSitter;
import pt.uporto.les.petcare.repository.PetOwnerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PetOwnerService {

    @Autowired
    private PetOwnerRepository repository;

    public List<PetOwner> findAll(){
        return repository.findAll();
    }
    
    public String getImage(Long id) {
    	return repository.findById(id).get().getImage();
    }

    public PetOwner save(PetOwner petOwner){
        return repository.save(petOwner);
    }

    public Optional<PetOwner> findById(Long id){
        return repository.findById(id);
    }
    public long count(){
        return repository.count();
    }

    public void update(PetOwner petOwner) {
		try {
			Optional<PetOwner> toUpdateRecord = repository.findById(petOwner.getId());

			toUpdateRecord.get().setName(petOwner.getName());
			toUpdateRecord.get().setEmail(petOwner.getEmail());
			toUpdateRecord.get().setMobile(petOwner.getMobile());
			toUpdateRecord.get().setRegion(petOwner.getRegion());
			toUpdateRecord.get().setPassword(petOwner.getPassword());
			toUpdateRecord.get().setImage(petOwner.getImage());
			toUpdateRecord.get().setComment(petOwner.getComment());

			save(toUpdateRecord.get());
		} catch (RuntimeException e) {
			throw (e);
		}
	}
    
    public void delete(Long id){
        repository.delete(repository.findById(id).orElseThrow(() -> new RuntimeException("Not found id:" + id)));
    }
}
