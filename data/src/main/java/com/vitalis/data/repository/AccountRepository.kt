package com.vitalis.data.repository

import com.vitalis.data.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface AccountRepository : JpaRepository<Account?, UUID?> {
    fun findByEmail(email: String?): Optional<Account?>?
}