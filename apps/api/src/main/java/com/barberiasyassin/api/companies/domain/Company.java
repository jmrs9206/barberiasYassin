package com.barberiasyassin.api.companies.domain;

import com.barberiasyassin.api.shared.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "slug", nullable = false, unique = true)
    private String slug;

    @Column(name = "status", nullable = false)
    private String status = "ACTIVE";

    @Column(name = "default_locale", nullable = false, length = 10)
    private String defaultLocale = "es-ES";

    @Column(name = "default_currency", nullable = false, length = 10)
    private String defaultCurrency = "EUR";

    @Column(name = "default_timezone", nullable = false, length = 100)
    private String defaultTimezone = "Europe/Madrid";

    @Column(name = "plan_code", nullable = false)
    private String planCode = "BASIC";

    @Column(name = "deleted_at")
    private Instant deletedAt;
}
