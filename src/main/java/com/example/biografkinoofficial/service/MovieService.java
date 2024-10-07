// MovieService.java
package com.example.biografkinoofficial.service;

import com.example.biografkinoofficial.entity.Movie;
import com.example.biografkinoofficial.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Fetch all movies from the database
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Save a new movie to the database
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie); // Will use JPA to save the movie
    }
}
