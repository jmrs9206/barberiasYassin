package com.barberiasyassin.api.catalog.domain;

import com.barberiasyassin.api.shared.tenant.TenantAwareBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "services")
@Getter
@Setter
public class Service extends TenantAwareBaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    @Column(name = "price_minor", nullable = false)
    private Long priceMinor; // in cents

    @Column(name = "status", nullable = false)
    private String status = "ACTIVE";

    @Column(name = "deleted_at")
    private Instant deletedAt;
}
