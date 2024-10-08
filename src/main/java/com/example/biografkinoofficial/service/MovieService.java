package com.example.biografkinoofficial.service;

import com.example.biografkinoofficial.entity.Movie;
import com.example.biografkinoofficial.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Movie updateMovie(Long id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            movie.setTitle(movieDetails.getTitle());
            movie.setRelease_date(movieDetails.getRelease_date());
            movie.setRating(movieDetails.getRating());
            movie.setLength(movieDetails.getLength());
            movie.setGenre(movieDetails.getGenre());
            movie.setAge_limit(movieDetails.getAge_limit());
            return movieRepository.save(movie);
        }
        return null;
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
