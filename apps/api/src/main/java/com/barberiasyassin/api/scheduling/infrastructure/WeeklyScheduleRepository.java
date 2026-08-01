package com.barberiasyassin.api.scheduling.infrastructure;

import com.barberiasyassin.api.scheduling.domain.WeeklySchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WeeklyScheduleRepository extends JpaRepository<WeeklySchedule, UUID> {
    List<WeeklySchedule> findByCompanyId(UUID companyId);
    List<WeeklySchedule> findByCompanyIdAndBranchIdAndEmployeeId(UUID companyId, UUID branchId, UUID employeeId);
}
