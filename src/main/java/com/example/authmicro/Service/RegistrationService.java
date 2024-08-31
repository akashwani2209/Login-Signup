package com.example.authmicro.Service;

import com.example.authmicro.Model.User;
import com.example.authmicro.repository.UserRepository;
import com.example.authmicro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationService {

    @Autowired
    public UserRepository repository;

    public User register(User user){
        //
        return repository.save(user);
    }


}
