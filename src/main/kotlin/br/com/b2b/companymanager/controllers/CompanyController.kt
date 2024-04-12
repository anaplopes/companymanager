package br.com.b2b.companymanager.controllers

import br.com.b2b.companymanager.dto.CompanyIn
import br.com.b2b.companymanager.dto.CompanyOut
import br.com.b2b.companymanager.services.CompanyService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder


@RestController
@RequestMapping("/company")
class CompanyController(
    private var service: CompanyService
) {

    @PostMapping
    @Transactional
    fun create(
        @Valid @RequestBody company: CompanyIn,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<CompanyOut> {
        val result = this.service.createCompany(company)
        val uri = uriBuilder.path("/company/${result.id}").build().toUri()
        return ResponseEntity.created(uri).body(result)
    }

    @GetMapping("/{cnpj}")
    fun read(@PathVariable cnpj: String): CompanyOut {
        return this.service.readCompany(cnpj)
    }

    @GetMapping
    fun list(): List<CompanyOut> {
        return this.service.listCompany()
    }
}