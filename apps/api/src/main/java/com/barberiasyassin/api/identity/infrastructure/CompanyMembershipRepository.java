package com.barberiasyassin.api.identity.infrastructure;

import com.barberiasyassin.api.identity.domain.CompanyMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyMembershipRepository extends JpaRepository<CompanyMembership, UUID> {
    List<CompanyMembership> findByCompanyId(UUID companyId);
    List<CompanyMembership> findByUserId(UUID userId);
    Optional<CompanyMembership> findByCompanyIdAndUserId(UUID companyId, UUID userId);
}
