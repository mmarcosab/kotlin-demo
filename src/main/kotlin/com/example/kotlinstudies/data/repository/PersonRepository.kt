package com.example.kotlinstudies.data.repository

import com.example.kotlinstudies.data.PersonData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: JpaRepository<Int, PersonData> {

}