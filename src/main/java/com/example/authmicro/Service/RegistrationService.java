package com.example.authmicro.Service;

import com.example.authmicro.Model.User;
import com.example.authmicro.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationService {

    @Autowired
    public TutorialRepository repository;

    public User saveUser(User user){
        //
        return repository.save(user);
    }


}
