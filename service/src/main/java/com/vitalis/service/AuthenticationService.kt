package com.vitalis.service

import com.vitalis.common.dto.AccountRegistrationDto
import com.vitalis.common.dto.LoginUserDto
import com.vitalis.common.exceptions.InvalidCredentialsException
import com.vitalis.common.exceptions.UserNotFoundException
import com.vitalis.data.entity.Account
import com.vitalis.data.repository.AccountRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val accountRepository: AccountRepository,
    private val authenticationManager: AuthenticationManager,
    private val passwordEncoder: PasswordEncoder
) {
    fun signup(input: AccountRegistrationDto): Account {
        val account = Account()
        //TODO("CHECK THE DATA BEFORE TRANSACTION")
        account.email= input.email
        account._password = passwordEncoder.encode(input.password)
        return accountRepository.save(account)
    }

    fun createAccount(input: AccountRegistrationDto): Account {
        val account = Account()
        //TODO("CHECK THE DATA BEFORE TRANSACTION")
        account.email= input.email
        account._password = passwordEncoder.encode(input.password)
        return accountRepository.save(account)
    }





    fun authenticate(input: LoginUserDto): Account? {
        return try {
            // Authenticate the user using the provided email and password
            authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                    input.email,
                    input.password
                )
            )

            // Retrieve the user from the repository and handle the case where the user is not found
            accountRepository.findByEmail(input.email)
                ?.orElseThrow {
                    UserNotFoundException(
                        "User with email ${input.email} not found"
                    )
                }
        } catch (e: Exception) {
            throw InvalidCredentialsException(
                "Invalid credentials for user with email: ${input.email}"
            )
        }
    }
}
