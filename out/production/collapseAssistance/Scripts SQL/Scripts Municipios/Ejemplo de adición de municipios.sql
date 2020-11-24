USE CollapseAssistance;

--Insertar estado en tablas de estado (Sin este no prodrá hacer el registro en la tabla de municipios. Ejecutar una vez)
INSERT INTO Estados_Pais (ID_Estado, Nombre_Estado) VALUES(32, "Zacatecas");

--En los ID tanto de estados como de municpios si el numero no tiene 4 digitos para municipios o 2 digitos para estados se de acompletar con ceros a la izquierda
INSERT INTO Municipios_Estados (ID_Municipios, Nombre_Municipio, ID_Estado) VALUES
                                                                                    (2417, "Apozol", 32),
                                                                                    (2418, "Apulco", 32),
                                                                                    (2419, "Atolinga", 32);

SELECT * FROM Municipios_Estados;
