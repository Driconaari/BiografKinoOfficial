package com.example.kinozippy.repository;

import com.example.kinozippy.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserLogin, Integer> {
    UserLogin findByUsername(String username);
}