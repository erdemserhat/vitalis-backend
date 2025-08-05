package com.vitalis.data.repository

import com.vitalis.data.entity.Account
import com.vitalis.data.entity.Doctor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository

interface DoctorRepository : JpaRepository<Doctor?, UUID?> {
}