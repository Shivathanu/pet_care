package pt.uporto.les.petcare.model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PET_SITTER")
public class PetSitter extends User {

    public PetSitter(User u) {
        super(u);
    }
    
    public PetSitter(String email, String name, String mobile, String password, String region, String image, String comment) {
        super(email, name, mobile, password, region, image, comment);
    }

    public PetSitter() {
    }
}
