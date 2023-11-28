package com.example.kotlinstudies.controller

import com.example.kotlinstudies.dto.PersonRequestDto
import com.example.kotlinstudies.dto.mapper.PersonRequestMapper
import com.example.kotlinstudies.dto.PersonResponseDto
import com.example.kotlinstudies.dto.mapper.PersonResponseMapper
import com.example.kotlinstudies.model.Person
import com.example.kotlinstudies.service.PersonService
import org.hibernate.annotations.Cache
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/persons")
class PersonController(
        private val personService: PersonService,
        private val personRequestMapper: PersonRequestMapper,
        private val personResponseMapper: PersonResponseMapper
) {

    /*
    @GetMapping
    fun findAll(
            @RequestParam(defaultValue = "0") pageNumber: Int,
            @RequestParam(defaultValue = "5") size: Int,
    ): ResponseEntity<Page<PersonResponseDto>> {
        return ResponseEntity.ok(personService.findAll(pageNumber, size)
                .map { p -> personResponseMapper.map(p) })
    }
    */

    @GetMapping
    @Cacheable("persons")
    fun findAll(
            @PageableDefault(size = 5) pagination: Pageable
    ): ResponseEntity<Page<PersonResponseDto>> {
        return ResponseEntity.ok(personService.findAll(pagination)
                .map { p -> personResponseMapper.map(p) })
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): ResponseEntity<PersonResponseDto> {
        return ResponseEntity.ok(personResponseMapper.map(personService.findById(id)))
    }

    @PostMapping
    @Transactional
    @CacheEvict("persons")
    fun createPerson(
            @Valid @RequestBody personRequestDto: PersonRequestDto,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<PersonResponseDto> {
        val responseBody = personResponseMapper.map(personService.create(personRequestMapper.map(personRequestDto)))
        val uri = uriBuilder.path("/persons/${responseBody.id}").build().toUri()
        return ResponseEntity.created(uri).body(responseBody)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletePerson(@PathVariable id: Int) {
        personService.removeById(id)
    }

}