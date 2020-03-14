package pt.uporto.les.petcare.model.review;

import pt.uporto.les.petcare.model.AbstractEntity;
import pt.uporto.les.petcare.model.user.User;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Review extends AbstractEntity {

    private String user;

    private long nOfReviews;
    private long avgReview;
    private long sumOfReviews;

    public Review(String user, long nOfReviews, long avgReview, long sumOfReviews) {
        this.user = user;
        this.nOfReviews = nOfReviews;
        this.avgReview = avgReview;
        this.sumOfReviews = sumOfReviews;
    }

    public Review() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return user.equals(review.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    public long addReview(long rating){

        if(rating >= 0 && rating <= 5 ){

            nOfReviews += 1;
            sumOfReviews += rating;
            avgReview = sumOfReviews / nOfReviews;

            return avgReview;
        }

        return -1;
    }

    public String getTo() {
        return user;
    }

    public void setTo(String user) {
        this.user = user;
    }

    public long getnOfReviews() {
        return nOfReviews;
    }

    public long getAvgReview() {
        return avgReview;
    }

    public long getSumOfReviews() {
        return sumOfReviews;
    }
}
