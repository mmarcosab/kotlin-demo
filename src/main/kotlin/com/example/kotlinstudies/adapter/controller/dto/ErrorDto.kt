package com.example.kotlinstudies.adapter.controller.dto

import java.time.LocalDateTime

data class ErrorDto(
        val timestamp: LocalDateTime = LocalDateTime.now(),
        val status: Int,
        val error: String,
        val message: String?,
        val path: String
)