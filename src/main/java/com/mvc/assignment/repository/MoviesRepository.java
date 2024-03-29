package com.mvc.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.assignment.model.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
}
