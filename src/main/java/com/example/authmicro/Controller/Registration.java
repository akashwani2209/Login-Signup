package com.example.authmicro.Controller;


import com.example.authmicro.Model.User;
import com.example.authmicro.Service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
public class Registration {

    @Autowired
    public RegistrationService registrationService;

    @PostMapping
    public void createUser(@RequestBody User user){

        registrationService.saveUser(user);
    }
}
