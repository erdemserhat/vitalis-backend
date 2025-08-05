package com.vitalis.common.enums


import org.springframework.security.core.GrantedAuthority

enum class Role(val value: String): GrantedAuthority {
    ROLE_DOCTOR("DOCTOR"),
    ROLE_ORGANIZER("ORGANIZER"),
    ROLE_DIETICIAN("DIETICIAN"),
    ROLE_PATIENT("PATIENT"),
    ROLE_ADMIN("ADMIN"),
    ROLE_DEFAULT("DEFAULT");

    override fun getAuthority(): String {
        return name
    }

}