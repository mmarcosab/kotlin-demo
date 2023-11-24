package com.example.kotlinstudies.data.repository

import com.example.kotlinstudies.data.PersonData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PersonRepository: JpaRepository<PersonData, Int> {
    fun findByName(name: String): Optional<PersonData>
    fun deleteByName(name: String)
}