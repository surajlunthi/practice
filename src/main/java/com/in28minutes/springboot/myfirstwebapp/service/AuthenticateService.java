package com.in28minutes.springboot.myfirstwebapp.service;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticateService {

    public  boolean  isValidUser(String username,String password){
       if (Optional.ofNullable(username).isPresent() && Optional.ofNullable(password).isPresent()){

           return username.equals("Suraj") && password.equals("dummy");
       }
       return false;
    }
}
