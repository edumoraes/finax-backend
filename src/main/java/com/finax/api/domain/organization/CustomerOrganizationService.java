package com.finax.api.domain.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrganizationService {

    @Autowired
    private CustomerOrganizationRepository repository;

    @Autowired
    private AccountOrganizationService accountOrganizationService;

    public CustomerOrganization registerCustomerOrganization(CustomerOrganizationRegistrationDTO data) {
        AccountOrganization accountOrganization = accountOrganizationService.detail(data.accountOrganizationId());
        CustomerOrganization customerOrganization = new CustomerOrganization();

        customerOrganization.setName(data.name());
        customerOrganization.setType(data.type());
        customerOrganization.setAccountOrganization(accountOrganization);

        return repository.save(customerOrganization);
    }

    public CustomerOrganization detail(Long id) {
        return repository.getReferenceById(id);
    }
}
