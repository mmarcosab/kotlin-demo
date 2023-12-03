package com.example.kotlinstudies.kafka

interface MessageSender {
    fun send(message: String, obj: Any)
}