# Motor de reservas

## Flujo recomendado

1. Sucursal.
2. Servicio.
3. Extras opcionales.
4. Trabajador o "cualquiera disponible".
5. Día.
6. Hora.
7. Nombre, email y teléfono.
8. Consentimientos.
9. Resumen.
10. Confirmación.

El orden puede adaptarse si mejora la disponibilidad, pero debe mantenerse simple.

## Disponibilidad

Considerar:

- horario de apertura de sucursal;
- horario laboral;
- excepciones;
- vacaciones;
- servicios del trabajador;
- duración total;
- preparación;
- limpieza;
- citas activas;
- bloqueos;
- antelación mínima;
- ventana máxima de reserva;
- zona horaria;
- capacidad futura de recursos compartidos.

## Cualquiera disponible

El sistema puede seleccionar:

- primer trabajador disponible;
- distribución equilibrada;
- preferencia configurada.

El algoritmo debe ser determinista y documentado.

## Estados

Definidos en `contracts/APPOINTMENT_STATUS.md`.

## Cambios

- revalidar;
- conservar historial;
- notificar;
- invalidar enlaces usados cuando corresponda;
- no cambiar el snapshot de precio salvo acción explícita y auditada.

## Cancelación

- reglas por empresa/sucursal;
- plazo mínimo;
- razones configurables;
- cancelación manual por admin;
- registro de actor;
- liberar slot;
- notificación.

## No-show

- marcado por usuario autorizado;
- afecta estadísticas;
- puede activar restricciones futuras;
- no bloquear cliente automáticamente sin política clara.

## Lista de espera

MVP opcional:

- cliente elige rangos;
- al liberarse un slot se notifica;
- no se reserva automáticamente sin decisión expresa;
- el enlace expira;
- concurrencia controlada.

## Seguridad antiabuso

- rate limit;
- CAPTCHA adaptativo si se necesita;
- validación de email/teléfono;
- honeypot;
- deduplicación;
- límites de citas futuras;
- bloqueo auditado.
