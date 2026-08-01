package com.barberiasyassin.api.scheduling.infrastructure;

import com.barberiasyassin.api.scheduling.domain.ScheduleException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ScheduleExceptionRepository extends JpaRepository<ScheduleException, UUID> {
    List<ScheduleException> findByCompanyId(UUID companyId);
    List<ScheduleException> findByCompanyIdAndBranchIdAndEmployeeIdAndDate(UUID companyId, UUID branchId, UUID employeeId, LocalDate date);
}
