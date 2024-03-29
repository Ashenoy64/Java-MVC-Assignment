package com.mvc.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.assignment.model.*;
import com.mvc.assignment.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepo;

    public List<Review> getReview(Movies movie) {
        return reviewRepo.findByMovieId(movie.getId());
    }
    
    public List<Review> getReview(Accounts accounts) {
        return reviewRepo.findByAccountId(accounts.getId());
    }

    public void addReview(Review review) {
        reviewRepo.save(review);
    }

    public void deleteReview(Review review) {
        reviewRepo.delete(review);
    }

    public void deleteReview(Long id) {
        reviewRepo.deleteById(id);
    }

    public void updateReview(Review review) {
        reviewRepo.save(review);
    }

}
