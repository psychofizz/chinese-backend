

CREATE TABLE tipos_empleados (
  id INT PRIMARY KEY,
  tipo_empleado VARCHAR(50)
);

CREATE TABLE estados_mesa (
  id INT PRIMARY KEY,
  estado VARCHAR(50)
);

CREATE TABLE mesas (
  id INT PRIMARY KEY,
  capacidad INT,
  id_estado_mesa INT REFERENCES estados_mesa(id)
);

CREATE TABLE estados_orden (
  id INT PRIMARY KEY,
  estado VARCHAR(50)
);

CREATE TABLE ordenes (
  id INT PRIMARY KEY,
  fecha_creada DATE,
  id_cliente INT REFERENCES clientes(id),
  id_chef INT REFERENCES empleados(id),
  id_mesero INT REFERENCES empleados(id),
  id_mesa INT REFERENCES mesas(id),
  id_estado_orden INT REFERENCES estados_orden(id)
);

CREATE TABLE menus (
  id INT PRIMARY KEY,
  nombre VARCHAR(100),
  precio DECIMAL(10, 2)
);

CREATE TABLE ingredientes (
  id INT PRIMARY KEY,
  nombre VARCHAR(100),
  stock INT
);

CREATE TABLE menu_ingredientes (
  id INT PRIMARY KEY,
  id_menu INT REFERENCES menus(id),
  id_ingrediente INT REFERENCES ingredientes(id),
  cantidad INT
);

CREATE TABLE contenido_orden (
  id INT PRIMARY KEY,
  id_orden INT,
  id_menu INT,
  cantidad INT
);

CREATE TABLE facturas (
  id INT PRIMARY KEY, 
  fecha_emitida DATE,
  isv DECIMAL(10, 3),
  sub_total DECIMAL(10, 3),
  total DECIMAL(10, 3),
  id_cliente INT REFERENCES clientes(id),
  id_orden INT REFERENCES ordenes(id)
);

INSERT INTO tipos_empleados (id, tipo_empleado)
VALUES
  (1, 'Chef'),
  (2, 'Mesero'),
  (3, 'Admin');

INSERT INTO estados_mesa (id, estado)
VALUES
  (1, 'Disponible'),
  (2, 'Ocupada'),
  (3, 'Reservada'),
  (4, 'NoDisponible');

INSERT INTO estados_orden (id, estado)
VALUES 
  (1, 'Recibida'),
  (2, 'En Curso'),
  (3, 'Entregable'),
  (4, 'Entregado'),
  (5, 'Pagado');
