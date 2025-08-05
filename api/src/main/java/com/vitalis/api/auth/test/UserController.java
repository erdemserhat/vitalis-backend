package com.vitalis.api.auth.test;


import com.vitalis.common.dto.DoctorRegistrationDto;
import com.vitalis.data.entity.Account;
import com.vitalis.data.entity.Doctor;
import com.vitalis.service.AccountService;
import com.vitalis.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
@CrossOrigin
/**
 * This class is only for test intention DO NOT DELETE PLEASE.
 *
 */
public class UserController {
    private final AccountService accountService;
    private final DoctorService doctorService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    public UserController(AccountService accountService,DoctorService doctorService) {
        this.accountService = accountService;
        this.doctorService = doctorService;
    }

    @GetMapping("/me")
    public ResponseEntity<Account> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Account currentAccount = (Account) authentication.getPrincipal();

        return ResponseEntity.ok(currentAccount);
    }

    @GetMapping("/")
    public ResponseEntity<List<Account>> allUsers() {
        logger.info("Users fetched successfully");
        List <Account> accounts = accountService.allUsers();
        accounts.forEach(System.out::println);
        logger.info(accounts.toString());  // Log the entire list


        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/add-doctor")
    public void addDoctor(@RequestBody DoctorRegistrationDto doctor) {
        doctorService.addDoctor(doctor);

    }
}