package com.finax.api.domain.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierOrganizationService {

    @Autowired
    private SupplierOrganizationRepository repository;

    @Autowired
    private AccountOrganizationService accountOrganizationService;

    public SupplierOrganization registerSupplierOrganization(SupplierOrganizationRegistrationDTO data) {
        AccountOrganization accountOrganization = accountOrganizationService.detail(data.accountOrganizationId());
        SupplierOrganization supplierOrganization = new SupplierOrganization();

        supplierOrganization.setName(data.name());
        supplierOrganization.setType(data.type());
        supplierOrganization.setAccountOrganization(accountOrganization);

        return repository.save(supplierOrganization);
    }
    public SupplierOrganization detail(Long id) {
        return repository.getReferenceById(id);
    }
}
