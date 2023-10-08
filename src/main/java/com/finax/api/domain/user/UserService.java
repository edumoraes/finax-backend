package com.finax.api.domain.user;

import com.finax.api.domain.user.User;
import com.finax.api.domain.user.UserRegistrationDTO;
import com.finax.api.domain.user.UserRepository;
import com.finax.api.infra.security.SecurityConfigurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private SecurityConfigurations securityConfigurations;

    public User registerNewUserAccount(UserRegistrationDTO userDto) {
        User user = new User();
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setEmail(userDto.email());
        user.setPassword(String.valueOf(securityConfigurations.passwordEncoder().encode(userDto.password())));
        return repository.save(user);
    }

    public User detail(String id) {
        return repository.getReferenceById(id);
    }

}
