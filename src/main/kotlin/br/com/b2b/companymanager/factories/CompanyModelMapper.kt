package br.com.b2b.companymanager.factories

import br.com.b2b.companymanager.dto.CompanyIn
import br.com.b2b.companymanager.interfaces.IMapperObject
import br.com.b2b.companymanager.models.CompanyModel
import br.com.b2b.companymanager.models.PartnerModel
import br.com.b2b.companymanager.models.ResponsibleModel
import org.springframework.stereotype.Component

@Component
class CompanyModelMapper: IMapperObject<CompanyIn, CompanyModel> {
    override fun map(t: CompanyIn): CompanyModel {
        return CompanyModel(
            name = t.name,
            cnpj = t.cnpj,
            partner = t.partner.map { p ->
                PartnerModel(
                    name = p.name,
                    cpf = p.cpf,
                    phone = p.phone
                )
            }.toMutableList(),
            responsible = ResponsibleModel(
                name = t.responsible.name,
                phone = t.responsible.phone,
                email = t.responsible.email,
                occupation = t.responsible.occupation
            ),
            activeReceita = t.activeReceita
        )
    }

}
