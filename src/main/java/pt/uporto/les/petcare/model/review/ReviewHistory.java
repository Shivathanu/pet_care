package pt.uporto.les.petcare.model.review;
import pt.uporto.les.petcare.model.AbstractEntity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class ReviewHistory extends AbstractEntity {

    private String from;
    private String to;
    private Integer rating;

    public ReviewHistory(String from, String to, Integer rating) {
        this.from = from;
        this.to = to;
        this.rating = rating;
    }

    public ReviewHistory() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewHistory)) return false;
        if (!super.equals(o)) return false;
        ReviewHistory that = (ReviewHistory) o;
        return getFrom().equals(that.getFrom()) &&
                getTo().equals(that.getTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFrom(), getTo());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ReviewHistory{");
        sb.append("from='").append(from).append('\'');
        sb.append(", to='").append(to).append('\'');
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}

