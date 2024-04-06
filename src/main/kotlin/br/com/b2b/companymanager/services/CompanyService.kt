package br.com.b2b.companymanager.services

import br.com.b2b.companymanager.dto.CompanyIn
import br.com.b2b.companymanager.dto.CompanyOut
import br.com.b2b.companymanager.entities.CompanyEntity
import br.com.b2b.companymanager.factories.CompanyDTOMapper
import br.com.b2b.companymanager.factories.CompanyEntityMapper
import org.springframework.stereotype.Service
import java.util.stream.Collectors


@Service
class CompanyService(
    private var companies: MutableList<CompanyEntity> = ArrayList(),
    private val companyEntityMapper: CompanyEntityMapper,
    private val companyDTOMapper: CompanyDTOMapper
) {

    fun createCompany(company: CompanyIn): CompanyOut {
        val entity = companyEntityMapper.map(company)
        companies.add(entity)
        return companyDTOMapper.map(entity)
    }

    fun readCompany(cnpj: String): CompanyOut {
        val getCompany = companies.stream().filter {
            company -> company.cnpj == cnpj
        }.findFirst().get()
        return companyDTOMapper.map(getCompany)
    }

    fun listCompany(): List<CompanyOut> {
        return companies.stream().map {
            company -> companyDTOMapper.map(company)
        }.collect(Collectors.toList())
    }
}