package com.example.biografkinoofficial.repository;

import com.example.biografkinoofficial.entity.Showing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowingRepository extends JpaRepository<Showing, Integer> {
    // Additional query methods can be defined here if needed
}
