package com.example.kotlinstudies.controller

import com.example.kotlinstudies.dto.PersonDto
import com.example.kotlinstudies.dto.mapper.PersonMapper
import com.example.kotlinstudies.model.Person
import com.example.kotlinstudies.service.PersonService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/persons")
class PersonController(
        private val personService: PersonService,
        private val personMapper: PersonMapper
) {

    @GetMapping
    fun findAll(): List<Person> {
        return listOf(Person("test", 10, "testssss"));
    }

    @GetMapping("/{id}")
    fun findAll(id: Int): Person {
        return Person("test", id, "testssss");
    }

    @PostMapping
    fun createPerson(@RequestBody personDto: PersonDto): String {
        println(personDto.toString())
        personService.create(personMapper.map(personDto))
        return "OK Created"
    }

}