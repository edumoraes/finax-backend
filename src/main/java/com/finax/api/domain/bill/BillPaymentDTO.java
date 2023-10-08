package com.finax.api.domain.bill;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public record BillPaymentDTO(
        @NotNull
        Long id,
        BigDecimal interest,
        BigDecimal fine,
        @NotNull
        Date transactionDate,
        @NotNull
        BigDecimal amountPaid
) {
}
