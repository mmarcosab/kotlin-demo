package com.example.kotlinstudies.service

import com.example.kotlinstudies.model.Person
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PersonService {
    fun create(person: Person): Person
    fun update(id: Int, person: Person): Person
    fun findAll(pagination: Pageable): Page<Person>
    fun findById(id: Int): Person
    fun findByName(name: String): Person
    fun removeById(id: Int)
    fun removeByName(name: String)
    fun findByCombinedFilter(
            id: Int?,
            name: String?,
            surname: String?,
            age: Int?): List<Person>
}