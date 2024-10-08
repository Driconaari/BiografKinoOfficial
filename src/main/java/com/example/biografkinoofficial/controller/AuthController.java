package com.example.biografkinoofficial.controller;

import com.example.biografkinoofficial.entity.UserLogin;
import com.example.biografkinoofficial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public String admin() {
        return "Admin page";
    }

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public String user() {
        return "User page";
    }


    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody UserLogin user) {
        UserLogin foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            if (foundUser.getRole().equals("ADMIN")) {
                return "Admin login successful";
            } else {
                return "User login successful";
            }
        } else {
            return "Invalid username or password";
        }
    }
}