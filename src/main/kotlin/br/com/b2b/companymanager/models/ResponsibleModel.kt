package br.com.b2b.companymanager.models

import jakarta.persistence.Id
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Column
import jakarta.persistence.OneToOne
import java.util.UUID
import jakarta.persistence.JoinColumn
import jakarta.persistence.CascadeType


@Entity
@Table(name = "responsible")
data class ResponsibleModel (
    @Id
    val id: String = UUID.randomUUID().toString(),

    @Column(nullable = false, length = 100)
    val name: String,

    @Column(nullable = false, length = 11)
    val phone: String,

    val email: String? = null,

    @Column(nullable = false, length = 50)
    val occupation: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "company_id")
    var company: CompanyModel? = null
)