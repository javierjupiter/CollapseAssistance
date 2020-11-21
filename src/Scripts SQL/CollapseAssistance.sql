DROP DATABASE IF EXISTS CollapseAssistance;
CREATE SCHEMA IF NOT EXISTS CollapseAssistance;

USE CollapseAssistance;

--Creamos tabla CESTADS
CREATE TABLE Estados_Pais(
    ID_Estado NUMERIC(2) PRIMARY KEY,
    Nombre_Estado VARCHAR(25)
);

--Tabla CMUNICS
CREATE TABLE Municipios_Estados(
    ID_Municipios NUMERIC(4) PRIMARY KEY,
    Nombre_Municipio VARCHAR(50),
    ID_Estado NUMERIC(2),
    FOREIGN KEY (ID_Estado) REFERENCES Estados_Pais(ID_Estado)
);

--Tabla CHORARS
--A: Activo I: Inactivo
--Trigger por Mike
CREATE TABLE Horarios(
    ID_Horario NUMERIC(5) PRIMARY KEY,
    Descripcion_Horario VARCHAR(100),
    Status_Horario ENUM('A', 'I'),
    Inserto_Usuario CHAR(10),
    Fecha_Insercion DATE,
    Modifico_Usuario CHAR(10),
         DATE
);

--Tabla DDETHOR
--L: Lunes, M: Martes, W: Miercoles, J: Jueves, V: Viernes, S: Sabado, D: Domingo
--A: Activo I: Inactivo
--Trigger por Mike
CREATE TABLE Detalles_Horarios(
    ID_Horario NUMERIC(5),
    Dia_Semana ENUM('L', 'M', 'W', 'J', 'V', 'S', 'D'),
    Hora_Entrada TIME,
    Hora_Salida TIME,
    Status_Horario ENUM('A', 'I'),
    Inserto_Usuario CHAR(10),
    Fecha_Insercion DATE,
    Modifico_Usuario CHAR(10),
    Fecha_Modificacion DATE,
    PRIMARY KEY (ID_Horario, Dia_Semana),
    FOREIGN KEY (ID_Horario) REFERENCES Horarios(ID_Horario)
);

--Tabla MDIASNL
 --A: Activo I: Inactivo
 --Trigger por Ricardo
CREATE TABLE Dias_No_Laborales(
    Fecha DATE PRIMARY KEY,
    Motivo VARCHAR(150),
    Status_Fecha_No_Laboral ENUM('A', 'I'),
    Inserto_Usuario CHAR(10),
    Fecha_Insercion DATE,
    Modifico_Usuario CHAR(10),
    Fecha_Modificacion DATE
);

--Tabla DDATEMP
--A: Activo I: Inactivo
--Trigger por Ricardo
CREATE TABLE Empleados(
    Clave_Empleado CHAR(6) PRIMARY KEY,
    Nombre_Empleado VARCHAR(35) NOT NULL,
    Apellido_Paterno_Empleado VARCHAR(35),
    Apellido_Materno_Empleado VARCHAR(35),
    CURP_Empleado CHAR(18),
    Fecha_Contratacion DATE,
    Direccion_Calle VARCHAR(35),
    Direccion_No_Exterior VARCHAR(15),
    Direccion_No_Interior VARCHAR(15),
    Direccion_Colonia VARCHAR(50),
    Direccion_Codigo_Postal CHAR(5),
    ID_Estado NUMERIC(2),
    ID_Municipios NUMERIC(4),
    Status_Empleado ENUM('A', 'I'),
    Inserto_Usuario CHAR(10),
    Fecha_Insercion DATE,
    Modifico_Usuario CHAR(10),
    Fecha_Modificacion DATE,
    FOREIGN KEY (ID_Estado, ID_Municipios) REFERENCES Municipios_Estados(ID_Estado, ID_Municipios)
);

--Tabla DHREMPS
--Trigger por Vanessa
CREATE TABLE Horario_Empleados(
    ID_Horario NUMERIC(5),
    Clave_Empleado CHAR(6),
    Fecha_Asignacion_Horario DATE,
    Inserto_Usuario CHAR(10),
    Fecha_Insercion DATE,
    Modifico_Usuario CHAR(10),
    Fecha_Modificacion DATE,
    PRIMARY KEY (ID_Horario, Clave_Empleado),
    FOREIGN KEY (Clave_Empleado) REFERENCES Empleados(Clave_Empleado),
    FOREIGN KEY (ID_Horario) REFERENCES Horarios(ID_Horario)
);

--Tabla PREGASI
--R: Registrado, P: Procesado
--Trigger por Vanessa
CREATE TABLE Registro_Asistencias(
    Clave_Empleado CHAR(6),
    Fecha_Registro DATETIME,
    Numero_Dispositivo_Biometrico NUMERIC(2),
    Status_Registro ENUM('R', 'P'),
    Inserto_Usuario CHAR(10),
    Fecha_Insercion DATE,
    Modifico_Usuario CHAR(10),
    Fecha_Modificacion DATE,
    PRIMARY KEY (Clave_Empleado, Fecha_Registro),
    FOREIGN KEY (Clave_Empleado) REFERENCES Empleados(Clave_Empleado)
);

--Tabla TINCEMP
--R: Registrada, J: Justificada, A: Aplicada en nómina
--Trigger por Grisell
CREATE TABLE Incidencias_Empleados(
    Clave_Empleado CHAR(6),
    Fecha_Incidencia DATE,
    Tipo_Incidencia CHAR(1),
    Status_Incidencia ENUM('R', 'J', 'A'),
    Inserto_Usuario CHAR(10),
    Fecha_Insercion DATE,
    Modifico_Usuario CHAR(10),
    Fecha_Modificacion DATE,
    PRIMARY KEY (Clave_Empleado, Fecha_Incidencia, Tipo_Incidencia),
    FOREIGN KEY (Clave_Empleado) REFERENCES Empleados(Clave_Empleado)
);

--Tabla CJUSASI
--A: Activo I: Inactivo
--Trigger por Javier
CREATE TABLE Tipo_Justificante(
    ID_Tipo_Justificante NUMERIC(2) PRIMARY KEY,
    Descripcion_Justificante VARCHAR(100),
    Status_Tipo_Justificante ENUM('A', 'I'),
    Inserto_Usuario CHAR(10),
    Fecha_Insercion DATE,
    Modifico_Usuario CHAR(10),
    Fecha_Modificacion DATE
);

--Tabla PJUSASI
--A: Activo I: Inactivo
--Trigger por Javier
CREATE TABLE Justificantes_Empleados(
    Clave_Empleado CHAR(6),
    Fecha_Incidencia DATE,
    ID_Tipo_Justificante NUMERIC(2),
    Status_Justificante ENUM('A', 'I'),
    Inserto_Usuario CHAR(10),
    Fecha_Insercion DATE,
    Modifico_Usuario CHAR(10),
    Fecha_Modificacion DATE,
    PRIMARY KEY (Clave_Empleado, Fecha_Incidencia, ID_Tipo_Justificante),
    FOREIGN KEY (Clave_Empleado) REFERENCES Empleados(Clave_Empleado),
    FOREIGN KEY (Clave_Empleado, Fecha_Incidencia) REFERENCES Incidencias_Empleados(Clave_Empleado, Fecha_Incidencia)
);
