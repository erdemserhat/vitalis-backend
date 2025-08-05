package com.vitalis.data.repository

import com.vitalis.data.entity.Organizer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface OrganizerRepository : JpaRepository<Organizer?, UUID?>