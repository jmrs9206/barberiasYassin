# ADR-002: PostgreSQL compartido con tenant por fila

- **Estado:** aceptada

## Decisión

Esquema compartido y `company_id` en datos de negocio.

## Razones

- coste;
- operación;
- reporting;
- backups;
- onboarding.

## Riesgos

Acceso cruzado.

## Mitigación

TenantContext, autorización, constraints, pruebas negativas, auditoría y posible RLS.
