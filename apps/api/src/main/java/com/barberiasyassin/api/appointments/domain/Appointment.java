package com.barberiasyassin.api.appointments.domain;

import com.barberiasyassin.api.branches.domain.Branch;
import com.barberiasyassin.api.customers.domain.Customer;
import com.barberiasyassin.api.employees.domain.Employee;
import com.barberiasyassin.api.shared.tenant.TenantAwareBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment extends TenantAwareBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "starts_at", nullable = false)
    private Instant startsAt;

    @Column(name = "ends_at", nullable = false)
    private Instant endsAt;

    @Column(name = "service_id")
    private UUID serviceId;

    @Column(name = "service_name_snapshot", nullable = false)
    private String serviceNameSnapshot;

    @Column(name = "service_duration_minutes_snapshot", nullable = false)
    private Integer serviceDurationMinutesSnapshot;

    @Column(name = "service_price_minor_snapshot", nullable = false)
    private Long servicePriceMinorSnapshot;

    @Column(name = "currency_snapshot", nullable = false, length = 10)
    private String currencySnapshot = "EUR";

    @Column(name = "estimated_total_minor", nullable = false)
    private Long estimatedTotalMinor;

    @Column(name = "actual_total_minor")
    private Long actualTotalMinor;

    @Column(name = "payment_method", length = 50)
    private String paymentMethod;

    @Column(name = "source", nullable = false, length = 50)
    private String source;

    @Column(name = "customer_notes", columnDefinition = "text")
    private String customerNotes;

    @Column(name = "internal_notes", columnDefinition = "text")
    private String internalNotes;

    @Column(name = "cancellation_reason")
    private String cancellationReason;

    @Column(name = "created_by_type", nullable = false, length = 50)
    private String createdByType;

    @Column(name = "created_by_id")
    private UUID createdById;

    @Column(name = "deleted_at")
    private Instant deletedAt;
}
