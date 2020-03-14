package pt.uporto.les.petcare.model.user;

import pt.uporto.les.petcare.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Region extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Country country;

    public Region() {
    }

    public Region(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
