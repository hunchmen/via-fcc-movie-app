/**
 * Licensed Materials - Property of hunchmen
 * 
 * (C) hunchmen. 2023. All Rights Reserved.
 * 
 */
package com.via.movie.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.via.movie.model.Review;

/**
 * 
 * @author via
 * 
 * @date 16 Apr 2023
 *
 */
@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
