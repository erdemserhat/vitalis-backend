package com.vitalis.api.auth.permanent;


import com.vitalis.common.annotations.PermanentIntention;
import com.vitalis.common.annotations.ShouldOptimized;
import com.vitalis.common.annotations.WorkInProgress;
import com.vitalis.common.dto.LoginResponse;
import com.vitalis.common.dto.AccountRegistrationDto;
import com.vitalis.common.enums.Role;
import com.vitalis.common.dto.LoginUserDto;
import com.vitalis.common.exceptions.InvalidCredentialsException;
import com.vitalis.common.exceptions.UserNotFoundException;
import com.vitalis.data.entity.Account;
import com.vitalis.service.AuthenticationService;
import com.vitalis.service.security.jwt.JwtService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.vitalis.common.enums.Role.*;



import java.util.List;

@RequestMapping("/auth")
@Controller
@CrossOrigin
@PermanentIntention
@ShouldOptimized
@WorkInProgress

/**
 * This controller manages login/register attempts.
 * These endpoints are reachable without authentication & authorization
 */
public class AuthenticationController {
    private final JwtService jwtService;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);


    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> authenticate(
            @RequestBody LoginUserDto loginUserDto,
            HttpServletRequest request,
            HttpServletResponse response

    ) {
        //TODO("IMPLEMENT A LOGIC THAT CONVERTS IPV6 TO IPV4 ")
        String clientIpAddress = extractClientIpAddress(request);
        logger.info("Authentication attempt from IP: {}", clientIpAddress);
        logger.info("Credentials checking...");
        logger.trace("dasdsa");
        //TODO("VALIDATE CREDENTIALS")

        try {
            Account authenticatedAccount = authenticationService.authenticate(loginUserDto);

            logger.info("{} successfully logged in...", authenticatedAccount.getEmail());

            //when a user signs up some roles will be given (test intention)
            // TODO IMPLEMENT A ENUM FOR ROLES
            List<Role> roles = List.of(
                    ROLE_DIETICIAN,
                    ROLE_ORGANIZER,
                    ROLE_DOCTOR,
                    ROLE_PATIENT,
                    ROLE_ADMIN
                    );

            // Generate JWT token (mock token for demonstration)
            String jwtToken = jwtService.generateToken(authenticatedAccount, roles);



            // Create an HTTP-only cookie to store the JWT
            Cookie cookie = new Cookie("JWT_TOKEN", jwtToken);
            cookie.setHttpOnly(true);    // Prevent JavaScript access
            cookie.setSecure(true);      // Ensure cookie is only sent over HTTPS (production)
            cookie.setPath("/");         // Available across the whole application
            cookie.setMaxAge(60 * 60);   // Cookie expires after 1 hour

            // Add the cookie to the response
            response.addCookie(cookie);



            LoginResponse loginResponse = new LoginResponse(
                    jwtToken,
                    jwtService.getExpirationTime()
            );

            logger.info("User Info: {}", loginResponse);
            return ResponseEntity.ok(loginResponse);

            //TODO("IMPLEMENT ALL EXCEPTION CASES")

        } catch (UserNotFoundException e) {
            logger.error("User not found: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found: " + e.getMessage());
        } catch (InvalidCredentialsException e) {
            logger.error("Invalid credentials: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials: " + e.getMessage());
        } catch (AuthenticationException e) {
            logger.error("Authentication failed: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + e.getMessage());
        } catch (Exception e) {
            logger.error("An error occurred: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/login")
    public String loginPresenter(){
        //Thymeleaf handles this operation no need to worry about,
        //If you add files resources/static/x.html and return "x" it will return x.hrml in specified endpoint
        return "login";
    }

    @GetMapping("/signup")
    public String registerPresenter(){
        //Thymeleaf handles this operation no need to worry about,
        //If you add files resources/static/x.html and return "x" it will return x.hrml in specified endpoint
        return "register";
    }

    @PostMapping("/signup")
    public ResponseEntity<Account> register(@RequestBody AccountRegistrationDto accountRegistrationDto) {
        Account registeredAccount = authenticationService.signup(accountRegistrationDto);
        return ResponseEntity.ok(registeredAccount);
    }


    // Helper method to extract the client's IP address
    private String extractClientIpAddress(HttpServletRequest request) {
        String clientIp;

        String xForwardedFor = request.getHeader("X-Forwarded-For");

        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            clientIp = xForwardedFor.split(",")[0];
        } else {
            clientIp = request.getRemoteAddr();
        }

        return clientIp;
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        // Invalidate the current session if it exists
        request.getSession().invalidate();

        // Create a cookie with the same name as the JWT cookie and set its max age to 0 to delete it
        Cookie cookie = new Cookie("JWT_TOKEN", null);
        cookie.setHttpOnly(true);    // Prevent JavaScript access
        cookie.setSecure(true);      // Ensure cookie is only sent over HTTPS
        cookie.setPath("/");         // Available across the whole application
        cookie.setMaxAge(0);         // Expire immediately to clear the cookie

        // Add the cookie to the response
        response.addCookie(cookie);

        // Log the logout event
        logger.info("User logged out, JWT cookie cleared and session invalidated.");

        return ResponseEntity.ok("Successfully logged out.");
    }
}

