package br.com.b2b.companymanager.entities

import java.time.LocalDateTime
import java.util.UUID

data class CompanyEntity (
    val id: String = UUID.randomUUID().toString(),
    val name:  String,
    val cnpj: String,
    val partner: PartnerEntity,
    val responsible: ResponsibleEntity,
    val activeRf: Boolean,
    val createAt: LocalDateTime = LocalDateTime.now(),
)

data class PartnerEntity (
    val name: String,
    val cpf: String,
    val phone: String
)

data class ResponsibleEntity (
    val name: String,
    val phone: String,
    val email: String? = null,
    val occupation: String
)
