package br.com.b2b.companymanager.models

import jakarta.persistence.Id
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.Column
import jakarta.persistence.ManyToOne
import java.util.UUID
import jakarta.persistence.JoinColumn


@Entity
@Table(name = "partners")
data class PartnerModel (
    @Id
    val id: String = UUID.randomUUID().toString(),
    @Column(nullable = false, length = 100)
    val name: String,
    @Column(nullable = false, length = 11)
    val cpf: String,
    @Column(nullable = false, length = 11)
    val phone: String,
    @ManyToOne
    var company: CompanyModel? = null
)