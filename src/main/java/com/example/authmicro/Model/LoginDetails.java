package com.example.authmicro.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginDetails {
    public String name;
    public String emailID;
    public String password;
}
