# Fase 1: Fundación técnica

## Objetivo

Arrancar web, API y PostgreSQL con identidad, tenant y observabilidad mínima.

## Vertical slices

1. Docker Compose local.
2. API Spring Boot con health.
3. Next.js con layout base.
4. PostgreSQL y Flyway.
5. Company/Branch seed.
6. Bootstrap superadmin.
7. Autenticación de staff.
8. TenantContext.
9. Auditoría base.
10. Tests tenant A/B.

## Entregables

- `docker compose up`;
- login local;
- superadmin creado de forma segura;
- Barbería Yassin seed;
- panel placeholder protegido;
- migrations;
- tests;
- Mailpit;
- media volume.

## No incluir

- motor completo de reservas;
- informes;
- web final;
- correos reales.
