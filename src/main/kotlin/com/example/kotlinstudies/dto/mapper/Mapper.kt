package com.example.kotlinstudies.dto.mapper

import org.apache.catalina.mapper.Mapper

interface Mapper<T, U> {
    fun map(t: T): U
}