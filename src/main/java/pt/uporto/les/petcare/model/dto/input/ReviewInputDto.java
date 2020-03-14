package pt.uporto.les.petcare.model.dto.input;

import pt.uporto.les.petcare.model.Breed;
import pt.uporto.les.petcare.model.Pet;
import pt.uporto.les.petcare.model.Species;
import pt.uporto.les.petcare.model.review.Review;
import pt.uporto.les.petcare.model.review.ReviewHistory;
import pt.uporto.les.petcare.model.user.PetOwner;

import java.time.LocalDate;

public class ReviewInputDto {

	private ReviewHistory history;


	public Review toReview() {

		return new Review();

	}
}
