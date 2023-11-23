package com.example.kotlinstudies.controller

import com.example.kotlinstudies.dto.PersonDto
import com.example.kotlinstudies.dto.mapper.PersonMapper
import com.example.kotlinstudies.model.Person
import com.example.kotlinstudies.service.PersonService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/persons")
class PersonController(
        private val personService: PersonService,
        private val personMapper: PersonMapper
) {

    @GetMapping
    fun findAll(): List<PersonDto> {
        return listOf(PersonDto("test", "testssss", 10))
    }

    @GetMapping("/{id}")
    fun findAll(id: Int): PersonDto {
        return PersonDto("test", "testssss", 10)
    }

    @PostMapping
    fun createPerson(@Valid @RequestBody personDto: PersonDto): String {
        println(personDto.toString())
        personService.create(personMapper.map(personDto))
        return "OK Created"
    }

    @PutMapping("/{id}")
    fun updatePerson(@PathVariable id: Int,
                     @Valid @RequestBody personDto: PersonDto): String {
        println(personDto.toString())
        personService.update(id, personMapper.map(personDto))
        return "OK Created"
    }
}