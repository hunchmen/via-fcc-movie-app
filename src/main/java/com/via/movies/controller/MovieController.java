/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.movies.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.via.movies.model.Movie;
import com.via.movies.service.MovieService;

/**
 * 
 * @author via
 * 
 * @date 14 Apr 2023
 *
 */
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    // dependency injection can be supported using autowired or using constructor
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),
                HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(
            @PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(
                movieService.getSingleMovie(imdbId), HttpStatus.OK);
    }
}
