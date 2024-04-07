package br.com.b2b.companymanager.dto

import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size


data class CompanyIn(
    @field:NotEmpty(message = "Company name cannot be empty")
    @field:NotNull
    val name:  String,
    @field:NotEmpty(message = "CNPJ cannot be empty")
    @field:Size(min = 14, max = 14, message = "CPNJ must have 14 digits without dots, slashes and dashes")
    val cnpj: String,
    @field:Valid
    val partner: PartnerIn,
    @field:Valid
    val responsible: ResponsibleIn,
    @field:NotNull
    val activeRf: Boolean,
)

data class PartnerIn (
    @field:NotEmpty(message = "Partner name cannot be empty")
    @field:NotNull
    val name: String,
    @field:NotEmpty(message = "CPF cannot be empty")
    @field:Size(min = 11, max = 11, message = "CPF must have 11 digits without dots and dashes")
    val cpf: String,
    @field:NotEmpty(message = "Phone cannot be empty")
    @field:Size(min = 10, max = 11, message = "Phone must contain the area code")
    val phone: String
)

data class ResponsibleIn (
    @field:NotEmpty(message = "Responsible name cannot be empty")
    @field:NotNull
    val name: String,
    @field:NotEmpty
    @field:Size(min = 10, max = 11, message = "Phone must contain the area code")
    val phone: String,
    @field:Email
    val email: String? = null,
    @field:NotEmpty(message = "Occupation cannot be empty")
    @field:NotNull
    val occupation: String
)
