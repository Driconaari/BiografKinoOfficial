package com.example.biografkinoofficial.service;

import com.example.biografkinoofficial.entity.Movie;
import com.example.biografkinoofficial.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Fetch all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll(); // Fetch all movies from the repository
    }

    // Fetch a single movie by ID
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    // Add or save a movie
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Update an existing movie
    public Movie updateMovie(Long id, Movie movie) {
        Optional<Movie> existingMovieOpt = movieRepository.findById(id);
        if (existingMovieOpt.isPresent()) {
            Movie existingMovie = existingMovieOpt.get();
            existingMovie.setTitle(movie.getTitle());
            existingMovie.setRelease_date(movie.getRelease_date());
            existingMovie.setRating(movie.getRating());
            existingMovie.setGenre(movie.getGenre());
            existingMovie.setLength(movie.getLength());
            existingMovie.setAge_limit(movie.getAge_limit());
            return movieRepository.save(existingMovie); // Save and return the updated movie
        }
        return null; // or throw an exception if the movie is not found
    }

    // Delete a movie
    public boolean deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Paginated movie fetching with optional search

    public Page<Movie> getMovies(int page, int size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (search != null && !search.isEmpty()) {
            return movieRepository.findByTitleContainingIgnoreCase(search, pageable); // Assuming you have this method in the repository
        }
        return movieRepository.findAll(pageable); // Fetch all if no search term
    }
}
