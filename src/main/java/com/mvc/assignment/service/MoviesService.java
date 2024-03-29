package com.mvc.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.assignment.model.*;
import com.mvc.assignment.repository.MoviesRepository;

import java.util.List;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository movieRepo;
    @Autowired
    private ReviewService reviewService;


    public List<Movies> getMovies() {
        return movieRepo.findAll();
    }

    public Movies getMovie(Long id) {
        return movieRepo.findById(id).orElse(null);
    }

    public void addMovie(Movies _movie) {
        movieRepo.save(_movie);
    }

    public Boolean updateRating(Long id, double rating) {
        System.out.println(id);
        Movies _movie = this.getMovie(id);
        if(_movie == null) {
            return false;
        }
        List<Review> list =  reviewService.getReview(_movie);
        int count = 0;
        if(list != null) {
            count = list.size();
        }
        double currentRating = _movie.getRating();
        double newRating = (currentRating * count + rating) / (count + 1);
        _movie.setRating(newRating);
        movieRepo.save(_movie);
        return true;
    }   
}
