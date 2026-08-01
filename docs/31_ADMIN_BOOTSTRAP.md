# Bootstrap de superadministración

## Requisito

El propietario de la plataforma necesita una cuenta `PLATFORM_SUPER_ADMIN` sin fecha de caducidad de cuenta.

## No hacer

- no escribir credenciales en el código;
- no incluir una contraseña real en el repositorio;
- no usar `admin/admin`;
- no imprimir la contraseña en logs;
- no crear la misma contraseña en todos los entornos;
- no permitir que un tenant modifique esta cuenta.

## Flujo recomendado

1. El instalador genera una contraseña aleatoria larga.
2. Define variables de entorno seguras.
3. Ejecuta un comando idempotente de bootstrap.
4. El backend crea el usuario solo si no existe.
5. La contraseña queda hasheada.
6. Se exige cambio al primer acceso.
7. Se configura MFA.
8. Se borran variables temporales cuando sea posible.
9. Se guarda la credencial en un gestor de contraseñas.
10. Se audita el bootstrap sin registrar el secreto.

## Cuenta y sesión

```text
account_expires_at: null
password_rotation_required: true al inicio
session_idle_timeout: configurado
session_absolute_timeout: configurado
refresh_rotation: enabled
mfa_required: true en producción
```

## Recuperación

Debe existir un procedimiento administrativo seguro para:

- restablecer contraseña;
- revocar sesiones;
- reemplazar MFA;
- desbloquear cuenta.

Requiere acceso controlado al servidor y deja auditoría.
