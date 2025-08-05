package com.vitalis.data.entity

import jakarta.persistence.*
import java.util.*

@Entity
data class Organizer(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    override var id: UUID? = null,
    override val fullName: String = "",
    override val phoneNumber: String? = null,

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    var account: Account? = null

): User(id, fullName, phoneNumber)