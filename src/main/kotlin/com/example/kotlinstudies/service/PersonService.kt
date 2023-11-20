package com.example.kotlinstudies.service

import kotlin.math.log

class PersonService {

    fun create() {
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

}