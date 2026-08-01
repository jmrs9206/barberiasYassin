# Copias de seguridad y recuperación

## Objetivos iniciales

Definir RPO y RTO antes de producción. Propuesta inicial a validar:

- backup diario completo;
- WAL o backups más frecuentes si el negocio lo requiere;
- media diaria;
- retención escalonada;
- copia externa al servidor;
- cifrado.

## Componentes

- PostgreSQL;
- media;
- configuración;
- secretos mediante su propio sistema;
- documentación de versión;
- inventario de dependencias.

## Regla 3-2-1

- tres copias;
- dos medios;
- una fuera del servidor principal.

## Restauración

Una copia no es válida hasta probarla. El runbook debe cubrir:

1. preparar host limpio;
2. desplegar versión compatible;
3. restaurar PostgreSQL;
4. restaurar media;
5. validar permisos;
6. ejecutar checks;
7. verificar tenants;
8. revisar correos desactivados;
9. documentar tiempos.

## Seguridad

- cifrado;
- acceso mínimo;
- logs;
- rotación;
- no incluir secretos en texto plano;
- eliminación segura al terminar retención.
