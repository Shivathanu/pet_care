package pt.uporto.les.petcare.model.review;

import javax.persistence.Entity;

import pt.uporto.les.petcare.model.AbstractEntity;



@Entity
public class IndividualReviewInstance extends AbstractEntity {

	private int stars;

	private String comment;

	// add reviewer or consider annonimous?

	public IndividualReviewInstance() {
	}

	public IndividualReviewInstance(int stars, String comment) {
		super();
		this.stars = stars;
		this.comment = comment;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
