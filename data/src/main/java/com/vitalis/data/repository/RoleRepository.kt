package com.vitalis.data.repository


import com.vitalis.data.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface RoleRepository : JpaRepository<Role?, UUID?> {
    fun findByName(name: com.vitalis.common.enums.Role): Optional<Role?>?
}