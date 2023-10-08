package com.finax.api.domain.organization;

import com.finax.api.domain.bill.BillToReceive;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "customers")
@Table(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CustomerOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private OrganizationType type;

    @OneToMany(mappedBy = "customer")
    private Set<BillToReceive> billToReceive;

    @ManyToOne
    @JoinColumn(name = "account_organization_id")
    private AccountOrganization accountOrganization;
}
