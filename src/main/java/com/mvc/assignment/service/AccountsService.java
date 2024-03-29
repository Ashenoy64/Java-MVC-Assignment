package com.mvc.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.assignment.model.Accounts;
import com.mvc.assignment.repository.AccountsRepository;

@Service
public class AccountsService {
    
    @Autowired
    private AccountsRepository accountsRepo;


    public Accounts getAccount(Long id) {
        return accountsRepo.findById(id).get();
    }

    public Accounts getAccount(String username) {
        return accountsRepo.findByUsername(username).get(0);
    }

    public void addAccount(Accounts account) {
        accountsRepo.save(account);
    }
    
}
