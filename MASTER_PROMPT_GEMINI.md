# Prompt maestro para iniciar el proyecto

Copia el bloque siguiente en Gemini CLI desde la carpeta donde quieras crear el repositorio.

```text
Trabaja en el directorio actual y construye el proyecto definido por este paquete de especificaciones.

INSTRUCCIONES OBLIGATORIAS:

1. Lee primero, sin omitir archivos:
   - GEMINI.md
   - AGENTS.md
   - .ai/00_READ_ORDER.md
   - .ai/02_NON_NEGOTIABLE_RULES.md
   - .ai/03_WORKFLOW.md
   - .ai/06_DEFINITION_OF_DONE.md
   - docs/00_PRODUCT_VISION.md
   - docs/02_SCOPE_MVP_ROADMAP.md
   - docs/03_ARCHITECTURE.md
   - docs/05_MULTI_TENANCY.md
   - docs/18_SECURITY.md
   - docs/19_PRIVACY_LEGAL.md
   - roadmap/PHASE_0_DISCOVERY.md

2. No escribas código hasta mostrar:
   - el alcance exacto de la Fase 0;
   - la estructura propuesta del monorepo;
   - las decisiones técnicas que ya están fijadas;
   - las preguntas realmente bloqueantes;
   - las pruebas y controles que usarás.

3. Si no hay bloqueos, ejecuta la Fase 0 y después la Fase 1. No avances a fases posteriores en la misma ejecución salvo que yo lo autorice.

4. Usa este stack:
   - Frontend: Next.js + React + TypeScript + Tailwind CSS.
   - Backend: Java + Spring Boot + Spring Security + Spring Data JPA.
   - Base de datos: PostgreSQL.
   - Migraciones: Flyway.
   - Infraestructura local: Docker Compose.
   - Proxy: Nginx cuando corresponda.
   - Arquitectura: monolito modular multiempresa.

5. Crea el repositorio dentro del directorio actual. Si ya hay archivos, no los borres sin explicarlo. Conserva este paquete documental dentro del repositorio.

6. Implementa Barbería Yassin como tenant inicial configurable:
   - nombre: Barbería Yassin;
   - dirección: Calle de Alfredo Aleix, 25, Local 9, 28044 Madrid;
   - zona horaria: Europe/Madrid;
   - moneda: EUR;
   - idioma: es-ES.
   No inventes teléfono, correo, trabajadores, horarios, precios ni servicios definitivos.

7. Respeta todas las restricciones:
   - sin pagos online en el MVP;
   - sin microservicios;
   - sin Amazon S3;
   - imágenes en almacenamiento local persistente mediante una abstracción reemplazable;
   - correos desde SMTP configurable por empresa;
   - ningún secreto en Git;
   - cuenta SUPER_ADMIN sin caducidad de cuenta, pero con sesiones y tokens que sí caducan;
   - no crear una contraseña fija en el código;
   - aislamiento estricto entre empresas;
   - soft delete, auditoría y versionado legal;
   - snapshots de precio en las reservas;
   - no copiar diseño ni contenido de Booksy.

8. Trabaja por vertical slices pequeños. Cada cambio debe incluir pruebas, migración si aplica, documentación y validación de seguridad.

9. Al terminar cada fase:
   - ejecuta build, tests y linters;
   - muestra resultados;
   - actualiza el checklist;
   - enumera riesgos y pendientes;
   - no declares terminado lo que no hayas verificado.

10. No despliegues ni envíes correos reales. Usa Mailpit o equivalente local para desarrollo.

Empieza ahora leyendo los archivos y mostrando el plan de la Fase 0.
```
