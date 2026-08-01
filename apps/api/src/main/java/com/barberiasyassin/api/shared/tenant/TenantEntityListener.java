package com.barberiasyassin.api.shared.tenant;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.PreRemove;
import java.util.UUID;

public class TenantEntityListener {

    @PrePersist
    public void prePersist(Object entity) {
        if (entity instanceof TenantAware tenantAware) {
            UUID tenantId = TenantContext.getCurrentTenant();
            if (tenantId == null) {
                if (tenantAware.getCompanyId() == null) {
                    throw new IllegalStateException("TenantContext is empty. Cannot persist tenant-aware entity without a company_id.");
                }
            } else {
                if (tenantAware.getCompanyId() == null) {
                    tenantAware.setCompanyId(tenantId);
                } else if (!tenantAware.getCompanyId().equals(tenantId)) {
                    throw new IllegalStateException("Attempted to persist tenant-aware entity with company_id " + tenantAware.getCompanyId() + 
                        " but TenantContext holds " + tenantId);
                }
            }
        }
    }

    @PreUpdate
    @PreRemove
    public void preUpdateRemove(Object entity) {
        if (entity instanceof TenantAware tenantAware) {
            UUID tenantId = TenantContext.getCurrentTenant();
            if (tenantId == null) {
                throw new IllegalStateException("TenantContext is empty. Cannot update/delete tenant-aware entity.");
            }
            if (tenantAware.getCompanyId() == null) {
                throw new IllegalStateException("Tenant-aware entity has null company_id during update/delete.");
            }
            if (!tenantAware.getCompanyId().equals(tenantId)) {
                throw new SecurityException("Tenant boundary violation! Attempted operation on tenant " + tenantAware.getCompanyId() + 
                    " but current context is tenant " + tenantId);
            }
        }
    }
}
