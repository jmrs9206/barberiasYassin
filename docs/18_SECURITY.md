# Seguridad

## Amenazas prioritarias

- acceso cruzado entre empresas;
- escalada de permisos;
- toma de cuentas;
- abuso de enlaces mágicos;
- reserva automatizada/spam;
- dobles reservas;
- subida de archivos maliciosos;
- inyección;
- XSS;
- CSRF;
- fuga de secretos;
- exposición de PII;
- impersonación abusiva;
- manipulación de precios;
- pérdida de backups.

## Controles

### Identidad

- hash moderno;
- MFA;
- rate limit;
- lockout progresivo;
- sesiones revocables;
- rotación de tokens;
- reautenticación;
- recuperación segura.

### Autorización

- deny by default;
- permiso + tenant + branch scope;
- tests negativos;
- endpoints de plataforma separados;
- no confiar en UI.

### API

- validación;
- parametrización;
- límites;
- CORS explícito;
- CSRF según patrón;
- headers de seguridad;
- errores sanitizados;
- idempotencia.

### Datos

- TLS;
- cifrado de secretos SMTP;
- minimización;
- backup cifrado;
- retención;
- auditoría;
- no logs sensibles.

### Frontend

- CSP;
- escaping;
- evitar HTML arbitrario;
- sanitización si se permite contenido enriquecido;
- dependencias controladas;
- no secretos en variables públicas.

### Archivos

Ver `docs/16_MEDIA_STORAGE.md`.

## Secretos

- variables de entorno en local;
- gestor de secretos en producción;
- rotación;
- permisos mínimos;
- escaneo de repositorio;
- nunca incluir credenciales en ZIP público.

## Respuesta a incidentes

- revocar sesiones;
- desactivar tenant o SMTP;
- preservar evidencias;
- identificar alcance;
- restaurar;
- informar según obligación;
- postmortem;
- acciones correctivas.
