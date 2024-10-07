package com.example.biografkinoofficial.controller;

import com.example.biografkinoofficial.entity.Movie;
import com.example.biografkinoofficial.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Page<Movie>> getMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String search) {
        Page<Movie> movies = movieService.getMovies(page, size, search);
        return ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieService.saveMovie(movie);
        return ResponseEntity.ok(savedMovie);
    }
}