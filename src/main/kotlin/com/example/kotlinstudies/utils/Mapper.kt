package com.example.kotlinstudies.utils

interface Mapper<T, U> {
    fun map(t: T): U
}