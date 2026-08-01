# Migración desde Booksy u otra plataforma

## Principio

No automatizar scraping ni acceso no autorizado. Usar exportaciones proporcionadas por el negocio o la plataforma.

## Posibles datos

- clientes;
- servicios;
- trabajadores;
- futuras citas;
- historial;
- imágenes;
- notas;
- consentimientos.

## Proceso

1. inventariar archivos;
2. documentar origen y fecha;
3. mapear campos;
4. validar consentimiento/base legal;
5. limpiar duplicados;
6. importar en staging;
7. informe de errores;
8. validación del dueño;
9. backup;
10. importar producción;
11. reconciliar totales.

## Restricciones

- no asumir que consentimientos de marketing son transferibles;
- no importar contraseñas;
- no confiar en estados desconocidos;
- no enviar correos durante importación;
- etiquetar origen;
- mantener import job idempotente;
- ofrecer dry run.

## MVP

El importador no es obligatorio. Preparar formato CSV documentado puede ser suficiente.
