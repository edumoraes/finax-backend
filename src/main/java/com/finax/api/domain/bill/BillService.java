package com.finax.api.domain.bill;

import com.finax.api.domain.organization.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private BillToPayRepository billToPayRepository;

    @Autowired
    private BillToReceiveRepository billToReceiveRepository;

    @Autowired
    private AccountOrganizationService accountOrganizationService;

    @Autowired
    private SupplierOrganizationService supplierOrganizationService;

    @Autowired
    private CustomerOrganizationService customerOrganizationService;

    public BillToPay registerBillToPay(BillToPayRegistrationDTO data) {
        AccountOrganization accountOrganization = accountOrganizationService.detail(data.accountOrganizationId());
        SupplierOrganization supplier = supplierOrganizationService.detail(data.supplierId());
        BillToPay billToPay = new BillToPay();

        billToPay.setDueDate(data.dueDate());
        billToPay.setTitle(data.title());
        billToPay.setDescription(data.description());
        billToPay.setAmount(data.amount());
        billToPay.setDocumentNumber(data.documentNumber());
        billToPay.setAccountOrganization(accountOrganization);
        billToPay.setSupplier(supplier);

        return billToPayRepository.save(billToPay);
    }

    public BillToReceive registerBillToReceive(BillToReceiveRegistrationDTO data) {
        AccountOrganization accountOrganization = accountOrganizationService.detail(data.accountOrganizationId());
        CustomerOrganization customer = customerOrganizationService.detail(data.customerId());

        BillToReceive billToReceive = new BillToReceive();

        billToReceive.setDueDate(data.dueDate());
        billToReceive.setTitle(data.title());
        billToReceive.setDescription(data.description());
        billToReceive.setAmount(data.amount());
        billToReceive.setDocumentNumber(data.documentNumber());
        billToReceive.setAccountOrganization(accountOrganization);
        billToReceive.setCustomer(customer);

        return billToReceiveRepository.save(billToReceive);
    }

    public BillToPay detailBillToPay(Long id) {
        return billToPayRepository.getReferenceById(id);
    }

    public BillToReceive detailBillToReceive(Long id) {
        return billToReceiveRepository.getReferenceById(id);
    }
}
