# Observabilidad y soporte

## Logs

- JSON estructurado;
- timestamp;
- level;
- service;
- environment;
- traceId;
- companyId cuando sea seguro;
- actorId pseudónimo;
- event code.

No registrar:

- contraseñas;
- tokens;
- códigos;
- secretos SMTP;
- contenido legal completo;
- PII innecesaria.

## Métricas

- latencia;
- errores;
- disponibilidad;
- pool DB;
- jobs pendientes;
- correos enviados/fallidos;
- uso de almacenamiento;
- uploads rechazados;
- conflictos de reserva;
- intentos de login;
- backups.

## Health

- liveness;
- readiness;
- DB;
- storage writable;
- scheduler;
- configuración crítica;
- SMTP no debe bloquear readiness si está degradado, pero sí alertar.

## Alertas

- errores 5xx;
- cola atascada;
- backup fallido;
- espacio bajo;
- DB no disponible;
- tasa anormal de login;
- reintentos SMTP;
- fallo de migración.

## Soporte

- correlation ID visible al usuario en errores;
- panel de entregas;
- auditoría;
- diagnóstico sin exponer datos;
- runbooks.
