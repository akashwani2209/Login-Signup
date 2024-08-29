package com.example.authmicro.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.authmicro.Model.*;

public interface TutorialRepository extends MongoRepository<User, String> {

}