package com.vitalis.service.security.authentication

import com.vitalis.common.annotations.PermanentIntention
import com.vitalis.data.entity.Account
import com.vitalis.data.repository.AccountRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.*

/**
 *
 */
@Configuration
@PermanentIntention
open class AuthenticationConfiguration(private val accountRepository: AccountRepository) {
    @Bean
    open fun userDetailsService(): UserDetailsService {
        return UserDetailsService { username: String? ->
            // Check if username is null
            if (username.isNullOrEmpty()) {
                throw UsernameNotFoundException("Username cannot be null or empty")
            }

            // Retrieve user from repository
            val accountOptional: Optional<Account?>? = accountRepository.findByEmail(username)

            // Use safe call or check if userOptional is null
            accountOptional?.let {
                it.orElseThrow {
                    UsernameNotFoundException("User not found")
                }
            } ?: throw UsernameNotFoundException("User not found")
        }
    }

    @Bean
    open fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    @Throws(Exception::class)
    open fun authenticationManager(config: AuthenticationConfiguration): AuthenticationManager {
        return config.authenticationManager
    }

    @Bean
    open fun authenticationProvider(): AuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()

        authProvider.setUserDetailsService(userDetailsService())
        authProvider.setPasswordEncoder(passwordEncoder())

        return authProvider
    }
}