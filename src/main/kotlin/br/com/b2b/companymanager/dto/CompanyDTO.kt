package br.com.b2b.companymanager.dto

import java.time.LocalDateTime


data class CompanyDTO(
    val name:  String,
    val cnpj: String,
    val partner: PartnerDTO,
    val responsible: ResponsibleDTO,
    val activeRf: Boolean,
    val createAt: LocalDateTime = LocalDateTime.now(),
)