package com.example.kotlinstudies.adapter.config

import com.fasterxml.jackson.databind.JsonNode

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.support.serializer.JsonSerializer

@Configuration
class KafkaConfig {

    //@Value("\${bootstrap.servers}")
    private var servers : String = "127.0.0.1:29092"

    private fun config() : Map<String, Any> {
        return HashMap<String, Any>().apply {
            put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, servers)
            put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java)
            put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer::class.java)
        }
    }

    @Bean
    fun producerJson() : KafkaProducer<String, JsonNode> = KafkaProducer(config())
}