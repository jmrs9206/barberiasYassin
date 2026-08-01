package com.barberiasyassin.api.employees.domain;

import com.barberiasyassin.api.branches.domain.Branch;
import com.barberiasyassin.api.shared.tenant.TenantAwareBaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee extends TenantAwareBaseEntity {

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status", nullable = false)
    private String status = "ACTIVE";

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "employee_branches",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "branch_id")
    )
    private Set<Branch> branches = new HashSet<>();

    @Column(name = "deleted_at")
    private Instant deletedAt;
}
