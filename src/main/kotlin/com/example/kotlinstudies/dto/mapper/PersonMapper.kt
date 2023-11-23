package com.example.kotlinstudies.dto.mapper

import com.example.kotlinstudies.dto.PersonDto
import com.example.kotlinstudies.model.Person
import org.springframework.stereotype.Component


@Component
class PersonMapper: Mapper<PersonDto, Person> {
    override fun map(t: PersonDto): Person {
       return Person(
               t.name,
               t.age,
               t.surname)
    }

}