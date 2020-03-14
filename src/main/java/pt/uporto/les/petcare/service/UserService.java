package pt.uporto.les.petcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import pt.uporto.les.petcare.repository.PetRepository;

public class UserService {

    @Autowired
    private PetRepository repository;
}
