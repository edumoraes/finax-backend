package com.finax.api.domain.bill;

import java.math.BigDecimal;
import java.util.Date;

public record BillReceivedDTO(
        Long id,
        BigDecimal interest,
        BigDecimal fine,
        Date transactionDate,
        BigDecimal amountReceived
) {
}
