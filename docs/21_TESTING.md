# Estrategia de pruebas

## Backend

- unitarias de dominio;
- integración con PostgreSQL;
- repositorios;
- migraciones;
- seguridad;
- multiempresa;
- scheduler/outbox;
- SMTP falso;
- almacenamiento temporal;
- concurrencia.

Preferir Testcontainers para comportamiento real de PostgreSQL.

## Frontend

- componentes;
- formularios;
- permisos visuales;
- estados de error;
- accesibilidad;
- navegación;
- cliente API;
- end-to-end de flujos críticos.

## E2E críticos

1. Cliente reserva como invitado.
2. Dos clientes intentan el mismo slot.
3. Cliente modifica mediante enlace.
4. Cliente cancela.
5. Admin crea y completa.
6. Admin registra ingreso real.
7. Usuario sin permiso no ve ingresos.
8. Tenant A no accede a B.
9. Superadmin inicia soporte auditado.
10. Admin sube y publica imagen.
11. Scheduler envía recordatorio en Mailpit.
12. Restauración de backup en entorno limpio.

## Datos

- factories;
- tenant A y B;
- sin datos reales;
- fechas controladas con `Clock`;
- zona Europe/Madrid y cambios DST;
- IDs aleatorios.

## Rendimiento básico

- consulta de disponibilidad;
- dashboard;
- agenda semanal;
- galería;
- subida de imagen;
- cola de correos.

No optimizar sin medida, pero evitar N+1 y consultas sin índices.
