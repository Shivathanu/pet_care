package pt.uporto.les.petcare.model.user;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Availability {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Date startDate;
    private Date endDate;

  //  ArrayList<Date> notAvailableDates = new ArrayList<>(); //startdate < notAvaiilableDates[n] < endDate

    private boolean isAvailable;

    public Availability(Date startDate, Date endDate, List<Date> notAvailableDates) {
        this.startDate = startDate;
        this.endDate = endDate;
     //   this.notAvailableDates = notAvailableDates;
        isAvailable = true;
    }

    public Availability() {

        isAvailable = false;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
/*
    public List<Date> getNotAvailableDates() {
        return notAvailableDates;
    }

    public void setNotAvailableDates(List<Date> notAvailableDates) {
        this.notAvailableDates = notAvailableDates;
    }
*/

    public boolean isAvailable() { // Não tem Set porque deve ser mudado internamente
        return isAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Availability{");

        if(isAvailable) {
            sb.append("startDate=").append(startDate);
            sb.append(", endDate=").append(endDate);
      //      sb.append(", notAvailableDates=").append(notAvailableDates);
            sb.append(", isAvailable=").append(isAvailable);
            sb.append('}');
        }else{
            sb.append("isAvailable=").append(isAvailable);
        }
        return sb.toString();
    }
}
