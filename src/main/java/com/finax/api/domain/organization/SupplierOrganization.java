package com.finax.api.domain.organization;

import com.finax.api.domain.bill.BillToPay;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Set;

@Entity(name = "suppliers")
@Table(name = "suppliers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class SupplierOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private OrganizationType type;

    @OneToMany(mappedBy = "supplier")
    private Set<BillToPay> billToPay;

    @ManyToOne
    @JoinColumn(name = "account_organization_id")
    private AccountOrganization accountOrganization;


}
