package com.example.kotlinstudies.model

open class Person (val name: String, val age: Int, val surname: String){

    override fun toString(): String {
        return "Person(name='$name', age=$age, surname='$surname')"
    }
}