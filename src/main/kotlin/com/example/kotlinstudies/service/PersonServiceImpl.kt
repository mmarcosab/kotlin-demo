package com.example.kotlinstudies.service

class PersonServiceImpl: PersonService {

    override fun create() {
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

    override fun findById() {
        TODO("Not yet implemented")
    }

    override fun findByName() {
        TODO("Not yet implemented")
    }

    override fun removeById() {
        TODO("Not yet implemented")
    }

}