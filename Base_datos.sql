CREATE TABLE personas (
  id integer PRIMARY KEY,
  nombre nvarchar(255),
  apellido nvarchar(255),
  correo nvarchar(255),
  contrasenia nvarchar(255)
);


CREATE TABLE clientes (
  id integer PRIMARY KEY REFERENCES personas(id),
  cliente_preferencial bit
);


CREATE TABLE tipo_empleados (
  id integer PRIMARY KEY,
  tipo_empleado nvarchar(255),
  salario integer
);


CREATE TABLE empleados (
  id integer PRIMARY KEY REFERENCES personas(id),
  tipo_empleado integer REFERENCES tipo_empleados(id)
);


CREATE TABLE estados_mesa (
  id integer PRIMARY KEY,
  estado_mesa nvarchar(255)
);


CREATE TABLE mesas (
  id integer PRIMARY KEY,
  capacidad integer,
  ubicacion nvarchar(255),
  id_estado_mesa integer REFERENCES estados_mesas(id)
);


CREATE TABLE estados_orden(
  id integer PRIMARY KEY,
  estado_orden nvarchar(255)
);


CREATE TABLE ordenes (
  id integer PRIMARY KEY,
  id_cliente integer,
  id_chef integer,
  id_mesero integer,
  id_mesa integer
);


CREATE TABLE menus (
  id integer PRIMARY KEY,
  nombre nvarchar(255),
  precio decimal
);

CREATE TABLE ingredientes (
  id integer PRIMARY KEY,
  nombre nvarchar(255),
  stock integer
);


CREATE TABLE menu_ingredientes (
  id integer PRIMARY KEY,
  id_menu integer,
  id_ingrediente integer,
  cantidad integer
);


CREATE TABLE contenido_orden (
  id integer PRIMARY KEY,
  id_orden integer,
  id_menu integer,
  cantidad integer
);
