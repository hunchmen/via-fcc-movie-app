/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.movies.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.via.movies.model.Review;
import com.via.movies.service.ReviewService;

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

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(
            @RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(
                reviewService.createReview("reviewBody", payload.get("imdbId")),
                HttpStatus.OK);
    }
}
