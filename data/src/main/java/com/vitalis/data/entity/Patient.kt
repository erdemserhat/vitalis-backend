package com.vitalis.data.entity

import com.vitalis.common.enums.Role
import jakarta.persistence.*
import java.util.*

@Entity
data class Patient(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    override var id: UUID? = null,
    override val fullName: String = "",
    override val phoneNumber: String? = null,


    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    var account: Account? = null,

    val secondaryPhoneNumber: String = "",
    val age: Byte = 0,
    val maritalStatus: Boolean = false,
) : User(id, fullName, phoneNumber)