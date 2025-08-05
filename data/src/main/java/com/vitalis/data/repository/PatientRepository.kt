package com.vitalis.data.repository

import com.vitalis.data.entity.Patient
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface PatientRepository : JpaRepository<Patient?, UUID?>