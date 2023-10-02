package com.finax.api.domain.organization;

import com.finax.api.domain.user.User;
import com.finax.api.domain.user.UserDetailDTO;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record AccountOrganizationCreationDTO(
        @NotBlank
        String name,
        String document,
        OrganizationType type,
        UserDetailDTO owner,
        Set<User> users
) {
        public AccountOrganizationCreationDTO(AccountOrganization data) {
                this(data.getName(), data.getDocument(), data.getType(), data.getOwner(), data.getUsers());
        }

        public AccountOrganizationCreationDTO(String name, String document, OrganizationType type, User owner, Set<User> users) {
                this(name, document, type, new UserDetailDTO(owner), users);
        }
}
