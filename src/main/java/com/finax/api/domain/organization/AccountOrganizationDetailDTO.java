package com.finax.api.domain.organization;

public record AccountOrganizationDetailDTO(
        Long id,
        String name,
        OrganizationType type,
        String cnpj

) {
    public AccountOrganizationDetailDTO(AccountOrganization data) {
        this(
                data.getId(),
                data.getName(),
                data.getType(),
                data.getCnpj()
        );
    }

}
