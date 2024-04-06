package br.com.b2b.companymanager.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size


data class CompanyIn(
    @field:NotEmpty @field:NotNull val name:  String,
    @field:NotEmpty @field:Size(min = 14, max = 14) val cnpj: String,
    val partner: PartnerIn,
    val responsible: ResponsibleIn,
    @field:NotNull val activeRf: Boolean,
)

data class PartnerIn (
    @field:NotEmpty @field:NotNull val name: String,
    @field:NotEmpty @field:Size(min = 11, max = 11) val cpf: String,
    @field:NotEmpty @field:Size(min = 10, max = 11) val phone: Number
)

data class ResponsibleIn (
    @field:NotEmpty @NotNull val name: String,
    @field:NotEmpty @field:Size(min = 10, max = 11) val phone: Number,
    @field:Email val email: String? = null,
    @field:NotEmpty @field:NotNull val occupation: String
)
