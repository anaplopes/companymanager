package br.com.b2b.companymanager.services

import br.com.b2b.companymanager.dto.CompanyIn
import br.com.b2b.companymanager.dto.CompanyOut
import br.com.b2b.companymanager.exception.NotFoundException
import br.com.b2b.companymanager.factories.CompanyDTOMapper
import br.com.b2b.companymanager.factories.CompanyModelMapper
import br.com.b2b.companymanager.interfaces.ICompanyRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors


@Service
class CompanyService(
    private val repository: ICompanyRepository,
    private val companyModelMapper: CompanyModelMapper,
    private val companyDTOMapper: CompanyDTOMapper,
    private val notFoundMessage: String = "Company not found"
) {

    fun createCompany(company: CompanyIn): CompanyOut {
        val model = companyModelMapper.map(company)
        repository.save(model)
        return companyDTOMapper.map(model)
    }

    fun readCompany(id: String): CompanyOut {
        val getCompany = repository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        return companyDTOMapper.map(getCompany)
    }

    fun listCompany(): List<CompanyOut> {
        return repository.findAll().stream().map {
            company -> companyDTOMapper.map(company)
        }.collect(Collectors.toList())
    }
}