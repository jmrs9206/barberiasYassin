# ADR-004: Correo como canal automático inicial

- **Estado:** aceptada

## Decisión

Confirmaciones y recordatorios por SMTP de la empresa.

## No incluido

SMS y WhatsApp oficial automatizado.

## Consecuencias

- bajo coste adicional;
- dependencia de límites del proveedor;
- requiere SPF/DKIM/DMARC;
- necesita outbox, retries y panel de fallos.
