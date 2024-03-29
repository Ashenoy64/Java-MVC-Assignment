package com.mvc.assignment.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.assignment.model.*;
import com.mvc.assignment.service.*;

@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    private MoviesService movieService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private AccountsService accountsService;

    

    @PostMapping("/add_movies")
    public String addMovies(@RequestBody Movies movie) {
        movieService.addMovie(movie);
        return "Movies added";
    }

    @PostMapping("/register")
    public String Register(@RequestBody Accounts entity) {
        accountsService.addAccount(entity);
        return "User Registered";
    }

    @PostMapping("/add_review")
    public String addReview(@RequestBody Review entity) {
        Long movieId = entity.getMovie().getId();
        System.out.println("MovieID "+entity);
        double rating = entity.getRating();
        
        if(movieService.updateRating(movieId, rating));
        reviewService.addReview(entity);


        return "Review added";
    }

    @GetMapping("/delete_reviews")
    public String deleteReview(@RequestParam(name="review",required = true) Long id) {
        reviewService.deleteReview(id);
        return "Review Deleted";
    }

    @PostMapping("/update_review")
    public String updateReview(@RequestBody Review entity) {
        reviewService.updateReview(entity);
        return "Review Updated";
    }


    @PostMapping("/login")
    public String userLogin(@RequestBody Accounts entity) {
        Accounts account = accountsService.getAccount(entity.getUsername());
        if (account == null) {
            return "User not found";
            
        }
        if (account.getPassword().equals(entity.getPassword())) {
            return ""+account.getId();
        }
        return "Invalid password";
    }

    
}
