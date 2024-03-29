package com.mvc.assignment.model;

import jakarta.persistence.*;


@Entity
public class Review {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String review;
        private double rating;
    
        @ManyToOne
        private Movies movie;    

        @ManyToOne
        private Accounts account;
        
    
        public Review() {
        }
    
        public Review(String review, double rating,Movies movie,Accounts acount) {
            super();
            this.review = review;
            this.rating = rating;
            this.movie = movie;
            this.account = acount;
        }
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getReview() {
            return review;
        }
    
        public void setReview(String review) {
            this.review = review;
        }
    
        public double getRating() {
            return rating;
        }
    
        public void setRating(double rating) {
            this.rating = rating;
        }
    
        public Movies getMovie() {
            return movie;
        }

        public void setMovie(Movies movie) {
            this.movie = movie;
        }

        public Accounts getAccount() {
            return account;
        }

        public void setAccount(Accounts account) {
            this.account = account;
        }
        
}
