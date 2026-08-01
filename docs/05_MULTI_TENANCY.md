# Multiempresa y sucursales

## Modelo elegido

Base de datos compartida y esquema compartido con `company_id` en entidades de negocio. Es la opción inicial por simplicidad operativa y coste.

## Tenant

Una empresa representa una barbería contratante. Puede tener una o varias sucursales.

```text
Platform
└── Company
    ├── Branch
    ├── User memberships
    ├── Customers
    ├── Services
    ├── Employees
    ├── Appointments
    └── Media
```

## Resolución del tenant

El tenant puede resolverse por:

- dominio o subdominio público;
- membership del usuario autenticado;
- enlace de reserva firmado;
- contexto explícito de superadministración.

Nunca se aceptará como confiable un `company_id` libre enviado por el cliente.

## Aplicación de filtros

- Repositorios de negocio reciben un `TenantContext`.
- Consultas incluyen `company_id`.
- IDs globales deben ser UUID para dificultar enumeración, pero UUID no reemplaza autorización.
- Restricciones únicas incluyen `company_id`.
- Las cachés incluyen tenant en la clave.
- Jobs procesan un tenant de forma explícita.
- Logs incluyen `companyId` no sensible y correlation ID.

## Defensa adicional

Evaluar PostgreSQL Row Level Security después del MVP o desde el inicio si el equipo domina su operación. No confiar exclusivamente en RLS: mantener autorización y filtros en aplicación.

## Superadministración

- endpoints separados;
- rol `PLATFORM_SUPER_ADMIN`;
- MFA en producción;
- reason code obligatorio para impersonación;
- banner visible durante soporte;
- duración limitada;
- auditoría inmutable;
- posibilidad de revocar la sesión.

## Pruebas obligatorias

- usuario A no puede consultar recursos de B;
- modificación por UUID de otro tenant devuelve no encontrado o prohibido según política;
- exportaciones solo contienen tenant activo;
- media no cruza tenants;
- informes no cruzan tenants;
- scheduler no envía correos de otra empresa;
- impersonación queda auditada.
