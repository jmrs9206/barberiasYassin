-- V2: Catalog, employees, weekly schedules and booking tables

-- Employees table
CREATE TABLE employees (
    id UUID PRIMARY KEY,
    company_id UUID NOT NULL REFERENCES companies(id) ON DELETE CASCADE,
    user_id UUID REFERENCES users(id) ON DELETE SET NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(50),
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    deleted_at TIMESTAMP WITH TIME ZONE,
    version BIGINT NOT NULL DEFAULT 0
);

-- Employee Branches relationship
CREATE TABLE employee_branches (
    employee_id UUID NOT NULL REFERENCES employees(id) ON DELETE CASCADE,
    branch_id UUID NOT NULL REFERENCES branches(id) ON DELETE CASCADE,
    PRIMARY KEY (employee_id, branch_id)
);

-- Services table (catalog)
CREATE TABLE services (
    id UUID PRIMARY KEY,
    company_id UUID NOT NULL REFERENCES companies(id) ON DELETE CASCADE,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    duration_minutes INTEGER NOT NULL,
    price_minor BIGINT NOT NULL, -- price in cents
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    deleted_at TIMESTAMP WITH TIME ZONE,
    version BIGINT NOT NULL DEFAULT 0
);

-- Weekly Schedules table
CREATE TABLE weekly_schedules (
    id UUID PRIMARY KEY,
    company_id UUID NOT NULL REFERENCES companies(id) ON DELETE CASCADE,
    branch_id UUID NOT NULL REFERENCES branches(id) ON DELETE CASCADE,
    employee_id UUID NOT NULL REFERENCES employees(id) ON DELETE CASCADE,
    day_of_week INTEGER NOT NULL CHECK (day_of_week BETWEEN 1 AND 7), -- 1 = Monday, 7 = Sunday
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT chk_times CHECK (start_time < end_time)
);

-- Schedule Exceptions table (holidays, special hours)
CREATE TABLE schedule_exceptions (
    id UUID PRIMARY KEY,
    company_id UUID NOT NULL REFERENCES companies(id) ON DELETE CASCADE,
    branch_id UUID NOT NULL REFERENCES branches(id) ON DELETE CASCADE,
    employee_id UUID NOT NULL REFERENCES employees(id) ON DELETE CASCADE,
    date DATE NOT NULL,
    start_time TIME,
    end_time TIME,
    is_working BOOLEAN NOT NULL DEFAULT FALSE,
    reason VARCHAR(255),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT chk_exception_times CHECK (start_time IS NULL OR end_time IS NULL OR start_time < end_time)
);

-- Customers table
CREATE TABLE customers (
    id UUID PRIMARY KEY,
    company_id UUID NOT NULL REFERENCES companies(id) ON DELETE CASCADE,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(50),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    deleted_at TIMESTAMP WITH TIME ZONE,
    version BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT uq_company_customer_email UNIQUE (company_id, email)
);

-- Appointments (bookings) table
CREATE TABLE appointments (
    id UUID PRIMARY KEY,
    company_id UUID NOT NULL REFERENCES companies(id) ON DELETE CASCADE,
    branch_id UUID NOT NULL REFERENCES branches(id) ON DELETE CASCADE,
    customer_id UUID NOT NULL REFERENCES customers(id) ON DELETE RESTRICT,
    employee_id UUID NOT NULL REFERENCES employees(id) ON DELETE RESTRICT,
    status VARCHAR(50) NOT NULL,
    starts_at TIMESTAMP WITH TIME ZONE NOT NULL,
    ends_at TIMESTAMP WITH TIME ZONE NOT NULL,
    service_id UUID REFERENCES services(id) ON DELETE SET NULL,
    service_name_snapshot VARCHAR(255) NOT NULL,
    service_duration_minutes_snapshot INTEGER NOT NULL,
    service_price_minor_snapshot BIGINT NOT NULL,
    currency_snapshot VARCHAR(10) NOT NULL DEFAULT 'EUR',
    estimated_total_minor BIGINT NOT NULL,
    actual_total_minor BIGINT,
    payment_method VARCHAR(50),
    source VARCHAR(50) NOT NULL,
    customer_notes TEXT,
    internal_notes TEXT,
    cancellation_reason VARCHAR(255),
    created_by_type VARCHAR(50) NOT NULL,
    created_by_id UUID,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL,
    deleted_at TIMESTAMP WITH TIME ZONE,
    version BIGINT NOT NULL DEFAULT 0,
    CONSTRAINT chk_appointment_times CHECK (starts_at < ends_at)
);

-- Appointment Status History table
CREATE TABLE appointment_status_history (
    id UUID PRIMARY KEY,
    appointment_id UUID NOT NULL REFERENCES appointments(id) ON DELETE CASCADE,
    status VARCHAR(50) NOT NULL,
    actor_type VARCHAR(50) NOT NULL,
    actor_id UUID,
    changed_at TIMESTAMP WITH TIME ZONE NOT NULL,
    reason VARCHAR(255)
);

-- Indexes for performance and multi-tenancy
CREATE INDEX idx_employees_active ON employees(company_id) WHERE deleted_at IS NULL;
CREATE INDEX idx_services_active ON services(company_id) WHERE deleted_at IS NULL;
CREATE INDEX idx_customers_active ON customers(company_id) WHERE deleted_at IS NULL;
CREATE INDEX idx_appointments_query ON appointments(company_id, branch_id, starts_at);
CREATE INDEX idx_appointments_employee ON appointments(company_id, employee_id, starts_at);
CREATE INDEX idx_weekly_schedules_query ON weekly_schedules(company_id, branch_id, employee_id);
CREATE INDEX idx_schedule_exceptions_query ON schedule_exceptions(company_id, branch_id, employee_id, date);
