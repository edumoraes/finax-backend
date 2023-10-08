package com.finax.api.domain.bill;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record BillToReceiveRegistrationDTO(
        @NotNull
        Date dueDate,
        @NotBlank
        String title,
        String description,
        @NotNull
        BigDecimal amount,
        String documentNumber,
        @NotNull
        Long accountOrganizationId,
        @NotNull
        Long customerId
) {
}
