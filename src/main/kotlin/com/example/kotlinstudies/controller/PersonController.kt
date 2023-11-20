package com.example.kotlinstudies.controller

import com.example.kotlinstudies.dto.PersonDto
import com.example.kotlinstudies.model.Person
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/persons")
class PersonController {

    @GetMapping
    fun findAll(): List<Person> {
        return listOf(Person("test", 10, "testssss"));
    }

    @GetMapping("/{id}")
    fun findAll(id: Int): Person {
        return Person("test", id, "testssss");
    }

    @PostMapping
    fun creataPerson(@RequestBody personDto: PersonDto): String {
        println(personDto.toString())
        return "OK Created"
    }

}