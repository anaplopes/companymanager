package br.com.b2b.companymanager.factories

import br.com.b2b.companymanager.dto.CompanyOut
import br.com.b2b.companymanager.dto.PartnerOut
import br.com.b2b.companymanager.dto.ResponsibleOut
import br.com.b2b.companymanager.entities.CompanyEntity
import br.com.b2b.companymanager.interfaces.MapperObject
import org.springframework.stereotype.Component

@Component
class CompanyDTOMapper: MapperObject<CompanyEntity, CompanyOut> {
    override fun map(t: CompanyEntity): CompanyOut {
        return CompanyOut(
            id = t.id,
            name = t.name,
            cnpj = t.cnpj,
            partner = PartnerOut(
                name = t.partner.name,
                cpf = t.partner.cpf,
                phone = t.partner.phone
            ),
            responsible = ResponsibleOut(
                name = t.responsible.name,
                phone = t.responsible.phone,
                email = t.responsible.email,
                occupation = t.responsible.occupation
            ),
            activeRf = t.activeRf
        )
    }
}
