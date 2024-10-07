package com.example.biografkinoofficial.controller;

import com.example.biografkinoofficial.entity.Movie;
import com.example.biografkinoofficial.entity.Showing;
import com.example.biografkinoofficial.service.MovieService;
import com.example.biografkinoofficial.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private MovieService movieService; // Inject MovieService

    @GetMapping("/movies")
    public String listMovies(Model model) {
        List<Movie> movies = getAllMovies(); // Fetch movie list from the database
        model.addAttribute("movies", movies);
        return "index"; // This returns the index.html template
    }

    @GetMapping("/showing/{showingId}")
    public ResponseEntity<Showing> getShowingDetails(@PathVariable int showingId) {
        Showing showing = ticketService.getShowingById(showingId);
        return ResponseEntity.ok(showing);
    }

    @GetMapping("/buy-tickets")
    public String showPurchasePage(Model model) {
        return "purchase"; // This returns the purchase.html template
    }

    private List<Movie> getAllMovies() {
        return movieService.getAllMovies(); // Fetch movies from the database
    }
}