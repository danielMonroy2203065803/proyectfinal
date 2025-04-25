-- Insertar productos
INSERT INTO producto (id, nombre, descripcion, precio, stock) VALUES
                                                                  (1, 'Laptop HP', '16GB RAM, SSD 512GB', 1200.99, 10),
                                                                  (2, 'Teclado mecánico', 'Switch Red RGB', 89.50, 15),
                                                                  (3, 'Mouse inalámbrico', '2400 DPI', 25.30, 20);

-- Insertar facturas (si ya tienes las entidades)
INSERT INTO factura (id, cliente, fecha, total) VALUES
    (1, 'Juan Pérez', '2024-01-15', 1310.29);

-- Items de factura (relación muchos-a-uno)
INSERT INTO item_factura (id, cantidad, precio_unitario, producto_id, factura_id) VALUES
                                                                                      (1, 1, 1200.99, 1, 1),
                                                                                      (2, 1, 89.50, 2, 1),
                                                                                      (3, 2, 25.30, 3, 1);