package com.barberiasyassin.api.shared.tenant;

import com.barberiasyassin.api.shared.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@MappedSuperclass
@EntityListeners(TenantEntityListener.class)
@Getter
@Setter
public abstract class TenantAwareBaseEntity extends BaseEntity implements TenantAware {

    @Column(name = "company_id", nullable = false, updatable = false)
    private UUID companyId;
}
