package com.barberiasyassin.api.appointments.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "appointment_status_history")
@Getter
@Setter
public class AppointmentStatusHistory {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "appointment_id", nullable = false, updatable = false)
    private Appointment appointment;

    @Column(name = "status", nullable = false, updatable = false)
    private String status;

    @Column(name = "actor_type", nullable = false, updatable = false)
    private String actorType;

    @Column(name = "actor_id", updatable = false)
    private UUID actorId;

    @Column(name = "changed_at", nullable = false, updatable = false)
    private Instant changedAt = Instant.now();

    @Column(name = "reason", updatable = false)
    private String reason;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentStatusHistory that = (AppointmentStatusHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
