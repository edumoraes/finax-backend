package com.finax.api.services;

import com.finax.api.domain.organization.AccountOrganization;
import com.finax.api.domain.organization.AccountOrganizationCreationDTO;
import com.finax.api.domain.organization.AccountOrganizationRepository;
import com.finax.api.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountOrganizationService {

    @Autowired
    AccountOrganizationRepository repository;

    @Autowired
    UserService userService;

    public AccountOrganization create(String ownerId, AccountOrganizationCreationDTO data) {
        User user = userService.detail(ownerId);
        AccountOrganization accountOrganization = new AccountOrganization(data);
        accountOrganization.setOwner(user);
        repository.save(accountOrganization);
        return accountOrganization;
    }
}