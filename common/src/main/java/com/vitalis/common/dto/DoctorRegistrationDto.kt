package com.vitalis.common.dto

class DoctorRegistrationDto(
    override val fullName: String,
    override val phoneNumber: String?,
    override val accountRegistrationDto: AccountRegistrationDto,
    val speciality: String = ""

):UserRegistrationDto(fullName,phoneNumber,accountRegistrationDto)