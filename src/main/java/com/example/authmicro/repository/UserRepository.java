package com.example.authmicro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.authmicro.Model.*;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    User findByUsername(String username);
}