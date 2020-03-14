package pt.uporto.les.petcare.repository;

import org.springframework.data.repository.Repository;
import pt.uporto.les.petcare.model.review.ReviewHistory;

import java.util.List;
import java.util.Optional;

public interface ReviewHistoryRepository extends Repository<ReviewHistory, Long> {

	List<ReviewHistory> findAll();

	ReviewHistory save(ReviewHistory pet);

	Optional<ReviewHistory> findById(Long id);
}
