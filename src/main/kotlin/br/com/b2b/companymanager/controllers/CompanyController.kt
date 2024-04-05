package br.com.b2b.companymanager.controllers

import br.com.b2b.companymanager.dto.CompanyDTO
import br.com.b2b.companymanager.services.CompanyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/company")
class CompanyController(
    private var service: CompanyService
) {

    @PostMapping
    fun create(@RequestBody company: CompanyDTO): String {
        return service.createCompany(company)
    }

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): CompanyDTO {
        return service.readCompany(id)
    }

    @GetMapping
    fun list(): List<CompanyDTO> {
        return service.listCompany()
    }
}