/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.movie.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.via.movie.model.Review;
import com.via.movie.service.ReviewService;

/**
 * 
 * @author via
 * 
 * @date 16 Apr 2023
 *
 */
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    // dependency injection is supported by @Autowired or by constructor
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(
            @RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(reviewService
                .createReview(payload.get("reviewBody"), payload.get("imdbId")),
                HttpStatus.CREATED);
    }
}
