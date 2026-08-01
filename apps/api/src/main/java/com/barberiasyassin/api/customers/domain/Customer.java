package com.barberiasyassin.api.customers.domain;

import com.barberiasyassin.api.shared.tenant.TenantAwareBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer extends TenantAwareBaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "deleted_at")
    private Instant deletedAt;
}
