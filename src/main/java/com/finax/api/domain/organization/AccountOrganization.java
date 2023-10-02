package com.finax.api.domain.organization;

import com.finax.api.domain.postaladdress.PostalAddress;
import com.finax.api.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
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
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private PostalAddress address;

    @Column(unique = true)
    private String document;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false, updatable = false)
    private User owner;

    @ManyToMany(mappedBy = "accountOrganizations")
    private Set<User> users = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private OrganizationType type;

    public AccountOrganization(AccountOrganizationCreationDTO data) {
        this.name = data.name();
        this.document = data.document();
        this.users = data.users();
        this.type = data.type();
    }
}
