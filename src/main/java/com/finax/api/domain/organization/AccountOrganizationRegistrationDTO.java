package com.finax.api.domain.organization;

import com.finax.api.domain.postaladdress.PostalAddress;
import com.finax.api.domain.postaladdress.PostalAddressDTO;
import com.finax.api.domain.user.User;
import com.finax.api.domain.user.UserDetailDTO;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

public record AccountOrganizationRegistrationDTO(
        @NotBlank
        String name,
        @Validated
        PostalAddressDTO address,
        OrganizationType type,
        String cnpj,
        @NotBlank
        String userId
) {
}
