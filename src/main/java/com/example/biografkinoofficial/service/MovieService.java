package com.example.biografkinoofficial.service;

import com.example.biografkinoofficial.entity.Movie;
import com.example.biografkinoofficial.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        return movieOptional.orElse(null);
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        if (movieRepository.existsById(id)) {
            movie.setId(id);
            return movieRepository.save(movie);
        }
        return null;
    }

    public boolean deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<Movie> getMovies(int page, int size, String search) {
        if (search == null || search.isEmpty()) {
            return movieRepository.findAll(PageRequest.of(page, size));
        } else {
            return movieRepository.findByTitleContainingIgnoreCase(search, PageRequest.of(page, size));
        }
    }
}