package com.finax.api.domain.organization;

import com.finax.api.domain.bill.BillToPay;
import com.finax.api.domain.bill.BillToReceive;
import com.finax.api.domain.postaladdress.PostalAddress;
import com.finax.api.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "account_organizations")
@Table(name = "account_organizations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AccountOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private PostalAddress address;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private OrganizationType type;

    @Column(name = "cnpj", unique = true)
    private String cnpj;

    @ManyToMany(mappedBy = "accountOrganization")
    private Set<User> user;

    @OneToMany(mappedBy = "accountOrganization")
    private Set<BillToPay> billToPay;

    @OneToMany(mappedBy = "accountOrganization")
    private Set<BillToReceive> billToReceive;

    @OneToMany(mappedBy = "accountOrganization")
    private Set<SupplierOrganization> suppliers;

    @OneToMany(mappedBy = "accountOrganization")
    private Set<CustomerOrganization> customers;

    public AccountOrganization(AccountOrganizationRegistrationDTO data) {
        this.name = data.name();
        this.cnpj = data.cnpj();
        this.type = data.type();
    }
}
