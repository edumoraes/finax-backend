package com.finax.api.infra.security;

import com.finax.api.domain.user.User;
import com.finax.api.domain.user.UserDetailDTO;

public record TokenJwtDTO(
        UserDetailDTO user,
        String token
) {
    public TokenJwtDTO(User user, String token) {
        this(new UserDetailDTO(user), token);
    }
}
