# Matriz de permisos

Leyenda:

- ✅ predeterminado
- ◐ configurable
- ❌ no

| Permiso | Owner | Admin | Manager | Reception | Barber | Report viewer |
|---|---:|---:|---:|---:|---:|---:|
| APPOINTMENT_VIEW | ✅ | ✅ | ✅ | ✅ | ✅ propias/asignadas | ❌ |
| APPOINTMENT_CREATE | ✅ | ✅ | ✅ | ✅ | ◐ | ❌ |
| APPOINTMENT_EDIT | ✅ | ✅ | ✅ | ✅ | ◐ | ❌ |
| APPOINTMENT_CANCEL | ✅ | ✅ | ✅ | ✅ | ◐ | ❌ |
| APPOINTMENT_COMPLETE | ✅ | ✅ | ✅ | ✅ | ✅ asignadas | ❌ |
| APPOINTMENT_MARK_NO_SHOW | ✅ | ✅ | ✅ | ✅ | ◐ | ❌ |
| REVENUE_VIEW | ✅ | ◐ | ◐ | ❌ | ❌ | ✅ |
| REVENUE_EDIT | ✅ | ◐ | ◐ | ◐ | ◐ | ❌ |
| CUSTOMER_VIEW | ✅ | ✅ | ✅ | ✅ | ◐ limitado | ❌ |
| CUSTOMER_EDIT | ✅ | ✅ | ✅ | ✅ | ◐ | ❌ |
| CUSTOMER_EXPORT | ✅ | ◐ | ❌ | ❌ | ❌ | ◐ |
| SERVICE_MANAGE | ✅ | ✅ | ◐ | ❌ | ❌ | ❌ |
| PRICE_MANAGE | ✅ | ◐ | ❌ | ❌ | ❌ | ❌ |
| EMPLOYEE_MANAGE | ✅ | ✅ | ◐ | ❌ | ❌ | ❌ |
| SCHEDULE_MANAGE_ALL | ✅ | ✅ | ✅ sucursal | ◐ | ❌ | ❌ |
| SCHEDULE_MANAGE_OWN | ✅ | ✅ | ✅ | ◐ | ✅ | ❌ |
| MEDIA_MANAGE | ✅ | ✅ | ◐ | ◐ | ◐ | ❌ |
| WEBSITE_MANAGE | ✅ | ✅ | ◐ | ❌ | ❌ | ❌ |
| REPORT_VIEW | ✅ | ✅ | ◐ | ❌ | ❌ | ✅ |
| LEGAL_MANAGE | ✅ | ◐ | ❌ | ❌ | ❌ | ❌ |
| SMTP_MANAGE | ✅ | ◐ | ❌ | ❌ | ❌ | ❌ |
| USER_ROLE_MANAGE | ✅ | ◐ | ❌ | ❌ | ❌ | ❌ |
| AUDIT_VIEW | ✅ | ◐ | ❌ | ❌ | ❌ | ❌ |

El backend debe evaluar además el scope de sucursal y tenant.
