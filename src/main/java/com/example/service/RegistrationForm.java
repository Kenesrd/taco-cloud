package com.example.service;

import com.example.entities.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String role = "USER";

    public User toUser(PasswordEncoder passwordEncoder,String role){
        return new User(username, passwordEncoder.encode(password), email, phone, fullname, street, city,
                state, zip, role);
    }
}
