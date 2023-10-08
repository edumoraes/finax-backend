package com.finax.api.domain.bill;

import com.finax.api.domain.organization.AccountOrganization;
import com.finax.api.domain.organization.SupplierOrganization;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record BillToPayDatailDTO(
        Long id,
        Date dueDate,
        String title,
        String description,
        BigDecimal amount,
        String documentNumber
) {
    public BillToPayDatailDTO(BillToPay data) {
        this(data.getId(), data.getDueDate(), data.getTitle(), data.getDescription(), data.getAmount(), data.getDocumentNumber());
    }
}
