package com.barberiasyassin.api.customers.infrastructure;

import com.barberiasyassin.api.customers.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByCompanyIdAndEmail(UUID companyId, String email);
}
