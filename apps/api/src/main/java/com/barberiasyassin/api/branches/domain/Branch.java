package com.barberiasyassin.api.branches.domain;

import com.barberiasyassin.api.shared.tenant.TenantAwareBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "branches")
@Getter
@Setter
public class Branch extends TenantAwareBaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address_line1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "postal_code", nullable = false, length = 20)
    private String postalCode;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @Column(name = "timezone", nullable = false, length = 100)
    private String timezone = "Europe/Madrid";

    @Column(name = "status", nullable = false)
    private String status = "ACTIVE";

    @org.hibernate.annotations.JdbcTypeCode(org.hibernate.type.SqlTypes.JSON)
    @Column(name = "booking_settings")
    private String bookingSettings;

    @Column(name = "deleted_at")
    private Instant deletedAt;
}
