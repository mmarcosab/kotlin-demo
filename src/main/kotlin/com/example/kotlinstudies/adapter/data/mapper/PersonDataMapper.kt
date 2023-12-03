package com.example.kotlinstudies.adapter.data.mapper

import com.example.kotlinstudies.adapter.data.PersonData
import com.example.kotlinstudies.domain.model.Person
import com.example.kotlinstudies.utils.Mapper
import org.springframework.stereotype.Component

@Component
class PersonDataMapper: Mapper<Person, PersonData> {
    override fun map(t: Person): PersonData {
       return PersonData(
               t.id,
               t.name,
               t.surname,
               t.age)
    }
}