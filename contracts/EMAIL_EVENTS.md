# Eventos de correo

## Operativos

- `APPOINTMENT_CREATED`
- `APPOINTMENT_CONFIRMED`
- `APPOINTMENT_REMINDER_24H`
- `APPOINTMENT_REMINDER_2H`
- `APPOINTMENT_CHANGED`
- `APPOINTMENT_CANCELLED`
- `APPOINTMENT_WAITLIST_SLOT_AVAILABLE`
- `CUSTOMER_MAGIC_LINK`
- `USER_INVITATION`
- `PASSWORD_RESET`
- `SECURITY_ALERT`

## Post-servicio

- `REVIEW_REQUEST` configurable.

## Marketing

- `BIRTHDAY_GREETING`
- `PROMOTION`
- `INACTIVE_CUSTOMER`

Los eventos de marketing exigen base legal/consentimiento y baja.

## Idempotencia

Clave sugerida:

```text
{companyId}:{eventType}:{resourceId}:{scheduledVersion}:{recipientHash}
```

## Variables permitidas

Cada plantilla define una whitelist. No se permite acceso arbitrario a objetos ni ejecución de código.
