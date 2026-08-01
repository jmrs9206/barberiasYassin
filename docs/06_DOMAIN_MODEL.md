# Modelo de dominio

## Agregados principales

### Company

- identidad;
- nombre comercial;
- slug;
- estado;
- locale;
- moneda;
- zona horaria por defecto;
- configuración de marca;
- configuración de módulos;
- plan comercial;
- fechas de alta/suspensión.

### Branch

- empresa;
- nombre;
- dirección;
- coordenadas opcionales;
- teléfono/correo opcional;
- zona horaria;
- horario de apertura;
- política de reservas;
- estado.

### User y Membership

- identidad global;
- credenciales;
- estado;
- MFA;
- memberships por empresa;
- rol y permisos;
- sucursales asignadas.

### Employee

- empresa;
- perfil público;
- usuario opcional;
- sucursales;
- servicios habilitados;
- agenda;
- excepciones;
- estado.

### Customer

- empresa;
- nombre;
- email;
- teléfono;
- preferencias;
- notas restringidas;
- consentimientos;
- historial;
- estado y bloqueo de reservas.

### Service y AddOn

- empresa;
- nombre;
- descripción;
- categoría;
- precio base;
- duración;
- tiempo de preparación/limpieza;
- disponibilidad por sucursal;
- disponibilidad por trabajador;
- visibilidad pública;
- historial de precio.

### Appointment

- empresa y sucursal;
- cliente;
- trabajador;
- estado;
- inicio y fin;
- fuente;
- snapshots;
- extras;
- importes;
- método de pago presencial;
- política aplicada;
- timestamps;
- historial de estado.

### Notification

- evento;
- destinatario;
- plantilla;
- tenant;
- estado;
- reintentos;
- proveedor;
- error sanitizado;
- fecha programada y enviada.

### MediaAsset

- propietario lógico;
- clave de almacenamiento;
- tipo;
- tamaño;
- dimensiones;
- variantes;
- visibilidad;
- estado;
- metadatos.

### LegalDocumentVersion y Consent

- tipo de documento;
- versión;
- contenido;
- vigencia;
- idioma;
- hash;
- sujeto;
- finalidad;
- fecha;
- origen.

## Invariantes

- Una cita pertenece a una sucursal y empresa coherentes.
- El trabajador debe estar activo en la sucursal.
- El servicio debe estar disponible para esa sucursal y trabajador.
- No hay solapamiento de citas activas para un trabajador.
- Un extra no puede pertenecer a otra empresa.
- El precio reservado no cambia al editar el catálogo.
- La cancelación sigue la política que estaba vigente o la política capturada.
- Un registro soft-deleted no aparece en flujos activos.
