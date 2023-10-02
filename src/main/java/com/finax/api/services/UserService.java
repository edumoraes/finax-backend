package com.finax.api.services;

import com.finax.api.domain.user.User;
import com.finax.api.domain.user.UserRegistrationDTO;
import com.finax.api.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User create(UserRegistrationDTO user) {
        return repository.save(new User(user));
    }

    public User detail(String id) {
        return repository.getReferenceById(id);
    }

}
