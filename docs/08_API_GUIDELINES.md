# Guía de API

## Estilo

REST JSON versionado, por ejemplo `/api/v1`.

## Principios

- DTOs explícitos.
- Validación backend.
- Errores estructurados.
- Paginación.
- Filtros permitidos mediante whitelist.
- Ordenación controlada.
- Idempotency keys en operaciones sensibles.
- Correlation ID.
- Fechas ISO-8601 con zona/UTC.
- Dinero con minor units y currency o decimal serializado como string.

## Recursos

Ejemplos:

- `/public/companies/{slug}`
- `/public/companies/{slug}/availability`
- `/public/companies/{slug}/appointments`
- `/customer/appointments/{token}`
- `/admin/appointments`
- `/admin/services`
- `/admin/employees`
- `/admin/reports/occupancy`
- `/platform/companies`

La ruta pública puede contener slug, pero el backend resuelve y valida la empresa.

## Errores

Formato orientativo:

```json
{
  "type": "https://example.invalid/problems/appointment-conflict",
  "title": "Horario no disponible",
  "status": 409,
  "code": "APPOINTMENT_CONFLICT",
  "detail": "El horario acaba de ser reservado.",
  "traceId": "..."
}
```

No filtrar detalles internos.

## Concurrencia

- `409 Conflict` para slot ocupado.
- Revalidar disponibilidad en la misma transacción de creación.
- No reservar basándose solo en un resultado previo de disponibilidad.

## OpenAPI

- Generar y validar especificación.
- Mantener ejemplos sin datos personales reales.
- Generar cliente TypeScript si reduce divergencia.
- No exponer endpoints internos en documentación pública de producción.
