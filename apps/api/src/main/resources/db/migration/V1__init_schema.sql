-- V1: Initial database schema for multi-tenant barber platform

-- Companies table
CREATE TABLE companies (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL UNIQUE,
    status VARCHAR(50) NOT NULL,
    default_locale VARCHAR(10) NOT NULL,
    default_currency VARCHAR(10) NOT NULL,
    default_timezone VARCHAR(100) NOT NULL,
    plan_code VARCHAR(50) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    deleted_at TIMESTAMP WITH TIME ZONE,
    version BIGINT NOT NULL DEFAULT 0
);

-- Users table
CREATE TABLE users (
    id UUID PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255),
    display_name VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    mfa_enabled BOOLEAN NOT NULL DEFAULT FALSE,
    account_expires_at TIMESTAMP WITH TIME ZONE,
    last_login_at TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    deleted_at TIMESTAMP WITH TIME ZONE,
    version BIGINT NOT NULL DEFAULT 0
);

-- Company Memberships table
CREATE TABLE company_memberships (
    id UUID PRIMARY KEY,
    company_id UUID NOT NULL REFERENCES companies(id) ON DELETE CASCADE,
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    role VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    version BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT uq_company_user UNIQUE(company_id, user_id)
);

-- Branches table
CREATE TABLE branches (
    id UUID PRIMARY KEY,
    company_id UUID NOT NULL REFERENCES companies(id) ON DELETE CASCADE,
    name VARCHAR(255) NOT NULL,
    address_line1 VARCHAR(255) NOT NULL,
    address_line2 VARCHAR(255),
    city VARCHAR(255) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    country VARCHAR(100) NOT NULL,
    timezone VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    booking_settings JSONB,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    deleted_at TIMESTAMP WITH TIME ZONE,
    version BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT uq_company_branch_name UNIQUE(company_id, name)
);

-- Audit Events table (immutable log)
CREATE TABLE audit_events (
    id UUID PRIMARY KEY,
    timestamp TIMESTAMP WITH TIME ZONE NOT NULL,
    actor_type VARCHAR(50) NOT NULL,
    actor_id UUID,
    company_id UUID,
    branch_id UUID,
    action VARCHAR(255) NOT NULL,
    resource_type VARCHAR(100) NOT NULL,
    resource_id UUID,
    result VARCHAR(50) NOT NULL,
    reason VARCHAR(255),
    trace_id VARCHAR(100),
    diff JSONB,
    source_ip VARCHAR(45),
    metadata JSONB
);

-- Partial indexes for active entities (soft delete aware)
CREATE INDEX idx_companies_active ON companies(id) WHERE deleted_at IS NULL;
CREATE INDEX idx_users_active ON users(id) WHERE deleted_at IS NULL;
CREATE INDEX idx_branches_active ON branches(company_id, id) WHERE deleted_at IS NULL;

-- General operational indexes
CREATE INDEX idx_audit_company_action ON audit_events(company_id, action, timestamp DESC);
CREATE INDEX idx_memberships_user ON company_memberships(user_id);
