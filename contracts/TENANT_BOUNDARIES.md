# Contrato de límites de tenant

## Siempre scoped

- sucursales;
- empleados;
- clientes;
- servicios;
- extras;
- horarios;
- citas;
- media;
- informes;
- plantillas;
- notificaciones;
- contenido web;
- documentos legales;
- consentimientos;
- auditoría de empresa.

## Globales

- usuario global;
- catálogo de permisos base;
- configuración de plataforma;
- planes;
- feature definitions;
- superadministradores;
- métricas técnicas agregadas sin PII.

## Reglas de acceso

- Un membership habilita acceso a una empresa.
- Los permisos pueden limitar sucursales.
- Un recurso recibido por ID se vuelve a cargar con tenant.
- Las relaciones se validan dentro del mismo tenant.
- Las exportaciones no aceptan un tenant libre.
- Los enlaces públicos contienen referencias firmadas y limitadas.
- Los jobs incluyen tenant explícito.
- La media pública se resuelve por clave asociada a tenant.
