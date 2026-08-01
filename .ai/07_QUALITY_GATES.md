# Quality gates

## Gate A: compilación

- Backend compila.
- Frontend compila.
- TypeScript sin errores.
- Migraciones válidas.

## Gate B: pruebas

- Unitarias.
- Integración con PostgreSQL real o Testcontainers.
- Autorización.
- Aislamiento multiempresa.
- Concurrencia de reservas.
- UI crítica con pruebas de componente o end-to-end.

## Gate C: seguridad

- Sin secretos detectados.
- Dependencias sin vulnerabilidades críticas conocidas o con excepción documentada.
- Endpoints críticos con rate limit.
- Subidas de archivos restringidas.
- Cookies/tokens configurados según entorno.
- CORS y CSRF revisados.
- Auditoría activa.

## Gate D: operación

- Health/readiness.
- Logs estructurados.
- Backups documentados.
- Restauración ensayable.
- Variables de entorno documentadas.
- Datos seed idempotentes.

## Gate E: producto

- No se ha ampliado el alcance.
- No hay textos o datos inventados presentados como reales.
- Responsive en móvil.
- Flujo de reserva sin contraseña.
- Panel de administración operable desde interfaz.
