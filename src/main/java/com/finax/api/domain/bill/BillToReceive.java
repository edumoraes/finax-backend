package com.finax.api.domain.bill;

import com.finax.api.domain.organization.AccountOrganization;
import com.finax.api.domain.organization.CustomerOrganization;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "bills_to_receive")
@Table(name = "bills_to_receive")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class BillToReceive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "interest")
    private BigDecimal interest;

    @Column(name = "fine")
    private BigDecimal fine;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "amount_received")
    private BigDecimal amountReceived;

    @Column(name = "document_number")
    private String documentNumber;

    @ManyToOne
    @JoinColumn(name = "account_organization_id")
    private AccountOrganization accountOrganization;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerOrganization customer;

    public void receive(BillReceivedDTO data) {
        if (data.interest() != null) {
            this.interest = data.interest();
        }

        if (data.fine() != null) {
            this.fine = data.fine();
        }

        if (data.transactionDate() != null) {
            this.transactionDate = data.transactionDate();
        }

        if (data.amountReceived() != null) {
            this.amountReceived = data.amountReceived();
        }
    }
}
