# Estados y transiciones de cita

## Estados

- `PENDING_CONFIRMATION`
- `CONFIRMED`
- `CHECKED_IN`
- `IN_PROGRESS`
- `COMPLETED`
- `CANCELLED_BY_CUSTOMER`
- `CANCELLED_BY_BUSINESS`
- `NO_SHOW`
- `EXPIRED`

## Transiciones básicas

```text
PENDING_CONFIRMATION -> CONFIRMED
PENDING_CONFIRMATION -> EXPIRED
PENDING_CONFIRMATION -> CANCELLED_BY_CUSTOMER
PENDING_CONFIRMATION -> CANCELLED_BY_BUSINESS

CONFIRMED -> CHECKED_IN
CONFIRMED -> CANCELLED_BY_CUSTOMER
CONFIRMED -> CANCELLED_BY_BUSINESS
CONFIRMED -> NO_SHOW

CHECKED_IN -> IN_PROGRESS
CHECKED_IN -> CANCELLED_BY_BUSINESS

IN_PROGRESS -> COMPLETED
IN_PROGRESS -> CANCELLED_BY_BUSINESS
```

## Reglas

- No reabrir una cita completada sin permiso y auditoría.
- La corrección administrativa debe conservar historial.
- Cancelar libera disponibilidad.
- `NO_SHOW` no registra ingreso real por defecto.
- `COMPLETED` puede existir sin cobro registrado, pero el dashboard lo muestra como pendiente.
- Cada transición guarda actor, fecha, motivo y versión.
- Las transiciones inválidas devuelven error de dominio.
