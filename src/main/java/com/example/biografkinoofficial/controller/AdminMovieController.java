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
        List<Movie> movies = movieService.getAllMovies(); // Fetch all movies
        model.addAttribute("movies", movies); // Add movies to model
        return "admindashboard"; // Return the view name
    }
/*
    // Show the form to add a new movie
    @GetMapping("/add")
    public String showAddMovieForm(Model model) {
        model.addAttribute("movie", new Movie()); // Provide a new Movie object to the form
        return "addMovie"; // Return the name of the template
    }


 */
   /* // Process the form to add a new movie
    @PostMapping("/add")
    public String addMovie(@ModelAttribute Movie movie) {
        movieService.saveMovie(movie); // Save the movie to the database
        return "redirect:/admin/movies"; // Redirect to the list of movies
    }


    */


    // Show the form to edit an existing movie
    @GetMapping("/edit/{id}")
    public String showEditMovieForm(@PathVariable Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        if (movie != null) {
            model.addAttribute("movie", movie); // Provide the existing Movie object to the form
            return "editMovie"; // Return the name of the template
        }
        return "redirect:/admin/movies"; // Redirect if movie not found
    }

  // Handle movie update form submission
    @PostMapping("/edit/{id}")
    public String updateMovie(@PathVariable Long id, @ModelAttribute Movie movie) {
        movie.setId(id); // Set the movie ID from the path variable
        movieService.updateMovie(id, movie); // Pass both the ID and the Movie object to the service
        return "redirect:/admin/movies"; // Redirect to the list of movies
    }


    // Handle movie deletion
    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id); // Delete the movie from the database
        return "redirect:/admin/movies"; // Redirect to the list of movies
    }

    @PostMapping
    public String addMovie(@ModelAttribute Movie movie) {
        movieService.saveMovie(movie); // Save the movie in the database
        return "redirect:/admin/movies"; // Redirect to the movies list
    }

    @GetMapping("/add")
    public String showAddMovieForm(Model model) {
        model.addAttribute("movie", new Movie()); // Provide a new Movie object to the form
        return "addMovie"; // Return the name of the template
    }
}
