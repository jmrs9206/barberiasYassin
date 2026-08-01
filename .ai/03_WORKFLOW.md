# Workflow de desarrollo para la IA

## Ciclo por fase

### 1. Leer

- Revisar especificación y contratos relacionados.
- Revisar código existente.
- Revisar migraciones y pruebas.
- Comprobar preguntas abiertas y riesgos.

### 2. Planificar

Crear un plan de 3 a 10 pasos con:

- resultado observable;
- archivos o módulos afectados;
- migraciones;
- amenazas de seguridad;
- pruebas;
- rollback.

### 3. Diseñar la unidad vertical

Cada unidad debe incluir, cuando aplique:

- migración;
- entidad y repositorio;
- servicio de dominio;
- autorización;
- endpoint;
- DTO y validación;
- interfaz;
- pruebas backend;
- pruebas frontend;
- documentación.

Evitar crear capas vacías o grandes esqueletos sin comportamiento verificable.

### 4. Implementar

- Cambios pequeños.
- Nombres claros.
- Sin duplicación innecesaria.
- Transacciones explícitas.
- Errores de dominio previsibles.
- Logs estructurados sin datos sensibles.
- Accesibilidad y estados de carga/error en UI.

### 5. Verificar

Ejecutar como mínimo:

- formato;
- lint;
- typecheck;
- pruebas unitarias;
- pruebas de integración;
- build de frontend;
- build de backend;
- migración desde base vacía;
- prueba de aislamiento tenant;
- análisis de dependencias si está configurado.

### 6. Documentar

Actualizar:

- checklist de fase;
- decisiones;
- endpoints;
- variables de entorno;
- manual de prueba;
- riesgos;
- changelog.

### 7. Informar

Entregar un informe con:

- completado;
- no completado;
- evidencia de pruebas;
- comandos utilizados;
- riesgos;
- siguiente unidad recomendada.

## Regla de pausa

Pausar y pedir decisión cuando:

- haya dos opciones con impacto de negocio;
- una decisión cambie seguridad o privacidad;
- se requiera un servicio de pago;
- falte un dato real imprescindible;
- una especificación sea contradictoria;
- se pretenda eliminar o migrar datos;
- se vaya a desplegar o enviar comunicaciones reales.
