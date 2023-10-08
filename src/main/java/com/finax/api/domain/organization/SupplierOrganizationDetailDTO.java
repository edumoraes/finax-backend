package com.finax.api.domain.organization;

public record SupplierOrganizationDetailDTO(
        Long id,
        String name,
        OrganizationType type
) {
    public SupplierOrganizationDetailDTO(SupplierOrganization data) {
        this(data.getId(), data.getName(), data.getType());
    }
}
