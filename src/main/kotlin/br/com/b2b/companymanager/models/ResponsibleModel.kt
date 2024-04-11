package br.com.b2b.companymanager.models

import jakarta.persistence.Id
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Column
import jakarta.persistence.OneToOne
import java.util.UUID


@Entity
@Table(name = "responsible")
data class ResponsibleModel (
    @Id
    val id: String = UUID.randomUUID().toString(),
    @Column(nullable = false, length = 100)
    val name: String,
    @Column(nullable = false, length = 11)
    val phone: String,
    @Column(nullable = true)
    val email: String? = null,
    @Column(nullable = false, length = 50)
    val occupation: String,
    @OneToOne
    var company: CompanyModel? = null
)