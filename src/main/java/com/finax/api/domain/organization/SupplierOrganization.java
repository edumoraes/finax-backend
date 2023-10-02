package com.finax.api.domain.organization;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "suppliers")
@Table(name = "suppliers")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class SupplierOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
