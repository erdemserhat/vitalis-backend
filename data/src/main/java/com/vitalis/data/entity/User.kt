package com.vitalis.data.entity
import jakarta.persistence.*
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import java.util.stream.Collectors

@MappedSuperclass
open class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    open var id: UUID? = null,
    open val fullName: String = "",
    open val phoneNumber: String? = null
)