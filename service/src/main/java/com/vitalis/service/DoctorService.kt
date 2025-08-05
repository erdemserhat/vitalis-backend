package com.vitalis.service

import com.vitalis.common.dto.AccountRegistrationDto
import com.vitalis.common.dto.DoctorRegistrationDto
import com.vitalis.common.enums.Role
import com.vitalis.data.entity.Account
import com.vitalis.data.entity.Doctor
import com.vitalis.data.entity.convertEntity
import com.vitalis.data.repository.AccountRepository
import com.vitalis.data.repository.DoctorRepository
import com.vitalis.data.repository.RoleRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class DoctorService(
    private val accountRepository: AccountRepository,
    private val doctorRepository: DoctorRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun addDoctor(doctor: DoctorRegistrationDto) {
        // Check if the role exists in the database if not exist add the role and restart the process
        try {
            val doctorRole = roleRepository.findByName(Role.ROLE_DOCTOR)?.get()

            // Create account entity with the existing or newly created role
            val accountEntity = doctor.accountRegistrationDto.convertEntity().apply {
                setRoles(
                    mutableSetOf(
                        doctorRole as com.vitalis.data.entity.Role

                    )
                )
                //encode the password
                _password = passwordEncoder.encode(password)


            }

            // Convert doctor DTO to entity and save it
            val doctorEntity = doctor.convertEntity(accountEntity)
            doctorRepository.save(doctorEntity)

        } catch (e: NoSuchElementException) {
            //If role not exist add the role and start the process from scratch
            roleRepository.save(com.vitalis.data.entity.Role(name = Role.ROLE_DOCTOR))
            addDoctor(doctor)

        }
    }
}