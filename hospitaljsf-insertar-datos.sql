-- Insertar datos en la tabla PROVINCIA (provincias de Lima, Perú)
INSERT INTO PROVINCIA (idProvincia, descProvincia, fechaRegistro)
VALUES (1, 'Lima', SYSDATE);

INSERT INTO PROVINCIA (idProvincia, descProvincia, fechaRegistro)
VALUES (2, 'Barranca', SYSDATE);

INSERT INTO PROVINCIA (idProvincia, descProvincia, fechaRegistro)
VALUES (3, 'Cajatambo', SYSDATE);

INSERT INTO PROVINCIA (idProvincia, descProvincia, fechaRegistro)
VALUES (4, 'Huaral', SYSDATE);

INSERT INTO PROVINCIA (idProvincia, descProvincia, fechaRegistro)
VALUES (5, 'Cañete', SYSDATE);

-- Insertar datos en la tabla DISTRITO (distritos de Lima, Perú)
INSERT INTO DISTRITO (idDistrito, idProvincia, descDistrito, fechaRegistro)
VALUES (1, 1, 'Miraflores', SYSDATE);

INSERT INTO DISTRITO (idDistrito, idProvincia, descDistrito, fechaRegistro)
VALUES (2, 1, 'San Isidro', SYSDATE);

INSERT INTO DISTRITO (idDistrito, idProvincia, descDistrito, fechaRegistro)
VALUES (3, 1, 'Barranco', SYSDATE);

INSERT INTO DISTRITO (idDistrito, idProvincia, descDistrito, fechaRegistro)
VALUES (4, 2, 'Huacho', SYSDATE);

INSERT INTO DISTRITO (idDistrito, idProvincia, descDistrito, fechaRegistro)
VALUES (5, 2, 'Barranca', SYSDATE);

-- Insertar datos en la tabla GERENTE (nombres y apellidos ficticios)
INSERT INTO GERENTE (idGerente, desGerente, fechaRegistro)
VALUES (1, 'Juan Pérez', SYSDATE);

INSERT INTO GERENTE (idGerente, desGerente, fechaRegistro)
VALUES (2, 'María Gómez', SYSDATE);

INSERT INTO GERENTE (idGerente, desGerente, fechaRegistro)
VALUES (3, 'Carlos Rodríguez', SYSDATE);

INSERT INTO GERENTE (idGerente, desGerente, fechaRegistro)
VALUES (4, 'Laura Ramírez', SYSDATE);

INSERT INTO GERENTE (idGerente, desGerente, fechaRegistro)
VALUES (5, 'Javier Torres', SYSDATE);

-- Insertar datos en la tabla SEDE (tipos de sedes)
INSERT INTO SEDE (idSede, descSede, fechaRegistro)
VALUES (1, 'Principal', SYSDATE);

INSERT INTO SEDE (idSede, descSede, fechaRegistro)
VALUES (2, 'Secundaria', SYSDATE);

INSERT INTO SEDE (idSede, descSede, fechaRegistro)
VALUES (3, 'Ventas', SYSDATE);

INSERT INTO SEDE (idSede, descSede, fechaRegistro)
VALUES (4, 'Administración', SYSDATE);

INSERT INTO SEDE (idSede, descSede, fechaRegistro)
VALUES (5, 'Investigación', SYSDATE);

-- Insertar datos en la tabla CONDICION
INSERT INTO CONDICION (idCondicion, descCondicion, fechaRegistro)
VALUES (6, 'Operativo', SYSDATE);

INSERT INTO CONDICION (idCondicion, descCondicion, fechaRegistro)
VALUES (7, 'Clausurado', SYSDATE);

INSERT INTO CONDICION (idCondicion, descCondicion, fechaRegistro)
VALUES (8, 'En Mantenimiento', SYSDATE);

INSERT INTO CONDICION (idCondicion, descCondicion, fechaRegistro)
VALUES (9, 'En Reparación', SYSDATE);

INSERT INTO CONDICION (idCondicion, descCondicion, fechaRegistro)
VALUES (10, 'Sin Suministros', SYSDATE);

-- Insertar Datos en la tabla HOSPITAL

INSERT INTO HOSPITAL (IDHOSPITAL, NOMBRE, ANTIGUEDAD, AREA, IDSEDE, IDGERENTE, IDCONDICION, IDDISTRITO, FECHAREGISTRO)
VALUES (1, 'Hospital Las Flores', 10, 500.00, 1, 1, 1, 1, SYSDATE);

INSERT INTO HOSPITAL (IDHOSPITAL, NOMBRE, ANTIGUEDAD, AREA, IDSEDE, IDGERENTE, IDCONDICION, IDDISTRITO, FECHAREGISTRO)
VALUES (2, 'Hospital 2 de Julio', 5, 800.00, 2, 2, 2, 2, SYSDATE);

INSERT INTO HOSPITAL (IDHOSPITAL, NOMBRE, ANTIGUEDAD, AREA, IDSEDE, IDGERENTE, IDCONDICION, IDDISTRITO, FECHAREGISTRO)
VALUES (3, 'Hospital 8 de Mayo', 3, 600.00, 3, 3, 3, 3, SYSDATE);

INSERT INTO HOSPITAL (IDHOSPITAL, NOMBRE, ANTIGUEDAD, AREA, IDSEDE, IDGERENTE, IDCONDICION, IDDISTRITO, FECHAREGISTRO)
VALUES (4, 'Hospital Hernandez', 7, 700.00, 4, 4, 4, 4, SYSDATE);

INSERT INTO HOSPITAL (IDHOSPITAL, NOMBRE, ANTIGUEDAD, AREA, IDSEDE, IDGERENTE, IDCONDICION, IDDISTRITO, FECHAREGISTRO)
VALUES (5, 'Hospital Central UM', 2, 400.00, 5, 5, 5, 5, SYSDATE);

