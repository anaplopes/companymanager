package br.com.b2b.companymanager.services

import br.com.b2b.companymanager.dto.CompanyDTO
import org.springframework.stereotype.Service


@Service
class CompanyService(private var companies: List<CompanyDTO> = ArrayList()) {

    fun createCompany(company: CompanyDTO): String {
        companies.plus(company)
        return "Company successfully registered"
    }

    fun readCompany(id: Long): CompanyDTO {
        return companies.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }

    fun listCompany(): List<CompanyDTO> {
        return companies
    }
}