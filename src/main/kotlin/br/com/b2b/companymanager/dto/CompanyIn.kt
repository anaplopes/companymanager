package br.com.b2b.companymanager.dto

import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size


/**
 * Data Transfer Object for creating a new company.
 */
data class CompanyIn(
    @field:NotEmpty(message = "Company name is required.")
    @field:NotNull(message = "Company name cannot be null.")
    val name:  String,
    @field:NotEmpty(message = "CNPJ is required.")
    @field:Size(min = 14, max = 14, message = "CNPJ must have 14 digits without dots, slashes and dashes.")
    val cnpj: String,
    @field:Valid
    val partner: List<PartnerIn>,
    @field:Valid @field:NotNull(message = "Responsible information is required.")
    val responsible: ResponsibleIn,
    @field:NotNull(message = "Active Receita status is required.")
    val activeRf: Boolean,
)

/**
 * Data Transfer Object for creating a new partner.
 */
data class PartnerIn (
    @field:NotEmpty(message = "Partner name is required.")
    @field:NotNull(message = "Partner name cannot be null.")
    val name: String,
    @field:NotEmpty(message = "CPF is required.")
    @field:Size(min = 11, max = 11, message = "CPF must have 11 digits without dots and dashes.")
    val cpf: String,
    @field:NotEmpty(message = "Phone number is required.")
    @field:Size(min = 10, max = 11, message = "Phone number must contain the area code.")
    val phone: String
)

/**
 * Data Transfer Object for creating a new responsible.
 */
data class ResponsibleIn (
    @field:NotEmpty(message = "Responsible name is required.")
    @field:NotNull(message = "Responsible name cannot be null.")
    val name: String,
    @field:NotEmpty(message = "Phone number is required.")
    @field:Size(min = 10, max = 11, message = "Phone number must contain the area code.")
    val phone: String,
    @field:Email(message = "Email should be valid.")
    val email: String? = null,
    @field:NotEmpty(message = "Occupation is required.")
    @field:NotNull(message = "Occupation cannot be null.")
    val occupation: String
)
