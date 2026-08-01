# ADR-003: Almacenamiento local persistente

- **Estado:** aceptada para MVP

## Decisión

Guardar media en volumen persistente local y metadatos en PostgreSQL.

## Razones

- evita Amazon;
- coste inicial bajo;
- operación simple.

## Condiciones

- backup externo;
- límites;
- pipeline seguro;
- interfaz reemplazable;
- no guardar dentro del contenedor efímero.

## Evolución

MinIO o almacenamiento compatible si se necesita escalar.
