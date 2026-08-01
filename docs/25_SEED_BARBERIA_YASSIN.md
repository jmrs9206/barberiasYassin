# Seed inicial: Barbería Yassin

## Datos confirmados

```yaml
company:
  name: "Barbería Yassin"
  slug: "barberia-yassin"
  locale: "es-ES"
  currency: "EUR"
  timezone: "Europe/Madrid"

branch:
  name: "Sucursal principal"
  address_line_1: "Calle de Alfredo Aleix, 25"
  address_line_2: "Local 9"
  postal_code: "28044"
  city: "Madrid"
  country_code: "ES"
  timezone: "Europe/Madrid"
```

## Datos pendientes

No inventar:

- CIF/NIF;
- razón social;
- teléfono;
- email;
- dominio;
- coordenadas;
- horario;
- trabajadores;
- servicios;
- precios;
- duración;
- logo;
- fotografías;
- redes;
- política de cancelación;
- textos legales.

## Seed

- idempotente;
- activable por variable;
- no crea datos ficticios en producción salvo confirmación;
- crea solo empresa y sucursal con datos confirmados;
- no crea una contraseña conocida;
- el superadmin se crea por bootstrap separado;
- los servicios demo solo en perfil de desarrollo.
