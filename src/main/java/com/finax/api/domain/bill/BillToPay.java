package com.finax.api.domain.bill;

import com.finax.api.domain.organization.SupplierOrganization;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "bills_to_pay")
@Table(name = "bills_to_pay")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class BillToPay extends Bill {

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierOrganization supplier;

    private BigDecimal amountPaid;
}
