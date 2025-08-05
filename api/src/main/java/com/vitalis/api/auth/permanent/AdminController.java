package com.vitalis.api.auth.permanent;

import com.vitalis.common.annotations.PermanentIntention;
import com.vitalis.common.annotations.ShouldOptimized;
import com.vitalis.common.annotations.WorkInProgress;
import com.vitalis.service.AuthenticationService;
import com.vitalis.service.security.jwt.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@WorkInProgress
@PermanentIntention
@ShouldOptimized
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;


    public AdminController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }


    @GetMapping("/test")
    public String register() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Retrieve username from Authentication object
        String username = "";
        if (authentication != null) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername(); // Username from UserDetails
            } else {
                username = principal.toString(); // If principal is just a username string
            }
        }

        return "admin";
    }


}
