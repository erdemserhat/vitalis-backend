package com.vitalis.data.entity

import com.vitalis.common.dto.AccountRegistrationDto
import com.vitalis.common.dto.DoctorRegistrationDto
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import java.util.UUID

import com.vitalis.common.enums.Role
import jakarta.persistence.*
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import java.util.*

@Entity
data class Doctor(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    override var id: UUID? = null,
    override var fullName: String = "",
    override var phoneNumber: String? = null,

    @OneToOne(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    var account: Account? = null,

    val speciality: String = ""
) : User(id, fullName, phoneNumber)


fun DoctorRegistrationDto.convertEntity(account: Account?): Doctor {
    val fullName = this.fullName
    val phoneNumber = this.phoneNumber
    val speciality = this.speciality

    val doctor = Doctor()

    doctor.fullName = fullName
    doctor.phoneNumber = phoneNumber
    doctor.account = account

    return doctor

}


