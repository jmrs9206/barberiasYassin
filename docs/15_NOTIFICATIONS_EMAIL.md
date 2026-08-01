# Notificaciones por correo

## Objetivo

Enviar correos desde la cuenta o servidor SMTP de cada empresa sin depender inicialmente de un proveedor transaccional externo.

## Aclaración de coste

La aplicación no añadirá una tarifa propia por correo. El envío puede estar incluido en el hosting o correo de la empresa, pero está sujeto a límites, reputación y condiciones de su proveedor.

## Eventos

Definidos en `contracts/EMAIL_EVENTS.md`.

## Arquitectura

1. Ocurre un evento de dominio.
2. Se escribe en outbox dentro de la transacción.
3. Un worker crea un notification job idempotente.
4. Se renderiza plantilla y se envía.
5. Se registra entrega o fallo.
6. Se reintenta con backoff.
7. Fallos permanentes se muestran en administración.

## Configuración SMTP por empresa

- host;
- puerto;
- TLS;
- usuario;
- secreto cifrado;
- from;
- reply-to;
- límites por minuto/hora/día;
- estado de verificación.

No mostrar el secreto después de guardarlo.

## Entregabilidad

Documentar y ayudar a configurar:

- SPF;
- DKIM;
- DMARC;
- reverse DNS cuando aplique;
- remitente consistente;
- contenido no engañoso;
- bajas para marketing;
- suppression list;
- rebotes si el proveedor los expone.

## Desarrollo

Mailpit o equivalente. Nunca enviar a correos reales en tests.

## Plantillas

- versionadas;
- por idioma;
- variables whitelist;
- vista previa;
- prueba a dirección autorizada;
- texto y HTML;
- no permitir ejecución arbitraria.
