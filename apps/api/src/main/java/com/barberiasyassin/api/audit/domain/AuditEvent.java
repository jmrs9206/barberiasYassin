package com.barberiasyassin.api.audit.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "audit_events")
@Getter
@Setter
public class AuditEvent {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "timestamp", nullable = false, updatable = false)
    private Instant timestamp = Instant.now();

    @Column(name = "actor_type", nullable = false, updatable = false)
    private String actorType;

    @Column(name = "actor_id", updatable = false)
    private UUID actorId;

    @Column(name = "company_id", updatable = false)
    private UUID companyId;

    @Column(name = "branch_id", updatable = false)
    private UUID branchId;

    @Column(name = "action", nullable = false, updatable = false)
    private String action;

    @Column(name = "resource_type", nullable = false, updatable = false)
    private String resourceType;

    @Column(name = "resource_id", updatable = false)
    private UUID resourceId;

    @Column(name = "result", nullable = false, updatable = false)
    private String result;

    @Column(name = "reason", updatable = false)
    private String reason;

    @Column(name = "trace_id", updatable = false)
    private String traceId;

    @org.hibernate.annotations.JdbcTypeCode(org.hibernate.type.SqlTypes.JSON)
    @Column(name = "diff", updatable = false)
    private String diff;

    @Column(name = "source_ip", length = 45, updatable = false)
    private String sourceIp;

    @org.hibernate.annotations.JdbcTypeCode(org.hibernate.type.SqlTypes.JSON)
    @Column(name = "metadata", updatable = false)
    private String metadata;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditEvent that = (AuditEvent) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
