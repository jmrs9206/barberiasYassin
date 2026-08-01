# Panel de superadministración

## Objetivo

Permitir al propietario de la plataforma administrar empresas y soporte sin usar directamente SQL para operaciones normales.

## Funciones

### Empresas

- crear;
- activar;
- suspender;
- archivar;
- asignar plan;
- configurar límites;
- abrir detalle;
- ver sucursales;
- crear administrador inicial;
- configurar dominio;
- seed controlado.

### Operación

- entregas de correo;
- cola y reintentos;
- uso de almacenamiento;
- salud de servicios;
- versión desplegada;
- jobs;
- copias de seguridad registradas;
- alertas.

### Seguridad

- usuarios de plataforma;
- MFA;
- sesiones;
- revocación;
- auditoría;
- intentos fallidos;
- support impersonation.

### Soporte auditado

Para entrar como administrador de empresa:

1. seleccionar empresa;
2. introducir motivo;
3. definir duración;
4. crear sesión especial;
5. mostrar banner;
6. limitar acciones sensibles o pedir reautenticación;
7. registrar todas las acciones;
8. finalizar manual o automáticamente.

## Cuenta superadmin

- `account_expires_at = null`;
- no puede ser gestionada por administradores de tenant;
- sesión corta;
- refresh limitado;
- MFA obligatorio en producción;
- recuperación protegida;
- credenciales creadas en bootstrap;
- rotación al primer acceso;
- no se muestran ni recuperan contraseñas existentes.

## Backend/CLI

Se pueden crear comandos de mantenimiento para:

- bootstrap inicial;
- rotar credencial;
- desbloquear cuenta;
- revocar sesiones;
- validar integridad;
- lanzar restauración guiada.

Estos comandos exigen acceso al servidor, quedan documentados y no reemplazan el panel.
