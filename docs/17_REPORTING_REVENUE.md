# Informes, ocupación e ingresos

## Definiciones

Ver `contracts/REPORTING_DEFINITIONS.md`.

## Ingreso estimado

Suma del total snapshot de citas en estados incluidos por la métrica. Debe indicar claramente si considera citas futuras, confirmadas o completadas.

## Ingreso real

Suma de `actual_total_minor` de citas completadas con cobro registrado. No equivale a facturación fiscal.

## Datos de cobro

- total cobrado;
- descuento;
- propina opcional;
- método: efectivo, tarjeta presencial, Bizum u otro;
- usuario que registró;
- fecha.

## Ocupación

Separar:

- horas planificadas;
- horas bloqueadas;
- horas reservables;
- horas reservadas;
- horas completadas;
- huecos libres;
- tiempo perdido por cancelaciones;
- utilización por trabajador y sucursal.

## Reportes MVP

- reservas por estado;
- ingreso estimado y real;
- ticket medio;
- servicios;
- trabajadores;
- sucursales;
- clientes nuevos/recurrentes;
- cancelaciones/no-show;
- ocupación;
- horas sin reserva;
- comparativa de periodos.

## Reglas

- métricas con zona horaria de sucursal;
- filtros por tenant;
- exportación auditada;
- no incluir PII innecesaria;
- cálculos documentados;
- no sumar citas canceladas como ingreso real;
- cambios de catálogo no alteran históricos;
- caché invalidada por tenant.
