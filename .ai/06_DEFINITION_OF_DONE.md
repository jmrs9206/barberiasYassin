# Definition of Done

Una historia solo está terminada cuando:

1. Cumple los criterios funcionales.
2. Tiene autorización backend, no solo ocultación en UI.
3. Respeta aislamiento de tenant.
4. Incluye validación de entrada.
5. Maneja errores con códigos y mensajes coherentes.
6. Incluye pruebas unitarias y/o integración adecuadas.
7. Incluye pruebas negativas de permisos cuando corresponda.
8. Mantiene accesibilidad básica.
9. Tiene estados de carga, vacío y error en frontend.
10. La migración funciona desde base vacía.
11. No introduce secretos.
12. No genera warnings críticos.
13. Build y tests pasan.
14. Documentación actualizada.
15. Logs y auditoría están definidos si la acción es crítica.
16. Se ha considerado rollback.
17. El comportamiento está demostrado con pasos reproducibles.
