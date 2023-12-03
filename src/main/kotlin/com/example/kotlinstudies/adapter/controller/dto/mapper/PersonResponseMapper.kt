package com.example.kotlinstudies.adapter.controller.dto.mapper

import com.example.kotlinstudies.adapter.controller.dto.PersonResponseDto
import com.example.kotlinstudies.domain.model.Person
import com.example.kotlinstudies.utils.Mapper
import org.springframework.stereotype.Component

@Component
class PersonResponseMapper: Mapper<Person, PersonResponseDto> {
    override fun map(t: Person): PersonResponseDto {
       return PersonResponseDto(
               t.id,
               t.name,
               t.age,
               t.surname)
    }

}