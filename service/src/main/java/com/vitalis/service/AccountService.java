package com.vitalis.service;

import com.vitalis.data.entity.Account;
import com.vitalis.data.entity.Role;
import com.vitalis.data.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> allUsers() {
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts::add);

        return accounts;
    }

    public Set<Role> getUserRolesByEmail(String email) {
        Optional<Account> userOptional = accountRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            Account account = userOptional.get();
            return account.get_roles(); // Accessing the roles of the user
        } else {
            // Handle the case where the user is not found
            throw new RuntimeException("User not found");
        }
    }


}