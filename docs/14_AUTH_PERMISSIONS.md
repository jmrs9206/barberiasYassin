# Autenticación y permisos

## Tipos de acceso

### Cliente

- reserva sin cuenta;
- enlace firmado o código temporal;
- alcance limitado a una cita o identidad verificada;
- expiración;
- un solo uso cuando corresponda.

### Usuario de empresa

- email + contraseña;
- MFA opcional para roles comunes y obligatorio si se configura;
- memberships;
- roles;
- permisos por sucursal.

### Superadministrador

- autenticación separada lógicamente;
- MFA obligatorio en producción;
- sesiones más cortas;
- reautenticación para acciones críticas.

## Sesiones

Preferencia:

- cookies HttpOnly, Secure y SameSite adecuadas para la aplicación web;
- CSRF protegido;
- rotación de refresh;
- revocación;
- registro de dispositivos/sesiones;
- expiración por inactividad y máxima.

La decisión exacta debe quedar en ADR de autenticación si cambia el patrón.

## Roles iniciales

- PLATFORM_SUPER_ADMIN
- COMPANY_OWNER
- COMPANY_ADMIN
- BRANCH_MANAGER
- RECEPTIONIST
- BARBER
- REPORT_VIEWER
- CUSTOMER

## Permisos

Ver `contracts/PERMISSIONS_MATRIX.md`.

## Reglas

- Deny by default.
- Comprobar permiso y scope de sucursal.
- Las acciones financieras requieren permiso específico.
- Exportar datos requiere permiso específico.
- Gestionar roles no implica ser superadmin.
- Ningún rol de empresa puede escalar a plataforma.
- La UI oculta acciones, pero el backend las impide.
