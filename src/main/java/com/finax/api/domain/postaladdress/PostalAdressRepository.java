package com.finax.api.domain.postaladdress;

import com.finax.api.domain.postaladdress.PostalAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostalAdressRepository extends JpaRepository<PostalAddress, Long> {
}
