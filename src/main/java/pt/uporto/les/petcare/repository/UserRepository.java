package pt.uporto.les.petcare.repository;

import org.springframework.data.repository.Repository;
import pt.uporto.les.petcare.model.Pet;
import pt.uporto.les.petcare.model.user.PetOwner;
import pt.uporto.les.petcare.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

	List<User> findAll();

	User save(User User);

	Optional<User> findById(Long id);

	long count();

	void delete(User User);
}
