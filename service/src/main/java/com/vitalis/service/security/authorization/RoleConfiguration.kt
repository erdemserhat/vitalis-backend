package com.vitalis.service.security.authorization

import com.vitalis.data.entity.Doctor
import com.vitalis.data.entity.Role
import com.vitalis.data.repository.DoctorRepository
import com.vitalis.data.repository.RoleRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Automatically adds to default roles if not added before.
 */
@Configuration
open class RoleConfiguration(
    private val roleRepository: RoleRepository,
) {
    val logger: Logger = LoggerFactory.getLogger(RoleConfiguration::class.java)


    @Bean
    open fun initRoles(): CommandLineRunner {
        logger.info("Role configuration checking...")
        return CommandLineRunner {
            val roles = listOf(
                com.vitalis.common.enums.Role.ROLE_DEFAULT,
                com.vitalis.common.enums.Role.ROLE_DOCTOR,
                com.vitalis.common.enums.Role.ROLE_ORGANIZER,
                com.vitalis.common.enums.Role.ROLE_PATIENT,
                com.vitalis.common.enums.Role.ROLE_ADMIN,
                com.vitalis.common.enums.Role.ROLE_DIETICIAN


            )

            roles.forEach { role ->
                if (!roleRepository.findByName(role)?.isPresent!!) {
                    val _role = Role()
                    _role.name = role
                    //roleRepository.save(_role)
                    logger.info("Added role: ${_role.name}")
                }
            }
        }
    }
}