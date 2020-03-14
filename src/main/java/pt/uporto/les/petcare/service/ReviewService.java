package pt.uporto.les.petcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.uporto.les.petcare.model.Pet;
import pt.uporto.les.petcare.model.review.Review;
import pt.uporto.les.petcare.model.review.ReviewHistory;
import pt.uporto.les.petcare.repository.PetRepository;
import pt.uporto.les.petcare.repository.ReviewHistoryRepository;
import pt.uporto.les.petcare.repository.ReviewRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;

	@Autowired
	private ReviewHistoryRepository repositoryHistory;

	public List<Review> findAll() {
		return repository.findAll();
	}

	public Optional<Review> findById(Long reviewId) {
		return repository.findById(reviewId);
	}

	public Review save(ReviewHistory reviewEntry) {

		Review reviewInUse = null;

		for( Review r : repository.findAll()){
			if( r.getTo().equals(reviewEntry.getTo())){
				reviewInUse = r;
			}
		}


		List<ReviewHistory> reposiReviewHistories = repositoryHistory.findAll();
		ReviewHistory ri = repositoryHistory.save(new ReviewHistory(reviewEntry.getFrom(),
				reviewEntry.getTo(),
				reviewEntry.getRating()));




		if(reviewInUse != null){

			reviewInUse.addReview(reviewEntry.getRating());


		}else{

			reviewInUse = new Review(reviewEntry.getTo(),1, reviewEntry.getRating(), reviewEntry.getRating());

		}

		return repository.save(reviewInUse);
	}

}
