# DevOps y despliegue

## Entorno local

Docker Compose con:

- PostgreSQL;
- API;
- Web;
- Mailpit;
- volumen media;
- opcional Nginx.

Debe existir un comando documentado para iniciar, detener, resetear solo datos locales y ejecutar pruebas.

## Producción inicial

Servidor único adecuado con:

- reverse proxy;
- TLS;
- contenedores;
- PostgreSQL persistente;
- media persistente;
- backup externo;
- firewall;
- actualizaciones;
- monitorización.

No guardar datos persistentes en la capa writable efímera del contenedor.

## Pipeline

1. lint;
2. typecheck;
3. tests;
4. build;
5. scan;
6. imagen;
7. migración validada;
8. despliegue autorizado;
9. smoke tests;
10. rollback disponible.

## Migraciones

- ejecutar una vez;
- backup previo en producción;
- backward compatibility cuando sea posible;
- no editar migraciones ya aplicadas;
- estrategia para cambios largos.

## Dominios

Soportar:

- dominio propio;
- subdominio de plataforma;
- resolución de tenant;
- certificados;
- canonical.

Automatización de DNS queda fuera del MVP.
