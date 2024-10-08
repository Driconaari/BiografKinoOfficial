package com.example.biografkinoofficial.controller;

import com.example.biografkinoofficial.entity.UserLogin;
import com.example.biografkinoofficial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login"; // Return the view name for the login page
    }

    @GetMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public String admin() {
        return "adminpage";
    }

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public String user() {
        return "userpage";
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody UserLogin user) {
        UserLogin foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            if (foundUser.getRole().equals("ADMIN")) {
                return "redirect:/admin/dashboard";
            } else {
                return "redirect:/user/dashboard";
            }
        } else {
            return "Invalid username or password";
        }
    }
}