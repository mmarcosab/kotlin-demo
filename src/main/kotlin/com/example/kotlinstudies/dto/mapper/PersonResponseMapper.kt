package com.example.kotlinstudies.dto.mapper

import com.example.kotlinstudies.dto.PersonResponseDto
import com.example.kotlinstudies.model.Person
import com.example.kotlinstudies.utils.Mapper
import org.springframework.stereotype.Component


@Component
class PersonResponseMapper: Mapper<Person, PersonResponseDto> {
    override fun map(t: Person): PersonResponseDto {
       return PersonResponseDto(
               t.id,
               t.name,
               t.surname,
               t.age)
    }

}