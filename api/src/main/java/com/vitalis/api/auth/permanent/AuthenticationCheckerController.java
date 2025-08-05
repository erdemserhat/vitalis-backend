package com.vitalis.api.auth.permanent;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/check-authentication")
@RestController
public class AuthenticationCheckerController {
    @GetMapping
    public ResponseEntity<String> checkAuthenticated(final HttpServletRequest request) {
        // If the endpoint is reached, the user is authenticated
        return ResponseEntity.ok("User is authenticated.");
    }
}
