package com.barberiasyassin.api.employees.infrastructure;

import com.barberiasyassin.api.employees.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    List<Employee> findByCompanyId(UUID companyId);
}
