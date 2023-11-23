package com.example.kotlinstudies.service

import com.example.kotlinstudies.model.Person

class PersonServiceImpl: PersonService {

    override fun create(person: Person) {
        try {
            // process
        } catch (ex: NullPointerException) {
            //logs, metrics etc
        }

        var result = runCatching {
            // process, metrics etc
        }

        result.onFailure {
            // process errors
        }

        result.onSuccess {
            // process success
        }

    }

    override fun findAll() {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun findByName(name: String) {
        TODO("Not yet implemented")
    }

    override fun removeById(id: Int) {
        TODO("Not yet implemented")
    }
    override fun removeByName(name: String) {
        TODO("Not yet implemented")
    }

}