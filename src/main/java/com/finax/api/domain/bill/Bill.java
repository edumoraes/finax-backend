package com.finax.api.domain.bill;

import com.finax.api.domain.organization.AccountOrganization;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@MappedSuperclass
public abstract class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dueDate;
    private Date transactionDate;
    private BigDecimal amount;
    private BigDecimal interest;
    private BigDecimal fine;
    @ManyToOne
    private AccountOrganization userOrganization;
    private String description;
    private String documentNumber;
}
