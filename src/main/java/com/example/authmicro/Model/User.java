package com.example.authmicro.Model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private int id;
    public String emailID;
    public String userName;
    public String gender;
    public int age;
    public String password;
}
