package com.example.kotlinstudies.model

open class Person (val name: String, val age: Int, val surname: String){

    var id: Int = 0
        get
        set
    override fun toString(): String {
        return "Person(id='$id', name='$name', age=$age, surname='$surname')"
    }
}