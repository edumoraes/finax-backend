package com.finax.api.domain.user;

import com.finax.api.domain.organization.AccountOrganization;

import java.util.Set;

public record UserDetailDTO(
        String id,
        String firstName,
        String lastName,
        String email
) {

    public UserDetailDTO(User user) {
        this(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
