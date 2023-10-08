package com.finax.api.domain.organization;

import jakarta.validation.constraints.NotBlank;

public record SupplierOrganizationRegistrationDTO(
        @NotBlank
        String name,
        OrganizationType type,
        Long accountOrganizationId
) {
}
