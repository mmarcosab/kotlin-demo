package com.example.kotlinstudies.domain.model

import com.example.kotlinstudies.adapter.data.PersonData
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