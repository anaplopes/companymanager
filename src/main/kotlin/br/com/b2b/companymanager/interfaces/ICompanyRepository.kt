package br.com.b2b.companymanager.interfaces

import br.com.b2b.companymanager.models.CompanyModel
import org.springframework.data.jpa.repository.JpaRepository


interface ICompanyRepository: JpaRepository<CompanyModel, String> {
    fun findByCnpj(cnpj: String): CompanyModel?
}