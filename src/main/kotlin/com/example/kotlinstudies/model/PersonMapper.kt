package com.example.kotlinstudies.model

import com.example.kotlinstudies.data.PersonData
import com.example.kotlinstudies.dto.PersonRequestDto
import com.example.kotlinstudies.model.Person
import com.example.kotlinstudies.utils.Mapper
import org.springframework.stereotype.Component


@Component
class PersonMapper: Mapper<PersonData, Person> {
    override fun map(t: PersonData): Person {
       return Person(
               t.id,
               t.name,
               t.age,
               t.surname)
    }

}