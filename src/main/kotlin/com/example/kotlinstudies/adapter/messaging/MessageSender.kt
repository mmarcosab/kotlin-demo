package com.example.kotlinstudies.adapter.messaging

interface MessageSender {
    fun send(topic: String, obj: Any)
}