-- Creación de la tabla cliente
CREATE TABLE Cliente (
    documento BIGINT PRIMARY KEY,
    tipoDocumento VARCHAR(50) NOT NULL,
    nombreCompleto VARCHAR(100) NOT NULL,
    fechaNacimiento DATE NOT NULL
);

-- Inserts de prueba
INSERT INTO Cliente (documento, tipoDocumento, nombreCompleto, fechaNacimiento)
VALUES
(123456789, 'DNI', 'Juan Pérez', '1990-05-15'),
(987654321, 'Pasaporte', 'María González', '1985-12-10'),
(456789123, 'Carné de identidad', 'Pedro Rodriguez', '1988-08-25');
