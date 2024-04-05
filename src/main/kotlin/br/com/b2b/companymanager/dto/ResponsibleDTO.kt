package br.com.b2b.companymanager.dto

data class ResponsibleDTO (
    val name: String,
    val phone: Number,
    val email: String? = null,
    val occupation: String
)