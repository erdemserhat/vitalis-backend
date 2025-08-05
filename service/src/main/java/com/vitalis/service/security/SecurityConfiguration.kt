package com.vitalis.service.security

import com.vitalis.common.enums.Role
import com.vitalis.service.security.jwt.JwtAuthenticationFilter
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@Configuration
@EnableWebSecurity
open class SecurityConfiguration(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter,
    private val authenticationProvider: AuthenticationProvider
) {
    @Bean
    open fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { csrf -> csrf.disable() } // Disable CSRF protection
            .authorizeHttpRequests { auth ->

                auth.requestMatchers("/auth/**").permitAll()
                    .requestMatchers("/").permitAll()
                    .requestMatchers( "/favicon.ico").permitAll()
                    .requestMatchers("/login.html").permitAll() // Allow access to login.html
                    .requestMatchers("/admin/**").hasRole(Role.ROLE_ADMIN.value)
                    .requestMatchers("/organiser/**").hasRole(Role.ROLE_ORGANIZER.value)
                    .requestMatchers("/dietitian/**").hasRole(Role.ROLE_DIETICIAN.value)
                    .requestMatchers("/doctor/**").hasRole(Role.ROLE_DOCTOR.value)
                    .anyRequest().authenticated()

            }
            .sessionManagement { session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)

        return http.build()
    }

}
