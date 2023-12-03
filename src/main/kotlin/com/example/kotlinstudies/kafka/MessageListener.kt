package com.example.kotlinstudies.kafka

interface MessageListener {

    fun receive(message: String): String
}