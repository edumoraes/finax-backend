package com.finax.api.domain.bill;

import com.finax.api.domain.organization.CustomerOrganization;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "bills_to_receive")
@Table(name = "bills_to_receive")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class BillToReceive extends Bill {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerOrganization customer;

    private BigDecimal amountReceived;
}
