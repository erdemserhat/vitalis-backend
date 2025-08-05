package com.vitalis.common.dto

data class LoginResponse(
    var token:String,
    var expiresIn:Long
)