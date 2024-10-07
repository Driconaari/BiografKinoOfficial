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

    public List<Movie> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        System.out.println("Movies from Repository: " + movies); // Add logging here
        return movies;
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }


}
