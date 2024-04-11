package br.com.b2b.companymanager.models

import jakarta.persistence.Id
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Column
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import java.time.LocalDateTime
import java.util.UUID


@Entity
@Table(name = "companies")
data class CompanyModel(
    @Id
    val id: String = UUID.randomUUID().toString(),
    @Column(nullable = false, length = 100)
    val name:  String,
    @Column(nullable = false, length = 14, unique = true)
    val cnpj: String,
    @OneToMany(mappedBy = "company")
    var partner: List<PartnerModel> = ArrayList(),
    @OneToOne(mappedBy = "company")
    var responsible: ResponsibleModel,
    @Column(nullable = false)
    val activeReceita: Boolean,
    val createAt: LocalDateTime = LocalDateTime.now(),
)
