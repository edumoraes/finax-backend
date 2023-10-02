package com.finax.api.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegistrationDTO(
        @NotBlank
        String firstName,
        String lastName,
        UserRole role,
        @NotBlank
        @Email
        String email,
        String password

) {
}
