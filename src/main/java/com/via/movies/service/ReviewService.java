/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.via.movies.model.Movie;
import com.via.movies.model.Review;
import com.via.movies.repository.ReviewRepository;

/**
 * 
 * @author via
 * 
 * @date 16 Apr 2023
 *
 */
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(String reviewBody, String imdbId) {

        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds", review)).first();

        return review;
    }
}
