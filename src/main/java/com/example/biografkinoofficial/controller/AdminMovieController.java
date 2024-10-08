package com.example.biografkinoofficial.controller;

import com.example.biografkinoofficial.entity.Movie;
import com.example.biografkinoofficial.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/movies")
public class AdminMovieController {

    @Autowired
    private MovieService movieService;

    // Show all movies
    @GetMapping
    public String showAllMovies(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "admindashboard"; // Return the dashboard view with all movies
    }

    // Show the form to add a new movie
    @GetMapping("/add")
    public String showAddMovieForm(Model model) {
        model.addAttribute("movie", new Movie()); // New Movie object for the form
        return "addMovie"; // Return the form view
    }

    // Process the form to add a new movie
    @PostMapping
    public String addMovie(@ModelAttribute Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/admin/movies"; // Redirect to the movie list
    }

    // Show the form to edit an existing movie
    @GetMapping("/edit/{id}")
    public String showEditMovieForm(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id).orElse(null);
        if (movie != null) {
            model.addAttribute("movie", movie);
            return "editMovie"; // Return the edit form view
        }
        return "redirect:/admin/movies"; // Redirect if movie not found
    }

    // Handle movie update
    @PostMapping("/{id}")
    public String updateMovie(@PathVariable Long id, @ModelAttribute Movie movie) {
        Movie updatedMovie = movieService.updateMovie(id, movie);
        if (updatedMovie != null) {
            return "redirect:/admin/movies"; // Redirect after a successful update
        } else {
            return "error"; // Return an error page or handle as needed
        }
    }

    // Handle movie deletion
    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/admin/movies"; // Redirect to the movie list after deletion
    }
}
