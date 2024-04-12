package br.com.b2b.companymanager.models

import jakarta.persistence.Id
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Column
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import java.time.LocalDateTime
import java.util.UUID
import jakarta.persistence.CascadeType
import jakarta.persistence.JoinColumn


@Entity
@Table(name = "companies")
data class CompanyModel(
    @Id
    val id: String = UUID.randomUUID().toString(),

    @Column(nullable = false, length = 100)
    val name:  String,

    @Column(nullable = false, length = 14, unique = true)
    val cnpj: String,

    @OneToMany(mappedBy = "company", cascade = [CascadeType.ALL], orphanRemoval = true)
    var partner: List<PartnerModel> = ArrayList(),

    @OneToOne(mappedBy = "company", cascade = [CascadeType.ALL], orphanRemoval = true)
    val responsible: ResponsibleModel,

    val activeRf: Boolean,

    val createAt: LocalDateTime = LocalDateTime.now(),
)
