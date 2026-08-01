# Auditoría y soft delete

## Soft delete

Aplicar a:

- empresas;
- sucursales;
- usuarios;
- memberships;
- empleados;
- clientes;
- servicios;
- extras;
- media;
- citas cuando legalmente proceda;
- contenido web.

Los datos archivados no se muestran como activos y pueden restaurarse según permisos.

## Auditoría

Registrar acciones críticas:

- login y fallos relevantes;
- cambios de rol;
- exportación;
- precios;
- citas;
- cobros;
- cancelaciones;
- documentos legales;
- SMTP;
- soporte;
- backups;
- eliminación/anonimización;
- configuración de tenant.

Campos:

- event_id;
- timestamp;
- actor type/id;
- company_id;
- branch_id;
- action;
- resource type/id;
- result;
- reason;
- trace ID;
- diff sanitizado;
- source IP truncada o tratada según política;
- metadata segura.

## Inmutabilidad

- append-only en aplicación;
- sin endpoint de edición;
- acceso restringido;
- retención definida;
- exportación controlada.

## PII

No almacenar contraseñas, tokens, secretos ni cuerpos completos innecesarios. Los diffs deben excluir campos sensibles.
