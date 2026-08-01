# Protocolo de decisiones

## Decisiones pequeñas

El agente puede resolverlas si:

- no cambian el alcance;
- no introducen coste;
- no afectan a cumplimiento;
- son reversibles;
- siguen los ADR.

Debe documentar la elección en el código o changelog.

## Decisiones relevantes

Crear un ADR cuando afecte a:

- arquitectura;
- modelo de datos;
- seguridad;
- proveedor externo;
- estrategia multiempresa;
- autenticación;
- almacenamiento;
- retención;
- despliegue;
- compatibilidad futura.

## Formato mínimo

- Contexto.
- Opciones consideradas.
- Decisión.
- Consecuencias.
- Plan de reversión.
- Estado: propuesta, aceptada, reemplazada o rechazada.

## No inventar

Cuando falten datos comerciales reales, usar estado `PENDING_CONFIGURATION` o placeholders claramente identificados. Ejemplos:

- teléfono;
- correo;
- dominio;
- logotipo;
- servicios;
- precios;
- trabajadores;
- horarios;
- política de cancelación.
