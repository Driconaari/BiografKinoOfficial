package com.example.biografkinoofficial.controller;

import com.example.biografkinoofficial.entity.Movie;
import com.example.biografkinoofficial.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MovieService movieService;

    // Admin dashboard page
    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies); // Add movies to the model for Thymeleaf
        return "admindashboard"; // Return the view name for the admin dashboard
    }

    // Fetch all movies (admin only)
    @GetMapping("/api/movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    // Get a movie by ID (admin only)
    @GetMapping("/api/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Optional<Movie> movieOptional = movieService.getMovieById(id);
        return movieOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a movie (admin only)
    @PostMapping("/api/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieService.saveMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    // Update a movie (admin only)
    @PutMapping("/api/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(id, movie);
        return updatedMovie != null ? ResponseEntity.ok(updatedMovie) : ResponseEntity.notFound().build();
    }

    // Delete a movie (admin only)
    @DeleteMapping("/api/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        boolean isDeleted = movieService.deleteMovie(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Show the edit movie form
    @GetMapping("/edit/{id}")
    public String showEditMovieForm(@PathVariable Long id, Model model) {
        Optional<Movie> movieOptional = movieService.getMovieById(id);
        if (movieOptional.isPresent()) {
            model.addAttribute("movie", movieOptional.get());
            return "editMovie"; // Return the name of the template
        }
        return "redirect:/admin/dashboard"; // Redirect if movie not found
    }

    // Update movie via form submission
    @PostMapping("/update/{id}")
    public String updateMovieForm(@PathVariable Long id, @ModelAttribute Movie movie) {
        movieService.updateMovie(id, movie);
        return "redirect:/admin/dashboard"; // Redirect after update
    }
}
