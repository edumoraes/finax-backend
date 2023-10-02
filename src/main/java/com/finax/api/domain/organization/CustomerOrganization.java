package com.finax.api.domain.organization;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "customers")
@Table(name = "customers")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CustomerOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
