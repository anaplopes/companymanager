package br.com.b2b.companymanager.dto

import java.time.LocalDateTime

data class ErrorHandler (
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val statusCode: Int,
    val error: String,
    val message: String?,
    val path: String
)
