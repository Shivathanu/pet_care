package pt.uporto.les.petcare.repository;

import org.springframework.data.repository.Repository;
import pt.uporto.les.petcare.model.review.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends Repository<Review, Long> {

	List<Review> findAll();

	Review save(Review pet);

	Optional<Review> findById(Long id);
}
