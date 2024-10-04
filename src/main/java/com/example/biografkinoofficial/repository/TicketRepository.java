package com.example.biografkinoofficial.repository;

import com.example.kinozippy.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
