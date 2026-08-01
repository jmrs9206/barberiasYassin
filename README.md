# Plataforma de reservas para barberías

Blueprint funcional, técnico y operativo para construir una aplicación web reutilizable para barberías.

## Primer negocio

- **Nombre comercial:** Barbería Yassin
- **Dirección:** Calle de Alfredo Aleix, 25, Local 9, 28044 Madrid, España
- **Zona horaria:** Europe/Madrid
- **Idioma inicial:** español
- **Moneda:** EUR
- **Modelo de cobro al cliente:** presencial; no habrá pagos online en el MVP

Barbería Yassin será el primer tenant real, pero ninguna regla del producto debe quedar codificada exclusivamente para esta barbería.

## Objetivo

Construir una solución todo en uno:

1. Web pública de la barbería.
2. Reservas online.
3. Gestión de sucursales, trabajadores, servicios y horarios.
4. Panel administrativo para el dueño y usuarios autorizados.
5. Panel de superadministración para el propietario de la plataforma.
6. Recordatorios por correo utilizando el SMTP de cada empresa.
7. Estadísticas de reservas, ocupación e ingresos registrados.
8. Gestión de imágenes mediante almacenamiento local persistente, con posibilidad de migrar a almacenamiento compatible con S3 o MinIO en el futuro.
9. Base reutilizable para incorporar otras barberías.

## Stack objetivo

- **Frontend:** Next.js, React, TypeScript y Tailwind CSS.
- **Backend:** Java, Spring Boot, Spring Security, Spring Data JPA y Bean Validation.
- **Base de datos:** PostgreSQL.
- **Migraciones:** Flyway.
- **Autenticación:** sesiones/tokens seguros, acceso de cliente mediante enlace mágico o código temporal.
- **Archivos:** volumen persistente local detrás de una interfaz de almacenamiento.
- **Correo:** SMTP configurable por empresa.
- **Infraestructura inicial:** Docker Compose y Nginx.
- **Arquitectura:** monolito modular multiempresa.

Las versiones exactas deben fijarse al comenzar el desarrollo, usando versiones estables y soportadas. No actualizar dependencias de forma automática sin ejecutar todas las pruebas.

## Cómo usar este paquete

La IA debe leer, en este orden:

1. `GEMINI.md`
2. `AGENTS.md`
3. `.ai/00_READ_ORDER.md`
4. `.ai/02_NON_NEGOTIABLE_RULES.md`
5. `.ai/03_WORKFLOW.md`
6. `docs/00_PRODUCT_VISION.md`
7. `roadmap/PHASE_0_DISCOVERY.md`

Después debe ejecutar el prompt de `MASTER_PROMPT_GEMINI.md`.

## Principios centrales

- No copiar el diseño, textos, marca ni recursos propietarios de Booksy.
- Se pueden implementar capacidades funcionalmente equivalentes con diseño y código originales.
- No inventar requisitos que contradigan estos documentos.
- No desplegar en producción sin autorización humana.
- No guardar contraseñas ni secretos en Git.
- No usar microservicios en el MVP.
- No incorporar pagos online.
- No depender de Amazon S3.
- No mezclar datos entre empresas.
- No borrar físicamente datos de negocio de forma ordinaria.
- Mantener historial de precios, consentimientos y cambios críticos.
- El superadministrador se gestiona por una cuenta protegida, no mediante una contraseña escrita en el código.

## Resultado esperado

Un monorepo ejecutable en local, documentado y probado, con:

- web pública;
- motor de reservas;
- panel de administración;
- panel de superadministración;
- correos de confirmación y recordatorio;
- gestión de imágenes;
- informes operativos;
- aislamiento multiempresa;
- seed inicial de Barbería Yassin;
- scripts y documentación para instalación, copia de seguridad y restauración.
