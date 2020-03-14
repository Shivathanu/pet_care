package pt.uporto.les.petcare.AuthSecurity.Database;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pt.uporto.les.petcare.model.Pet;
import pt.uporto.les.petcare.model.review.PetOwnerReview;
import pt.uporto.les.petcare.model.user.PetOwner;
import pt.uporto.les.petcare.model.user.PetSitter;
import pt.uporto.les.petcare.model.user.Region;
import pt.uporto.les.petcare.model.user.User;
import pt.uporto.les.petcare.repository.PetOwnerRepository;
import pt.uporto.les.petcare.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if ("javainuse".equals(username)) {
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6","m","$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", null);
        } else {

            for(User u : repository.findAll()){
                if( u.getUsername().equals(username)){

                    return u;
                }
            }


            throw new UsernameNotFoundException("User not found with username: " + username);



        }
    }

    public Long load(String username) throws UsernameNotFoundException {

        for (User u : repository.findAll()) {
            if (u.getUsername().equals(username)) {

                return u.getId();
            }



        }


        return null;
    }


    public UserDetails registerUser(User userToRegister, String role) {

        for(User u : repository.findAll()){
            if( u.getUsername().equals(userToRegister.getUsername())){
                throw new UsernameNotFoundException("User not found with username: " + userToRegister.getUsername());
            }
        }

        userToRegister.setPassword(bcryptEncoder.encode(userToRegister.getPassword()));

        return repository.save(
        		( role.equalsIgnoreCase("pet_sitter")) ? 
        				new PetSitter(userToRegister) : 
        					new PetOwner(userToRegister, new ArrayList<>()));
    }
}
