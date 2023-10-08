package com.finax.api.domain.postaladdress;

import com.finax.api.domain.organization.AccountOrganization;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "postal_addresses")
@Table(name = "postal_addresses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PostalAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    @OneToOne(mappedBy = "address")
    private AccountOrganization accountOrganization;

    public PostalAddress(PostalAddressDTO address) {
        this.street = address.street();
        this.number = address.number();
        this.complement = address.complement();
        this.neighborhood = address.neighborhood();
        this.city = address.city();
        this.state = address.state();
        this.country = address.country();
        this.zipCode = address.zipCode();
    }
}
