package com.vitalis.data.repository

import com.vitalis.data.entity.Dietician
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface DieticianRepository: JpaRepository<Dietician?, UUID?> {

}