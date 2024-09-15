package com.example.authmicro.Controller;

import com.example.authmicro.Model.User;
import com.example.authmicro.Service.CustomOAuth2UserService;
import com.example.authmicro.repository.UserRepository;
import com.example.authmicro.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private CustomOAuth2UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfig passwordEncoder;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // return login.html page
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        String pass = user.getPassword();
        PasswordEncoder p = passwordEncoder.passwordEncoder();
        pass = p.encode(pass);

        user.setPassword(pass);
        userRepository.save(user);
        return "redirect:/login";
    }

}
