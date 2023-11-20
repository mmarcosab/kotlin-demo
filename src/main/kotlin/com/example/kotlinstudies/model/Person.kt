package com.example.kotlinstudies.model

class Person (val name: String, val idade: Int,val apelido: String){

    override fun toString(): String {
        return "Person(name='$name', idade=$idade, apelido='$apelido')"
    }
}