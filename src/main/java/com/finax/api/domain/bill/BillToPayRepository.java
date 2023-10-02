package com.finax.api.domain.bill;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BillToPayRepository extends JpaRepository<BillToPay, Long> {
}
