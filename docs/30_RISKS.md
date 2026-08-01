# Registro de riesgos

| Riesgo | Impacto | Mitigación |
|---|---:|---|
| Mezcla de datos entre tenants | Crítico | Contexto de tenant, autorización, pruebas negativas, auditoría |
| Doble reserva | Alto | Revalidación transaccional, constraint, pruebas de concurrencia |
| Correos bloqueados | Alto | SPF/DKIM/DMARC, límites, retries, panel de fallos |
| Pérdida de imágenes | Alto | volumen persistente, backup externo, restore test |
| Credenciales expuestas | Crítico | secretos fuera de Git, escaneo y rotación |
| Superadmin comprometido | Crítico | MFA, sesión corta, reautenticación, auditoría |
| Métricas financieras incorrectas | Alto | definiciones, snapshots, tests, separar estimado/real |
| Fricción de reserva | Medio | invitado, mobile first, pruebas UX |
| Scope creep | Alto | roadmap y no negociables |
| Dependencia de servidor único | Medio | backup, runbook, interfaz de storage, evolución |
| Incumplimiento legal | Alto | privacidad por diseño y revisión profesional |
| Coste oculto de correo | Medio | límites por proveedor y mensajes claros |
| Imágenes maliciosas | Alto | decodificación, MIME, límites, nombres UUID |
| DST y zonas horarias | Medio | UTC + timezone de sucursal + tests |
| Importación defectuosa | Alto | dry run, staging, conciliación |
