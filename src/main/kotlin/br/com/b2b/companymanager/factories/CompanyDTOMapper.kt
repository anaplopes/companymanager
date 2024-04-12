package br.com.b2b.companymanager.factories

import br.com.b2b.companymanager.dto.CompanyOut
import br.com.b2b.companymanager.dto.PartnerOut
import br.com.b2b.companymanager.dto.ResponsibleOut
import br.com.b2b.companymanager.interfaces.IMapperObject
import br.com.b2b.companymanager.models.CompanyModel
import org.springframework.stereotype.Component


@Component
class CompanyDTOMapper: IMapperObject<CompanyModel, CompanyOut> {
    override fun map(t: CompanyModel): CompanyOut {
        return CompanyOut(
            id = t.id,
            name = t.name,
            cnpj = t.cnpj,
            partner = t.partner.map { p ->
                PartnerOut(
                    name = p.name,
                    cpf = p.cpf,
                    phone = p.phone
                )
            },
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
