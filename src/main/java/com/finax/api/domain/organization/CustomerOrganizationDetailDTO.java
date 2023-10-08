package com.finax.api.domain.organization;

public record CustomerOrganizationDetailDTO(
        Long id,
        String name,
        OrganizationType type
) {
    public CustomerOrganizationDetailDTO(CustomerOrganization data) {
        this(data.getId(), data.getName(), data.getType());
    }
}
