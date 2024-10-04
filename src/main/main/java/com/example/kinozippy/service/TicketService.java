package com.example.kinozippy.service;

import com.example.kinozippy.entity.Ticket;
import com.example.kinozippy.repository.TicketRepository;
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
