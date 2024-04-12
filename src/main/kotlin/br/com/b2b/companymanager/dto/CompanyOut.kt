package br.com.b2b.companymanager.dto


data class CompanyOut(
    val id: String? = null,
    val name:  String,
    val cnpj: String,
    val partner: List<PartnerOut>,
    val responsible: ResponsibleOut,
    val activeRf: Boolean,
)

data class PartnerOut (
    val name: String,
    val cpf: String,
    val phone: String
)

data class ResponsibleOut (
    val name: String,
    val phone: String,
    val email: String? = null,
    val occupation: String
)
