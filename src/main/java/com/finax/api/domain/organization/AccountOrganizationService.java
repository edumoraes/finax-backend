package com.finax.api.domain.organization;

import com.finax.api.domain.postaladdress.PostalAddress;
import com.finax.api.domain.postaladdress.PostalAddressService;
import com.finax.api.domain.user.User;
import com.finax.api.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountOrganizationService {

    @Autowired
    private AccountOrganizationRepository repository;

    @Autowired
    private UserService userService;

    @Autowired
    private PostalAddressService postalAddressService;

    public AccountOrganization registerAccountOrganization(AccountOrganizationRegistrationDTO data) {
        User user = userService.detail(data.userId());
        PostalAddress address = postalAddressService.create(data.address());
        AccountOrganization accountOrganization = new AccountOrganization();

        accountOrganization.setName(data.name());
        accountOrganization.setAddress(address);
        accountOrganization.setType(data.type());
        accountOrganization.setCnpj(data.cnpj());

        user.setAccountOrganization(accountOrganization);

        return repository.save(accountOrganization);
    }

    public AccountOrganization detail(Long id) {
        return repository.getReferenceById(id);
    }
}