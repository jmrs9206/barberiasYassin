# Criterios de aceptación globales

## Reserva

- Un usuario móvil puede reservar sin contraseña.
- La disponibilidad refleja horarios y citas.
- No se crean solapamientos.
- La confirmación queda en cola de correo.
- El enlace de gestión expira y está protegido.
- El precio queda congelado.
- La zona horaria es correcta.

## Administración

- El dueño gestiona servicios, precios, extras, imágenes y horarios desde UI.
- Puede ver reservas por estado.
- Puede completar y registrar cobro.
- Puede ver ocupación y huecos.
- Los permisos restringen ingresos y exportaciones.
- Los cambios críticos se auditan.

## Superadministración

- Se crea un tenant sin tocar código.
- Se suspende sin borrar datos.
- El soporte es temporal y auditado.
- El superadmin no puede ser administrado por tenants.
- La cuenta no caduca, las sesiones sí.

## Multiempresa

- Dos tenants coexisten.
- No existe acceso cruzado.
- URLs de media respetan visibilidad.
- Jobs, informes y exportaciones están aislados.

## Operación

- Arranque local documentado.
- Migraciones desde cero.
- Backup y restauración documentados.
- Media persiste tras recrear contenedores.
- SMTP local visible en Mailpit.
- Tests y builds pasan.
