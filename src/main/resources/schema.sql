
-- Creación de la tabla cliente
CREATE TABLE Cliente (
    documento BIGINT PRIMARY KEY,
    tipo_documento VARCHAR(50) NOT NULL,
    nombre_completo VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL
);

-- Inserts de prueba
INSERT INTO Cliente (documento, tipo_documento, nombre_completo, fecha_nacimiento)
VALUES
(123456789, 'CEDULA', 'Juan Pérez', '1990-05-15'),
(987654321, 'PASAPORT', 'María González', '1985-12-10'),
(456789123, 'CEDULA', 'Pedro Rodriguez', '1988-08-25');
