package com.example.biografkinoofficial.controller;

import com.example.biografkinoofficial.entity.Movie;
import com.example.biografkinoofficial.entity.Showing;
import com.example.biografkinoofficial.service.TicketService; // Ensure this is the correct import for your service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService; // Assuming you have a service to handle Ticket logic

    @GetMapping("/movies")
    public String listMovies(Model model) {
        List<Movie> movies = getAllMovies(); // Fetch movie list from a service or database
        model.addAttribute("movies", movies);
        return "index"; // This returns the index.html template
    }

    @GetMapping("/showing/{showingId}")
    public ResponseEntity<Showing> getShowingDetails(@PathVariable int showingId) {
        Showing showing = ticketService.getShowingById(showingId); // Fetch showing details from service
        return ResponseEntity.ok(showing);
    }

    @GetMapping("/buy-tickets")
    public String showPurchasePage(Model model) {
        return "purchase"; // This returns the purchase.html template
    }

    private List<Movie> getAllMovies() {
        // Dummy data for now, replace with actual database calls
        return List.of(
                new Movie("Inception", new Date(), 8.8, 148, "Sci-Fi", 13),
                new Movie("Titanic", new Date(), 7.8, 195, "Romance", 12),
                new Movie("Avengers: Endgame", new Date(), 8.4, 181, "Action", 13)
        );
    }
}
