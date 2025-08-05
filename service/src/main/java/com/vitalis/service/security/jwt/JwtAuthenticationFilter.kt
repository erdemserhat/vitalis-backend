package com.vitalis.service.security.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.LoggerFactory
import org.springframework.lang.NonNull
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Component
class JwtAuthenticationFilter(
    private val jwtService: JwtService
) : OncePerRequestFilter() {
    private val logger = LoggerFactory.getLogger(JwtAuthenticationFilter::class.java)

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        @NonNull request: HttpServletRequest,
        @NonNull response: HttpServletResponse,
        @NonNull filterChain: FilterChain
    ) {
        logger.info("Checking JWT...")

        // Retrieve JWT from Authorization header
        val authHeader = request.getHeader("Authorization")
        val jwtFromHeader = if (authHeader != null && authHeader.startsWith("Bearer ")) {
            authHeader.substring(7) // Extract the token from "Bearer {token}"
        } else {
            null
        }

        // Retrieve JWT from cookies
        val jwtFromCookie = request.cookies?.find { it.name == "JWT_TOKEN" }?.value

        // Use JWT from either the header or cookie
        val jwt = jwtFromHeader ?: jwtFromCookie

        // If no JWT is found, continue the filter chain
        if (jwt == null) {
            filterChain.doFilter(request, response)
            return
        }

        try {
            // Extract the username from the JWT
            val username = jwtService.extractUsername(jwt)

            // Check if the user is authenticated
            if (username != null && SecurityContextHolder.getContext().authentication == null) {
                // Extract roles directly from JWT
                val roles = jwtService.extractClaim(jwt) { claims ->
                    claims["roles"] as List<*>
                }.map { role -> SimpleGrantedAuthority(role.toString()) }

                // Create an Authentication object with extracted roles
                val authToken = UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    roles // Use extracted roles
                )

                // Set the details of the authentication object
                authToken.details = WebAuthenticationDetailsSource().buildDetails(request)

                // Set the authentication in the SecurityContext
                SecurityContextHolder.getContext().authentication = authToken

                logger.info("User '$username' authenticated successfully with roles: $roles")
            }

            // Proceed with the request if everything is fine
            filterChain.doFilter(request, response)
        } catch (exception: Exception) {
            // Handle exceptions like invalid or malformed JWT
            logger.error("JWT validation failed: ${exception.message}", exception)
            response.status = HttpServletResponse.SC_UNAUTHORIZED
            response.writer.write("Invalid or Malformed JWT token")
            response.writer.flush() // Ensure the response is sent immediately
        }
    }
}
