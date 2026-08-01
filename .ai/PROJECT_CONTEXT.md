# Project Context

## Context identity

- Project ID: `barberiasYassin`
- Context version: `0.1`
- Repository root: `/home/jmrs/Documentos/PROYECTOS/JMRS/barberiaYassin`
- Branch/worktree: `main`
- Commit verified: `546d54e`
- Last verified: `2026-08-01 12:35 UTC+2`
- Curated by: `@context`

## One-paragraph summary

Plataforma de reservas multiempresa y modular en formato monorrepo, iniciando con la implementación del tenant real "Barbería Yassin" en Madrid. Utiliza un frontend en Next.js 14 y un backend en Java Spring Boot con Maven, usando una base de datos PostgreSQL compartida y aislada lógicamente por columna (`company_id`).

## Verified facts

| ID | Fact | Source | Verified | Confidence |
|---|---|---|---|---|
| F-001 | Repositorio Git inicializado y vinculado al origen remoto. | Git config / Command | 2026-08-01 | HIGH |
| F-002 | Estructura de gobernanza y plantillas copiadas del orquestador. | `.agents/` & `.ai/` files | 2026-08-01 | HIGH |
| F-003 | Blueprint funcional y técnico de la barbería descomprimido en la raíz. | `barberia_yassin_ai_blueprint.zip` | 2026-08-01 | HIGH |
| F-004 | Decisiones de stack acordadas: Next.js 14 y Maven para Spring Boot. | Confirmación del usuario | 2026-08-01 | HIGH |
| F-005 | Directorios del monorepo (`apps/api`, `apps/web`, `infra/`) y `Makefile` creados. | Estructura del sistema | 2026-08-01 | HIGH |

## Current state (`CURRENT`)

### Repository map

```text
/
├── .agents/                   # Políticas y workflows de agentes
├── .ai/                       # Control de proyecto y especificaciones
├── apps/
│   ├── api/                   # Backend Spring Boot (vacío)
│   └── web/                   # Frontend Next.js (vacío)
├── infra/                     # Infraestructura local (Docker, Nginx)
├── adr/                       # Decisiones de Arquitectura (ADRs 001-006)
├── contracts/                 # Contratos de negocio y API
├── docs/                      # Documentación del blueprint técnico
├── roadmap/                   # Fases de desarrollo (0 a 7)
├── templates/                 # Plantillas de incidencias y PRs
├── Makefile                   # Automatización de desarrollo
├── .env.example               # Configuración de variables
├── README.md                  # Manual inicial
└── GEMINI.md                  # Contexto de la IA
```

### Implemented capabilities

- Estructura básica de monorrepo y automatización local mediante Makefile.
- Configuración de políticas y flujos de IA activas en el repositorio.

### Known limitations

- No se han inicializado las aplicaciones de Next.js y Spring Boot (Fase 1).
- No hay contenedores Docker locales configurados (Fase 1).

## Target state (`TARGET`)

- Monolito modular multiempresa completamente operativo con Next.js + Spring Boot + Postgres.
- Primer tenant funcional "Barbería Yassin" listo para operar reservas sin fricción y gestión interna.

## Active constraints

- Sin pagos online en el MVP (pago presencial).
- Sin microservicios (monolito modular).
- Sin almacenamiento Amazon S3 (uso de volumen local).
- Aislamiento estricto de tenants en base de datos (`company_id`).

## Approved decisions

| ADR | Decision | Status | Supersedes |
|---|---|---|---|
| ADR-001 | Monolito modular en Spring Boot | ACCEPTED | - |
| ADR-002 | PostgreSQL Multi-tenancy por columna | ACCEPTED | - |
| ADR-003 | Almacenamiento de imágenes local persistente | ACCEPTED | - |
| ADR-004 | Comunicaciones operativas por correo electrónico (SMTP) | ACCEPTED | - |
| ADR-005 | Sin pagos online en el MVP | ACCEPTED | - |
| ADR-006 | Arquitectura Next.js + Spring Boot | ACCEPTED | - |

## External systems and contracts

| System | Status | Contract source | Credentials available? | Notes |
|---|---|---|---|---|
| SMTP Gateway | CANDIDATE | `contracts/EMAIL_EVENTS.md` | NOT_NEEDED | Configurable por tenant. |
| Mailpit | CONFIRMED | local development | YES | Para pruebas locales. |

## Unknowns and conflicts

| ID | Type | Description | Impact | Resolution owner |
|---|---|---|---|---|
| U-001 | TECHNICAL | Mapeo de subdominios locales para múltiples tenants. | Configuración de Nginx en local | `@devops` (Fase 1) |

## Current iteration

- Iteration ID: `PHASE_0_DISCOVERY`
- Goal: Validar el blueprint, establecer la estructura de monorrepo e iniciar base documental.
- Approved tasks:
  - Crear estructura de carpetas.
  - Generar Makefile operativo.
  - Documentar decisiones de stack iniciales.

## Required reading by role

| Role | Files to read | Files not needed |
|---|---|---|
| `@product` | `.ai/01_MISSION.md`, `docs/00_PRODUCT_VISION.md` | Código fuente |
| `@architect` | `docs/03_ARCHITECTURE.md`, `adr/` | - |
| `@planner` | `roadmap/` | - |

## Context change log

| Version | Date | Change | Evidence |
|---|---|---|---|
| 0.1 | 2026-08-01 | Inicialización del monorepo y carga de especificaciones del blueprint. | Commit inicial |
