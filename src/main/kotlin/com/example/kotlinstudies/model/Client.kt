package com.example.kotlinstudies.model

class Client (
        name: String,
        idade: Int,
        apelido: String
): Person(name, idade, apelido) {
    val id: Long? = null
}