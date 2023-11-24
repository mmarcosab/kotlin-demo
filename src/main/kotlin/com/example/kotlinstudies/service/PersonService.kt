package com.example.kotlinstudies.service

import com.example.kotlinstudies.model.Person

interface PersonService {
    fun create(person: Person): Person
    fun update(id: Int, person: Person): Person
    fun findAll(): List<Person>
    fun findById(id: Int): Person
    fun findByName(name: String): Person
    fun removeById(id: Int)
    fun removeByName(name: String)
}