package br.com.b2b.companymanager.factories

import br.com.b2b.companymanager.dto.CompanyIn
import br.com.b2b.companymanager.entities.CompanyEntity
import br.com.b2b.companymanager.entities.PartnerEntity
import br.com.b2b.companymanager.entities.ResponsibleEntity
import br.com.b2b.companymanager.interfaces.MapperObject
import org.springframework.stereotype.Component

@Component
class CompanyEntityMapper: MapperObject<CompanyIn, CompanyEntity> {
    override fun map(t: CompanyIn): CompanyEntity {
        return CompanyEntity(
            name = t.name,
            cnpj = t.cnpj,
            partner = PartnerEntity(
                name = t.partner.name,
                cpf = t.partner.cpf,
                phone = t.partner.phone
            ),
            responsible = ResponsibleEntity(
                name = t.responsible.name,
                phone = t.responsible.phone,
                email = t.responsible.email,
                occupation = t.responsible.occupation
            ),
            activeRf = t.activeRf
        )
    }

}
