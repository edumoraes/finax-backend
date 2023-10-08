package com.finax.api.domain.bill;

import java.math.BigDecimal;
import java.util.Date;

public record BillToReceiveDetailDTO(
        Long id,
        Date dueDate,
        String title,
        String description,
        BigDecimal amount,
        String documentNumber
) {
    public BillToReceiveDetailDTO(BillToReceive data) {
        this(data.getId(), data.getDueDate(), data.getTitle(), data.getDescription(), data.getAmount(), data.getDocumentNumber());
    }
}
