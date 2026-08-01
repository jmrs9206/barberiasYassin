# Blueprint de base de datos

Los nombres son orientativos. Las migraciones definitivas deben usar convenciones consistentes.

## Plataforma e identidad

### users

- id UUID PK
- email normalizado
- password_hash nullable
- display_name
- status
- mfa_enabled
- account_expires_at nullable
- last_login_at
- created_at, updated_at
- deleted_at nullable

### companies

- id UUID PK
- name
- slug unique
- status
- default_locale
- default_currency
- default_timezone
- plan_code
- created_at, updated_at, deleted_at

### company_memberships

- id
- company_id
- user_id
- role_id
- status
- created_at
- unique(company_id, user_id)

### roles, permissions, role_permissions

Roles predeterminados y posibilidad de roles personalizados si se aprueba.

### branches

- id
- company_id
- name
- address fields
- timezone
- status
- booking_settings JSONB controlado
- created_at, updated_at, deleted_at
- unique(company_id, name) según reglas

## Catálogo y equipo

### employees
### employee_branches
### services
### service_prices
### branch_services
### employee_services
### add_ons
### service_add_ons
### weekly_schedules
### schedule_exceptions

Los precios deben guardar periodo de vigencia. Las citas capturan snapshot.

## Clientes y legal

### customers
### customer_contacts opcional
### customer_notes
### legal_documents
### legal_document_versions
### consents
### data_subject_requests

Separar consentimientos operativos de marketing.

## Reservas

### appointments

Campos mínimos:

- id UUID
- company_id
- branch_id
- customer_id
- employee_id
- status
- starts_at UTC
- ends_at UTC
- service_id nullable para conservar cita si servicio se archiva
- service_name_snapshot
- service_duration_minutes_snapshot
- service_price_minor_snapshot
- currency_snapshot
- add_on_total_minor_snapshot
- estimated_total_minor
- actual_total_minor nullable
- payment_method nullable
- source
- customer_notes nullable controlado
- internal_notes nullable
- cancellation_reason nullable
- created_by_type
- created_by_id nullable
- created_at, updated_at, deleted_at
- version para optimistic locking

### appointment_add_ons
### appointment_status_history
### appointment_change_tokens

## Comunicación

### notification_templates
### notification_jobs
### notification_deliveries
### email_suppression

Usar idempotency key única por evento y destinatario.

## Media y web

### media_assets
### media_variants
### website_pages
### website_sections
### seo_settings
### social_links

## Operación

### audit_events
### outbox_events
### job_locks
### feature_flags
### support_sessions
### backup_runs opcional como metadato

## Restricciones y rendimiento

- FKs internas con company coherence validada en servicio y, cuando sea viable, constraints compuestas.
- Índices por `(company_id, status, starts_at)`.
- Índices por `(company_id, branch_id, starts_at)`.
- Índices por `(company_id, employee_id, starts_at)`.
- Índice de email normalizado por empresa para clientes si la regla lo requiere.
- Constraint de dinero no negativo cuando corresponda.
- `deleted_at` en índices parciales de activos.
- Optimistic locking para edición.
- Prevención de solapamiento con transacción y constraint PostgreSQL cuando sea viable.

## Solapamiento recomendado

Explorar `tstzrange` y exclusión GiST para citas activas por trabajador. Debe permitir coexistencia de citas canceladas y bloquear rangos `[start, end)` superpuestos. Documentar la solución definitiva en ADR.
