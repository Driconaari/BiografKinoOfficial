package com.example.biografkinoofficial.repository;

import com.example.biografkinoofficial.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserLogin, Integer> {
    UserLogin findByUsername(String username);
}