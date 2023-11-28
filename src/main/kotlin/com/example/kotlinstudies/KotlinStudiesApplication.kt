package com.example.kotlinstudies

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class KotlinStudiesApplication

fun main(args: Array<String>) {
	runApplication<KotlinStudiesApplication>(*args)
}
