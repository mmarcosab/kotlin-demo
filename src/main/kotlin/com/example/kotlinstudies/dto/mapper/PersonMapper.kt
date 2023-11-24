package com.example.kotlinstudies.dto.mapper

import com.example.kotlinstudies.dto.PersonRequestDto
import com.example.kotlinstudies.model.Person
import org.springframework.stereotype.Component


@Component
class PersonMapper: Mapper<PersonRequestDto, Person> {
    override fun map(t: PersonRequestDto): Person {
       return Person(
               t.name,
               t.age,
               t.surname)
    }

}