package com.example.authmicro.repository;

import com.example.authmicro.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByOauthProviderAndOauthId(String provider, String id);
}