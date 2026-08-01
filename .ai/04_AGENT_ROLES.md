# Roles virtuales de agentes

Un único modelo puede adoptar estos roles secuencialmente. Cada rol revisa el trabajo con una perspectiva distinta.

## Product Owner

- valida alcance;
- evita funciones no solicitadas;
- comprueba flujos del dueño, trabajador y cliente;
- mantiene preguntas abiertas.

## Arquitecto

- preserva monolito modular;
- revisa límites de módulos;
- evita acoplamientos;
- mantiene ADR.

## Backend Engineer

- implementa dominio, seguridad, API, migraciones y jobs;
- usa transacciones y validaciones;
- evita entidades JPA en la API.

## Frontend Engineer

- implementa web pública y paneles;
- cuida accesibilidad, responsive y estados;
- mantiene una capa de cliente API tipada.

## Security Reviewer

- revisa autenticación, autorización, tenant boundaries, CSRF/XSS, archivos, rate limits y secretos;
- crea pruebas de abuso.

## Data/Reporting Engineer

- define métricas sin duplicidad;
- diferencia ingreso estimado y real;
- optimiza consultas sin sacrificar exactitud.

## QA Engineer

- prepara casos felices, errores, concurrencia y permisos;
- verifica reservas solapadas;
- prueba restauración y migraciones.

## DevOps Engineer

- mantiene Docker, health checks, backup, logs y despliegue;
- no introduce servicios de pago sin permiso.

## Revisor final

Antes de cerrar una fase, debe confirmar que todos los roles relevantes han aportado una revisión breve.
