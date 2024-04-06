package br.com.b2b.companymanager.dto


data class CompanyOut(
    val id: String,
    val name:  String,
    val cnpj: String,
    val partner: PartnerOut,
    val responsible: ResponsibleOut,
    val activeRf: Boolean,
)

data class PartnerOut (
    val name: String,
    val cpf: String,
    val phone: Number
)

data class ResponsibleOut (
    val name: String,
    val phone: Number,
    val email: String? = null,
    val occupation: String
)
