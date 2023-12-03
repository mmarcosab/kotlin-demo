package com.example.kotlinstudies.service

import com.example.kotlinstudies.data.PersonData
import com.example.kotlinstudies.data.mapper.PersonDataMapper
import com.example.kotlinstudies.data.repository.PersonRepository
import com.example.kotlinstudies.exception.NotFoundException
import com.example.kotlinstudies.model.Person
import com.example.kotlinstudies.model.PersonMapper
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(
        private val repository: PersonRepository,
        private val dataMapper: PersonDataMapper,
        private val personMapper: PersonMapper
): PersonService {

    override fun create(person: Person): Person{
        var result = runCatching {
            // process, metrics etc
        }

        result.onFailure {
            // process errors
        }

        result.onSuccess {
            // process success

        }

        val personData = repository.save(dataMapper.map(person))
        return personMapper.map(personData)
    }

    override fun update(id: Int, person: Person): Person {
        TODO("Not yet implemented")
    }

    override fun findAll(
            pagination: Pageable
    ): Page<Person> {
        return repository.findAll(pagination)
                .map { p ->  personMapper.map(p)}
    }

    override fun findById(id: Int): Person{
        val personData = repository.findById(id)
        if (personData.isEmpty){
            throw NotFoundException("person not found")
        }
        return personMapper.map(personData.get())
    }

    override fun findByName(name: String): Person {
        val personData = repository.findByName(name)
        if (personData.isPresent){
            throw NotFoundException("person not found")
        }
        return personMapper.map(personData.get())
    }

    override fun removeById(id: Int) {
        repository.deleteById(id)
    }
    override fun removeByName(name: String) {
        repository.deleteByName(name)
    }

    override fun findByCombinedFilter(
            id: Int?,
            name: String?,
            surname: String?,
            age: Int?): List<Person> {
        val person = PersonData(id, name, surname, age)
        val listPersonData = repository.findAll(Example.of(person)).toList();
        return listPersonData.map { p -> personMapper.map(p) }
    }

}