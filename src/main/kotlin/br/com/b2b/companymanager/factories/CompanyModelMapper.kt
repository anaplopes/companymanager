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
        val responsible = ResponsibleModel(
            name = t.responsible.name,
            phone = t.responsible.phone,
            email = t.responsible.email,
            occupation = t.responsible.occupation,
            company = null
        )
        return CompanyModel(
            name = t.name,
            cnpj = t.cnpj,
            responsible = responsible,
            activeRf = t.activeRf,
        ).apply {
            responsible.company = this
            partner = t.partner.map { p ->
                PartnerModel(
                    name = p.name,
                    cpf = p.cpf,
                    phone = p.phone,
                    company = this
                )
            }.toMutableList()
        }
    }

}
