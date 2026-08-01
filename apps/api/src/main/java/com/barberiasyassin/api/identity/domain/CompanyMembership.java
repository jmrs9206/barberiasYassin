package com.barberiasyassin.api.identity.domain;

import com.barberiasyassin.api.shared.tenant.TenantAwareBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "company_memberships")
@Getter
@Setter
public class CompanyMembership extends TenantAwareBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "status", nullable = false)
    private String status = "ACTIVE";
}
