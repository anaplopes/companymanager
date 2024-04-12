package br.com.b2b.companymanager.interfaces

import org.springframework.data.jpa.repository.JpaRepository
import br.com.b2b.companymanager.models.ResponsibleModel

interface IResponsibleRepository: JpaRepository<ResponsibleModel, String>{
}