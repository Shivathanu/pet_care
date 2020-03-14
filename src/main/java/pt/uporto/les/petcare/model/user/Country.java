package pt.uporto.les.petcare.model.user;

import pt.uporto.les.petcare.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country extends AbstractEntity {

    @Column(nullable = false,unique=true)
    private String name;


    @OneToMany(mappedBy = "country")
    private List<Region> regions=new ArrayList<Region>();

    public Country(String name) {
        this.name = name;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
