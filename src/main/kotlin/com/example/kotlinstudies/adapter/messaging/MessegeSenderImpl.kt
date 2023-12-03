package com.example.kotlinstudies.adapter.messaging

import com.example.kotlinstudies.adapter.config.KafkaConfig
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.RecordMetadata
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class MessegeSenderImpl(val kafkaConfig : KafkaConfig): MessageSender {

    @Autowired
    private lateinit var kafkaTemplate : KafkaTemplate<String, String>

    private val producerJson = kafkaConfig.producerJson()

    override fun send(topic : String, obj : Any) {
        val node = ObjectMapper().valueToTree<JsonNode>(obj)
        val record: ProducerRecord<String, JsonNode> = ProducerRecord(topic, node)

        producerJson.send(record) { metadata: RecordMetadata?, exception: Exception? ->
            println(exception ?: metadata)
        }
    }
}