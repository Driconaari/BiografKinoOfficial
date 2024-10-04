package com.example.biografkinoofficial.repository;

import com.example.biografkinoofficial.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByShowingId(int showingId); // Custom query to find tickets by showing ID
}
