USE DBREGASI;
SHOW TABLES FROM DBREGASI;

DELIMITER ||

DROP PROCEDURE IF EXISTS Meter_Empleado ||

CREATE PROCEDURE Meter_Empleado(clave char(6), nombre varchar(35), aparterno varchar(35), amaterno varchar(35), curp char(18), fcontratacion date, calle varchar(35), numext varchar(15), numint varchar(15), colonia varchar(50), codigopostal varchar(5), id_estado numeric (2), id_municipio numeric(4), status enum('A', 'I'))
BEGIN

INSERT INTO DDATEMP (CCVEEMP, CNOMBRE, CAPEUNO, CAPEDOS, CCURPEM, DFECING, CNMCALL, CNUMEXT, CNUMINT, CCOLONI, CCODPOS, NIDESTA, NIDMUNI, CSTATUS) VALUES (@clave, @nombre, @apaterno, @amaterno, @curp, @fcontratacion, @calle, @numext, @numint, @colonia, @codigopostal, @id_estado, @id_municipio, @status);

END
||

SHOW CREATE PROCEDURE Meter_Empleado;
