package com.mvc.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.assignment.model.Accounts;

import java.util.*;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    List<Accounts> findByUsername(String username);
}
