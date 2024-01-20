package com.example.kotlinstudies.adapter.messaging

import com.example.kotlinstudies.adapter.config.KafkaConfig
import com.example.kotlinstudies.domain.model.Person
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class MessageSenderTest {

    val kafkaConfig : KafkaConfig = mockk {
        every { producerJson() } returns mockk()
    }
    val messageSender: MessegeSenderImpl = MessegeSenderImpl(kafkaConfig)
    val topicName = "test"

    @Test
    fun `must send a message with a person json`() {

        messageSender.send(topicName, mockPerson())
        verify (exactly = 1) {messageSender.send(any(), any())}
    }

    fun mockPerson() : Person {
        return Person(1, "test", 99, "test")
    }
}