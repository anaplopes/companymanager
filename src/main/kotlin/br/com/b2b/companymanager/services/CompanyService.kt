package br.com.b2b.companymanager.services

import br.com.b2b.companymanager.dto.CompanyIn
import br.com.b2b.companymanager.dto.CompanyOut
import br.com.b2b.companymanager.exception.BadRequestException
import br.com.b2b.companymanager.exception.NotFoundException
import br.com.b2b.companymanager.factories.CompanyDTOMapper
import br.com.b2b.companymanager.factories.CompanyModelMapper
import br.com.b2b.companymanager.interfaces.ICompanyRepository
import br.com.b2b.companymanager.interfaces.IPartnerRepository
import br.com.b2b.companymanager.interfaces.IResponsibleRepository
import org.springframework.stereotype.Service


@Service
class CompanyService(
    private val companyRepository: ICompanyRepository,
    private val partnerRepository: IPartnerRepository,
    private val responsibleRepository: IResponsibleRepository,
    private val companyModelMapper: CompanyModelMapper,
    private val companyDTOMapper: CompanyDTOMapper,
) {

    fun createCompany(company: CompanyIn): CompanyOut {
        if (companyRepository.findByCnpj(company.cnpj) != null) {
            throw BadRequestException("Company already registered")
        }

        val model = companyModelMapper.map(company)
        companyRepository.save(model)
        partnerRepository.saveAll(model.partner)
        responsibleRepository.save(model.responsible)
        return companyDTOMapper.map(model)
    }

    fun readCompany(cnpj: String): CompanyOut {
        val getCompany = companyRepository.findByCnpj(cnpj)
            ?: throw NotFoundException("Company not found")
        return companyDTOMapper.map(getCompany)
    }

    fun listCompany(): List<CompanyOut> {
        return companyRepository.findAll().mapNotNull { company ->
            companyDTOMapper.map(company)
        }
    }
}