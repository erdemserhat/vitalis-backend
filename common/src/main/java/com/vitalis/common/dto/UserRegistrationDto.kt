package com.vitalis.common.dto

import java.util.*

open class UserRegistrationDto(
    open val fullName: String = "",
    open val phoneNumber: String? = null,
    open val accountRegistrationDto: AccountRegistrationDto
)