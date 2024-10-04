package com.example.biografkinoofficial.service;

import com.example.biografkinoofficial.entity.Ticket;
import com.example.biografkinoofficial.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket reserveTicket(Ticket reservationRequest) {
        // Add logic to check seat availability, etc.
        return ticketRepository.save(reservationRequest);
    }
}
