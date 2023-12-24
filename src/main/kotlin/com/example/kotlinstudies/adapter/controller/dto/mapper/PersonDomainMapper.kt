package com.example.kotlinstudies.adapter.controller.dto.mapper

import com.example.kotlinstudies.adapter.controller.dto.PersonRequestDto
import com.example.kotlinstudies.domain.model.Person
import com.example.kotlinstudies.utils.Mapper
import org.springframework.stereotype.Component


@Component
class PersonDomainMapper: Mapper<PersonRequestDto, Person> {
    override fun map(t: PersonRequestDto): Person {
       return Person(
               t.name,
               t.age,
               t.surname)
    }

}