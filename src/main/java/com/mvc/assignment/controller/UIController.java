package com.mvc.assignment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

import com.mvc.assignment.model.*;
import com.mvc.assignment.service.*;

@Controller
public class UIController {
    
    @Autowired
    private MoviesService movieService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private AccountsService accountsService;

    @GetMapping("/home")            
    public String index(Model model) {
        List<Movies>moivesList =  movieService.getMovies();
        model.addAttribute("movies",moivesList);
        return "home";
    }
    
    @GetMapping("/movie")
    public String movie( @RequestParam(name = "id",required = true) Long id ,Model model) {
        Movies moive =  movieService.getMovie(id);
        List<Review> reviews = reviewService.getReview(moive);
        model.addAttribute("movie",moive);
        model.addAttribute("reviews",reviews);
        return "movie";
    }

    @GetMapping("/user")
    public String user( @RequestParam(name = "user",required = false,defaultValue = "0") Long user ,Model model) {
        if (user == 0) {
            return "user_login";
        
        }
        Accounts accounts = accountsService.getAccount(user);
        model.addAttribute("user",accounts);
        List<Review> reviews = reviewService.getReview(accounts);
        model.addAttribute("reviews",reviews);
        return "user";
    }
    
    @GetMapping("/add_review")
    public String addReview( @RequestParam(name = "user",required = true,defaultValue = "0") Long user ,Model model) {
        if (user == 0) {
            return "user_login";
        
        }
        Accounts accounts = accountsService.getAccount(user);
        model.addAttribute("user",accounts);

        List<Movies>moivesList =  movieService.getMovies();
        model.addAttribute("movies",moivesList);
        return "add_review";
    }

    @GetMapping("/add_movies")
    public String addMovies(Model model) {
        return "add_movies";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }
}
