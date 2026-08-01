# Almacenamiento de imágenes y archivos

## Estrategia inicial

Archivos en un volumen persistente local.

```text
/data/media/
└── companies/
    └── {companyUuid}/
        ├── branding/
        ├── branches/
        ├── employees/
        ├── services/
        ├── gallery/
        └── private/
```

## Base de datos

Guardar:

- storage key relativa;
- company_id;
- owner type/id;
- mime detectado;
- tamaño;
- hash;
- dimensiones;
- variante;
- visibilidad;
- estado;
- alt text;
- uploader;
- timestamps.

No guardar una ruta absoluta ni el binario en PostgreSQL.

## URL

El frontend recibe una URL derivada por backend o proxy. Las rutas públicas y privadas son distintas.

## Pipeline de subida

1. comprobar permiso;
2. límite de tamaño;
3. detectar MIME por contenido;
4. permitir formatos seguros;
5. decodificar imagen;
6. eliminar metadata innecesaria;
7. redimensionar;
8. crear WebP/AVIF si está soportado;
9. generar UUID;
10. escribir de forma atómica;
11. registrar metadatos;
12. analizar malware si se amplía el tipo de archivo.

## Seguridad

- no usar el nombre original como path;
- prevenir path traversal;
- no servir archivos ejecutables;
- `Content-Disposition` y `Content-Type` correctos;
- CSP;
- límites de píxeles para evitar decompression bombs;
- cuotas por empresa;
- borrado lógico y garbage collection retrasado.

## Backups

El backup de base de datos y media debe corresponder al mismo punto lógico o documentar la consistencia. Probar restauración.

## Evolución

La interfaz `FileStorage` debe permitir `LocalFileStorage` y futuro `MinioFileStorage` sin cambiar el dominio.
