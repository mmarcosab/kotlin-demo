package com.example.kotlinstudies.service

import com.example.kotlinstudies.model.Person

interface PersonService {
    fun create(person: Person)
    fun findAll()
    fun findById(id: Int)
    fun findByName(name: String)
    fun removeById(id: Int)
    fun removeByName(name: String)
}