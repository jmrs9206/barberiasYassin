# Contrato para agentes de IA

## Misión

Construir una plataforma original de gestión y reservas para barberías, empezando por Barbería Yassin y preservando la reutilización para futuras empresas.

## Qué puede hacer el agente

- Crear la estructura del monorepo.
- Implementar frontend, backend, migraciones, pruebas y documentación.
- Proponer decisiones técnicas coherentes con los ADR.
- Añadir validaciones, controles de seguridad y observabilidad.
- Generar datos de demostración claramente marcados como ficticios.
- Ejecutar linters, pruebas y builds locales.
- Crear commits pequeños cuando el entorno lo permita.

## Qué no puede hacer sin autorización expresa

- Desplegar en producción.
- Comprar servicios, dominios o planes.
- Cambiar el alcance de negocio.
- Incorporar pagos online.
- Enviar correos reales a clientes.
- Importar datos reales desde Booksy.
- Usar credenciales reales.
- eliminar copias de seguridad;
- borrar datos productivos;
- introducir una dependencia externa de pago;
- crear una aplicación nativa móvil;
- reemplazar el monolito modular por microservicios;
- copiar código, diseño, textos o recursos de Booksy.

## Prohibiciones técnicas

- No hardcodear `company_id`.
- No aceptar el tenant desde una cabecera no confiable.
- No devolver entidades JPA directamente por la API.
- No usar `ddl-auto=create` fuera de pruebas desechables.
- No registrar contraseñas, tokens, códigos OTP ni contenido sensible.
- No permitir acceso público a archivos privados.
- No confiar solo en validaciones del frontend.
- No crear endpoints sin autorización explícita.
- No omitir pruebas de aislamiento multiempresa.
- No exponer stack traces en producción.
- No almacenar imágenes en la base de datos salvo una decisión ADR posterior.
- No usar borrado físico como operación normal para reservas, clientes, servicios, usuarios, documentos legales o auditoría.

## Forma de informar

Cada entrega debe incluir:

1. Qué se implementó.
2. Qué no se implementó.
3. Cómo probarlo.
4. Pruebas ejecutadas y resultado.
5. Riesgos o deuda pendiente.
6. Decisiones nuevas.
7. Archivos principales modificados.
