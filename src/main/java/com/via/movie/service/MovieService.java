/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.movie.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.via.movie.model.Movie;
import com.via.movie.repository.MovieRepository;

/**
 * 
 * @author via
 * 
 * @date 16 Apr 2023
 *
 */
@Service
public class MovieService {

    // dependency injection can be supported using @Autowired or by constructor
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getSingleMovie(String imdbId) {

        return movieRepository.findMovieByImdbId(imdbId);
    }
}
