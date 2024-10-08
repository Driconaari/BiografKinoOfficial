package com.example.biografkinoofficial.repository;

import com.example.biografkinoofficial.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserLogin, String> {
    UserLogin findByUsername(String username);
}