package com.example.biografkinoofficial.service;

import com.example.biografkinoofficial.entity.Movie;
import com.example.biografkinoofficial.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Page<Movie> getMovies(int page, int size, String search) {
        if (search == null || search.isEmpty()) {
            return movieRepository.findAll(PageRequest.of(page, size));
        } else {
            return movieRepository.findByTitleContainingIgnoreCase(search, PageRequest.of(page, size));
        }
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}