# Estructura de repositorio

```text
/
├── apps/
│   ├── api/
│   │   ├── src/main/java/
│   │   ├── src/main/resources/db/migration/
│   │   └── src/test/
│   └── web/
│       ├── src/app/
│       ├── src/components/
│       ├── src/features/
│       ├── src/lib/
│       └── tests/
├── packages/
│   └── api-contract/          # opcional: tipos generados desde OpenAPI
├── infra/
│   ├── docker/
│   ├── nginx/
│   ├── backup/
│   └── scripts/
├── docs/
├── contracts/
├── adr/
├── roadmap/
├── .ai/
├── docker-compose.yml
├── .env.example
├── Makefile o scripts equivalentes
├── README.md
├── GEMINI.md
└── AGENTS.md
```

## Reglas

- El backend no depende del frontend.
- El frontend consume un contrato versionado.
- Las migraciones no se editan después de publicarse; se añaden nuevas.
- No subir `node_modules`, builds, secretos, datos de PostgreSQL ni volumen de media.
- Las imágenes seed mínimas deben ser recursos propios o placeholders simples.
- Los scripts de backup no deben contener credenciales.
