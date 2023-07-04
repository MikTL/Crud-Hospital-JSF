-- Creación de la tabla PROVINCIA
CREATE TABLE PROVINCIA (
  idProvincia INT PRIMARY KEY,
  descProvincia VARCHAR2(250),
  fechaRegistro DATE
);

-- Creación de la tabla DISTRITO
CREATE TABLE DISTRITO (
  idDistrito INT PRIMARY KEY,
  idProvincia INT,
  descDistrito VARCHAR2(250),
  fechaRegistro DATE,
  FOREIGN KEY (idProvincia) REFERENCES PROVINCIA(idProvincia)
);

-- Creación de la tabla CONDICION
CREATE TABLE CONDICION (
  idCondicion INT PRIMARY KEY,
  descCondicion VARCHAR2(250),
  fechaRegistro DATE
);

-- Creación de la tabla GERENTE
CREATE TABLE GERENTE (
  idGerente INT PRIMARY KEY,
  desGerente VARCHAR2(250),
  fechaRegistro DATE
);

-- Creación de la tabla SEDE
CREATE TABLE SEDE (
  idSede INT PRIMARY KEY,
  descSede VARCHAR2(250),
  fechaRegistro DATE
);

-- Creación de la tabla HOSPITAL
CREATE TABLE HOSPITAL (
  idHospital INT PRIMARY KEY,
  Nombre VARCHAR2(250),
  Antiguedad INT,
  Area DECIMAL(5,2),
  idSede INT,
  idGerente INT,
  idCondicion INT,
  idDistrito INT,
  fechaRegistro DATE,
  FOREIGN KEY (idSede) REFERENCES SEDE(idSede),
  FOREIGN KEY (idGerente) REFERENCES GERENTE(idGerente),
  FOREIGN KEY (idCondicion) REFERENCES CONDICION(idCondicion),
  FOREIGN KEY (idDistrito) REFERENCES DISTRITO(idDistrito)
);