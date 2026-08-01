package com.barberiasyassin.api.appointments.infrastructure;

import com.barberiasyassin.api.appointments.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {
    List<Appointment> findByCompanyId(UUID companyId);

    @Query("SELECT a FROM Appointment a WHERE a.companyId = :companyId AND a.employee.id = :employeeId " +
           "AND a.status NOT IN ('CANCELLED_BY_CUSTOMER', 'CANCELLED_BY_BUSINESS') " +
           "AND ((a.startsAt >= :start AND a.startsAt < :end) OR (a.endsAt > :start AND a.endsAt <= :end) " +
           "OR (a.startsAt <= :start AND a.endsAt >= :end))")
    List<Appointment> findOverlappingAppointments(
            @Param("companyId") UUID companyId,
            @Param("employeeId") UUID employeeId,
            @Param("start") Instant start,
            @Param("end") Instant end
    );
}
