package com.finax.api.domain.organization;

import com.finax.api.domain.organization.AccountOrganization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOrganizationRepository extends JpaRepository<AccountOrganization, Long> {
}
