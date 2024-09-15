package com.example.authmicro.Service;

import com.example.authmicro.Model.User;
import com.example.authmicro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Optional;

public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String email = oAuth2User.getAttribute("email");
        Optional<User> userOpt = Optional.ofNullable(userRepository.findByEmail(email));

        if (userOpt.isEmpty()) {
            // Register the new OAuth2 user
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setOauth2Provider(userRequest.getClientRegistration().getRegistrationId());
            newUser.setOauth2User(true);;
            userRepository.save(newUser);
        }

        return oAuth2User;
    }
}
