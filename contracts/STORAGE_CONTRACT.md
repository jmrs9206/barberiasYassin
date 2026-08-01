# Contrato de almacenamiento

## Interfaz conceptual

```java
interface FileStorage {
    StoredObject put(StorageRequest request, InputStream content);
    StoredObjectMetadata head(StorageKey key);
    InputStream get(StorageKey key);
    void markDeleted(StorageKey key);
    void permanentlyDelete(StorageKey key);
}
```

## Requisitos

- claves opacas;
- atomicidad;
- tenant en namespace;
- tamaño y hash;
- streaming;
- errores tipados;
- no rutas absolutas en dominio;
- URLs generadas fuera del dominio;
- visibilidad pública/privada;
- pruebas de traversal;
- garbage collection controlado;
- backup.

## Implementación inicial

`LocalFileStorage` sobre `/data/media`.

## Implementación futura

`MinioFileStorage` o compatible con S3 mediante ADR. El dominio no debe depender del SDK.
