# Reglas no negociables

## Producto

1. No habrá pagos online en el MVP.
2. El cliente pagará en persona.
3. El sistema registrará ingresos operativos, no contabilidad oficial.
4. El cliente podrá reservar sin crear una contraseña.
5. Las citas deben poder confirmarse, modificarse y cancelarse mediante enlaces seguros.
6. La web pública, reservas y paneles pertenecen al mismo producto.
7. No copiar la interfaz, marca, textos ni material protegido de Booksy.

## Arquitectura

8. Monolito modular.
9. PostgreSQL.
10. Flyway como fuente de verdad del esquema.
11. Next.js/React/TypeScript/Tailwind para frontend.
12. Java/Spring Boot para backend.
13. Docker Compose para entorno local.
14. Nada de microservicios salvo ADR futuro aprobado.

## Multiempresa

15. Toda entidad de negocio debe estar asociada a una empresa cuando corresponda.
16. El tenant se deriva de la autenticación, dominio o contexto validado.
17. No confiar en `company_id` enviado por el frontend.
18. Añadir pruebas negativas de acceso cruzado.
19. El superadministrador puede operar entre tenants solo mediante endpoints especiales y auditados.
20. Ningún administrador de empresa puede modificar o eliminar al superadministrador de plataforma.

## Seguridad

21. No guardar secretos en Git.
22. No contraseña fija en código.
23. La cuenta superadmin no caduca; las sesiones y tokens sí.
24. MFA obligatorio en producción para superadministración.
25. Hash de contraseñas resistente y parámetros actualizables.
26. Tokens de un solo uso almacenados como hash.
27. Rate limiting para login, OTP, enlaces y reservas.
28. Auditoría de acciones críticas.
29. Archivos validados por contenido, tamaño y extensión.
30. No exponer rutas físicas.
31. No registrar datos sensibles innecesarios.

## Datos

32. Soft delete para datos de negocio definidos.
33. Auditoría inmutable o append-only.
34. Historial de estados de cita.
35. Snapshot de nombre, duración y precio del servicio en la reserva.
36. Versionado de documentos legales.
37. Registro del consentimiento con versión, fecha, finalidad y origen.
38. Fechas almacenadas en UTC; presentación en zona horaria de la sucursal.
39. Dinero en unidades enteras mínimas o tipo decimal controlado, nunca `float`.

## Operación

40. Imágenes en un volumen persistente y respaldado.
41. SMTP por empresa; Mailpit local.
42. Los límites del proveedor de correo deben ser configurables.
43. No afirmar que el correo es gratis; el sistema evita un proveedor transaccional adicional, pero depende del plan de correo.
44. Copias de seguridad verificadas mediante restauraciones periódicas.
45. No desplegar sin aprobación humana.
