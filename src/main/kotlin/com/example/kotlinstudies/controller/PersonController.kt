package com.example.kotlinstudies.controller

import com.example.kotlinstudies.dto.PersonRequestDto
import com.example.kotlinstudies.dto.mapper.PersonMapper
import com.example.kotlinstudies.dto.PersonResponseDto
import com.example.kotlinstudies.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/persons")
class PersonController(
        private val personService: PersonService,
        private val personMapper: PersonMapper
) {

    //TODO: rm mocks of responses

    @GetMapping
    fun findAll(): ResponseEntity<List<PersonResponseDto>> {
        return ResponseEntity.ok(listOf(PersonResponseDto(1, "test", "testssss", 10)))
    }

    @GetMapping("/{id}")
    fun findById(id: Int): ResponseEntity<PersonResponseDto> {
        return ResponseEntity.ok(PersonResponseDto(1, "test", "testssss", 10))
    }

    @GetMapping("/{name}")
    fun findByName(name: String): ResponseEntity<PersonResponseDto> {
        personService.findByName(name)
        return ResponseEntity.ok(PersonResponseDto(1, "test", "testssss", 10))
    }

    @PostMapping
    fun createPerson(
            @Valid @RequestBody personRequestDto: PersonRequestDto,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<PersonResponseDto> {
        personService.create(personMapper.map(personRequestDto))
        val uri = uriBuilder.path("/persons/1").build().toUri()
        return ResponseEntity.created(uri).body(PersonResponseDto(1, "test", "testssss", 10))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePerson(@PathVariable id: Int) {
        personService.removeById(id)
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePerson(@PathVariable name: String) {
        personService.removeByName(name)
    }

}