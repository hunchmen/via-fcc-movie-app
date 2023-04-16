/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.movie.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.via.movie.model.Movie;
import com.via.movie.service.MovieService;

/**
 * 
 * @author via
 * 
 * @date 16 Apr 2023
 *
 */
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    // dependency injection can be supported using autowire or by constructor
    private final MovieService movieService;

    public MovieController(MovieService movieService) {

        this.movieService = movieService;

    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {

        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);

    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(
            @PathVariable String imdbId) {

        return new ResponseEntity<Optional<Movie>>(
                movieService.getSingleMovie(imdbId), HttpStatus.OK);

    }

}
