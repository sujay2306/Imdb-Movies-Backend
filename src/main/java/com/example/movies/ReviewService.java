package com.example.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    private MongoTemplate mongoTemplate;
    public Review createReview(String reviewBody, String ImdbId){
        Review review = new Review(reviewBody);
        reviewRepository.insert(review);

    }
}
