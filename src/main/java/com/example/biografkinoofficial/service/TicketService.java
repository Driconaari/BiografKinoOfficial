package com.example.biografkinoofficial.service;

import com.example.biografkinoofficial.entity.Showing;
import com.example.biografkinoofficial.entity.Ticket;
import com.example.biografkinoofficial.repository.ShowingRepository;
import com.example.biografkinoofficial.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository; // Repository for ticket operations

    @Autowired
    private ShowingRepository showingRepository; // Repository for showing operations

    // Method to retrieve all tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Method to save a new ticket
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Method to retrieve a specific showing by its ID
    public Showing getShowingById(int showingId) {
        Optional<Showing> showingOptional = showingRepository.findById(showingId);
        return showingOptional.orElse(null); // Return showing or null if not found
    }

    // Method to check available seats for a specific showing
    public List<Integer> getAvailableSeats(int showingId) {
        List<Ticket> soldTickets = ticketRepository.findByShowingId(showingId); // Find tickets by showing
        // Assuming seatValue represents the seat number
        return soldTickets.stream()
                .map(Ticket::getSeatValue)
                .toList(); // Convert to a list of seat numbers
    }
}
