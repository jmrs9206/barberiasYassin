package com.barberiasyassin.api.branches.infrastructure;

import com.barberiasyassin.api.branches.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BranchRepository extends JpaRepository<Branch, UUID> {
    List<Branch> findByCompanyId(UUID companyId);
    Optional<Branch> findByCompanyIdAndName(UUID companyId, String name);
}
