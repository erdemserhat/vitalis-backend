package com.vitalis.common.dto

import com.vitalis.common.enums.Role

data class AccountRegistrationDto(
    val email: String,
    val password: String,
)