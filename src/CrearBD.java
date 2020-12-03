import java.sql.Connection;
import java.sql.Statement;

public class CrearBD {

    public boolean crearTodo(Connection connection){
        System.out.println("Creando todo");
        try {
            Statement s = connection.createStatement();
            int i = s.executeUpdate(crearSchema());
            System.out.println("Tablas listas" + i);
            i = s.executeUpdate(crearEstados());
            System.out.println(i);
            i = s.executeUpdate(crearMunicipios());
            System.out.println(i);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    private String crearSchema(){
        return "DROP DATABASE IF EXISTS CollapseAssistance;\n" +
                "CREATE DATABASE CollapseAssistance;\n" +
                "\n" +
                "USE CollapseAssistance;\n" +
                "\n" +
                "--Creamos tabla CESTADS\n" +
                "CREATE TABLE Estados_Pais(\n" +
                "    ID_Estado NUMERIC(2) PRIMARY KEY,\n" +
                "    Nombre_Estado VARCHAR(25)\n" +
                ");\n" +
                "\n" +
                "--Tabla CMUNICS\n" +
                "CREATE TABLE Municipios_Estados(\n" +
                "    ID_Municipios NUMERIC(4) PRIMARY KEY,\n" +
                "    Nombre_Municipio VARCHAR(50),\n" +
                "    ID_Estado NUMERIC(2),\n" +
                "    FOREIGN KEY (ID_Estado) REFERENCES Estados_Pais(ID_Estado)\n" +
                ");\n" +
                "\n" +
                "--Tabla CHORARS\n" +
                "--A: Activo I: Inactivo\n" +
                "--Trigger por Mike\n" +
                "CREATE TABLE Horarios(\n" +
                "    ID_Horario NUMERIC(5) PRIMARY KEY,\n" +
                "    Descripcion_Horario VARCHAR(100),\n" +
                "    Status_Horario ENUM('A', 'I'),\n" +
                "    Inserto_Usuario CHAR(10),\n" +
                "    Fecha_Insercion DATE,\n" +
                "    Modifico_Usuario CHAR(10),\n" +
                "         DATE\n" +
                ");\n" +
                "\n" +
                "--Tabla DDETHOR\n" +
                "--L: Lunes, M: Martes, W: Miercoles, J: Jueves, V: Viernes, S: Sabado, D: Domingo\n" +
                "--A: Activo I: Inactivo\n" +
                "--Trigger por Mike\n" +
                "CREATE TABLE Detalles_Horarios(\n" +
                "    ID_Horario NUMERIC(5),\n" +
                "    Dia_Semana ENUM('L', 'M', 'W', 'J', 'V', 'S', 'D'),\n" +
                "    Hora_Entrada TIME,\n" +
                "    Hora_Salida TIME,\n" +
                "    Status_Horario ENUM('A', 'I'),\n" +
                "    Inserto_Usuario CHAR(10),\n" +
                "    Fecha_Insercion DATE,\n" +
                "    Modifico_Usuario CHAR(10),\n" +
                "    Fecha_Modificacion DATE,\n" +
                "    PRIMARY KEY (ID_Horario, Dia_Semana),\n" +
                "    FOREIGN KEY (ID_Horario) REFERENCES Horarios(ID_Horario)\n" +
                ");\n" +
                "\n" +
                "--Tabla MDIASNL\n" +
                " --A: Activo I: Inactivo\n" +
                " --Trigger por Ricardo\n" +
                "CREATE TABLE Dias_No_Laborales(\n" +
                "    Fecha DATE PRIMARY KEY,\n" +
                "    Motivo VARCHAR(150),\n" +
                "    Status_Fecha_No_Laboral ENUM('A', 'I'),\n" +
                "    Inserto_Usuario CHAR(10),\n" +
                "    Fecha_Insercion DATE,\n" +
                "    Modifico_Usuario CHAR(10),\n" +
                "    Fecha_Modificacion DATE\n" +
                ");\n" +
                "\n" +
                "--Tabla DDATEMP\n" +
                "--A: Activo I: Inactivo\n" +
                "--Trigger por Ricardo\n" +
                "CREATE TABLE Empleados(\n" +
                "    Clave_Empleado CHAR(6) PRIMARY KEY,\n" +
                "    Nombre_Empleado VARCHAR(35) NOT NULL,\n" +
                "    Apellido_Paterno_Empleado VARCHAR(35),\n" +
                "    Apellido_Materno_Empleado VARCHAR(35),\n" +
                "    CURP_Empleado CHAR(18),\n" +
                "    Fecha_Contratacion DATE,\n" +
                "    Direccion_Calle VARCHAR(35),\n" +
                "    Direccion_No_Exterior VARCHAR(15),\n" +
                "    Direccion_No_Interior VARCHAR(15),\n" +
                "    Direccion_Colonia VARCHAR(50),\n" +
                "    Direccion_Codigo_Postal CHAR(5),\n" +
                "    ID_Estado NUMERIC(2),\n" +
                "    ID_Municipios NUMERIC(4),\n" +
                "    Status_Empleado ENUM('A', 'I'),\n" +
                "    Inserto_Usuario CHAR(10),\n" +
                "    Fecha_Insercion DATE,\n" +
                "    Modifico_Usuario CHAR(10),\n" +
                "    Fecha_Modificacion DATE,\n" +
                "    FOREIGN KEY (ID_Estado, ID_Municipios) REFERENCES Municipios_Estados(ID_Estado, ID_Municipios)\n" +
                ");\n" +
                "\n" +
                "--Tabla DHREMPS\n" +
                "--Trigger por Vanessa\n" +
                "CREATE TABLE Horario_Empleados(\n" +
                "    ID_Horario NUMERIC(5),\n" +
                "    Clave_Empleado CHAR(6),\n" +
                "    Fecha_Asignacion_Horario DATE,\n" +
                "    Inserto_Usuario CHAR(10),\n" +
                "    Fecha_Insercion DATE,\n" +
                "    Modifico_Usuario CHAR(10),\n" +
                "    Fecha_Modificacion DATE,\n" +
                "    PRIMARY KEY (ID_Horario, Clave_Empleado),\n" +
                "    FOREIGN KEY (Clave_Empleado) REFERENCES Empleados(Clave_Empleado),\n" +
                "    FOREIGN KEY (ID_Horario) REFERENCES Horarios(ID_Horario)\n" +
                ");\n" +
                "\n" +
                "--Tabla PREGASI\n" +
                "--R: Registrado, P: Procesado\n" +
                "--Trigger por Vanessa\n" +
                "CREATE TABLE Registro_Asistencias(\n" +
                "    Clave_Empleado CHAR(6),\n" +
                "    Fecha_Registro DATETIME,\n" +
                "    Numero_Dispositivo_Biometrico NUMERIC(2),\n" +
                "    Status_Registro ENUM('R', 'P'),\n" +
                "    Inserto_Usuario CHAR(10),\n" +
                "    Fecha_Insercion DATE,\n" +
                "    Modifico_Usuario CHAR(10),\n" +
                "    Fecha_Modificacion DATE,\n" +
                "    PRIMARY KEY (Clave_Empleado, Fecha_Registro),\n" +
                "    FOREIGN KEY (Clave_Empleado) REFERENCES Empleados(Clave_Empleado)\n" +
                ");\n" +
                "\n" +
                "--Tabla TINCEMP\n" +
                "--R: Registrada, J: Justificada, A: Aplicada en nómina\n" +
                "--Trigger por Grisell\n" +
                "CREATE TABLE Incidencias_Empleados(\n" +
                "    Clave_Empleado CHAR(6),\n" +
                "    Fecha_Incidencia DATE,\n" +
                "    Tipo_Incidencia CHAR(1),\n" +
                "    Status_Incidencia ENUM('R', 'J', 'A'),\n" +
                "    Inserto_Usuario CHAR(10),\n" +
                "    Fecha_Insercion DATE,\n" +
                "    Modifico_Usuario CHAR(10),\n" +
                "    Fecha_Modificacion DATE,\n" +
                "    PRIMARY KEY (Clave_Empleado, Fecha_Incidencia, Tipo_Incidencia),\n" +
                "    FOREIGN KEY (Clave_Empleado) REFERENCES Empleados(Clave_Empleado)\n" +
                ");\n" +
                "\n" +
                "--Tabla CJUSASI\n" +
                "--A: Activo I: Inactivo\n" +
                "--Trigger por Javier\n" +
                "CREATE TABLE Tipo_Justificante(\n" +
                "    ID_Tipo_Justificante NUMERIC(2) PRIMARY KEY,\n" +
                "    Descripcion_Justificante VARCHAR(100),\n" +
                "    Status_Tipo_Justificante ENUM('A', 'I'),\n" +
                "    Inserto_Usuario CHAR(10),\n" +
                "    Fecha_Insercion DATE,\n" +
                "    Modifico_Usuario CHAR(10),\n" +
                "    Fecha_Modificacion DATE\n" +
                ");\n" +
                "\n" +
                "--Tabla PJUSASI\n" +
                "--A: Activo I: Inactivo\n" +
                "--Trigger por Javier\n" +
                "CREATE TABLE Justificantes_Empleados(\n" +
                "    Clave_Empleado CHAR(6),\n" +
                "    Fecha_Incidencia DATE,\n" +
                "    ID_Tipo_Justificante NUMERIC(2),\n" +
                "    Status_Justificante ENUM('A', 'I'),\n" +
                "    Inserto_Usuario CHAR(10),\n" +
                "    Fecha_Insercion DATE,\n" +
                "    Modifico_Usuario CHAR(10),\n" +
                "    Fecha_Modificacion DATE,\n" +
                "    PRIMARY KEY (Clave_Empleado, Fecha_Incidencia, ID_Tipo_Justificante),\n" +
                "    FOREIGN KEY (Clave_Empleado) REFERENCES Empleados(Clave_Empleado),\n" +
                "    FOREIGN KEY (Clave_Empleado, Fecha_Incidencia) REFERENCES Incidencias_Empleados(Clave_Empleado, Fecha_Incidencia)\n" +
                ");\n";
    }

    public String crearEstados(){
        return "USE CollapseAssistance;\n" +
                "\n" +
                "--Insertar estado en tablas de estado (Sin este no prodrá hacer el registro en la tabla de municipios. Ejecutar una vez)\n" +
                "INSERT INTO Estados_Pais (ID_Estado, Nombre_Estado) VALUES (01, \"Aguascalientes\"),\n" +
                "                                                            (02, \"Baja California\"),\n" +
                "                                                            (03, \"Baja California Sur\"),\n" +
                "                                                            (04, \"Campeche\"),\n" +
                "                                                            (05, \"Cohuila\"),\n" +
                "                                                            (06, \"Colima\"),\n" +
                "                                                            (07, \"Chiapas\"),\n" +
                "                                                            (08, \"Chihuahua\"),\n" +
                "                                                            (09, \"Durango\"),\n" +
                "                                                            (10, \"CDMX\"),\n" +
                "                                                            (11, \"Guanajuato\"),\n" +
                "                                                            (12, \"Guerrero\"),\n" +
                "                                                            (13, \"Hidalgo\"),\n" +
                "                                                            (14, \"Jalisco\"),\n" +
                "                                                            (15, \"Estado de México\"),\n" +
                "                                                            (16, \"Michoacán\"),\n" +
                "                                                            (17, \"Morelos\"),\n" +
                "                                                            (18, \"Nayarit\"),\n" +
                "                                                            (19, \"Nuevo León\"),\n" +
                "                                                            (20, \"Oaxaca\"),\n" +
                "                                                            (21, \"Puebla\"),\n" +
                "                                                            (22, \"Querétaro\"),\n" +
                "                                                            (23, \"Quintana Roo\"),\n" +
                "                                                            (24, \"San Luis Potosí\"),\n" +
                "                                                            (25, \"Sinaloa\"),\n" +
                "                                                            (26, \"Sonora\"),\n" +
                "                                                            (27, \"Tabasco\"),\n" +
                "                                                            (28, \"Tamaulipas\"),\n" +
                "                                                            (29, \"Tlaxcala\"),\n" +
                "                                                            (30, \"Veracruz\"),\n" +
                "                                                            (31, \"Yucatán\"),\n" +
                "                                                            (32, \"Zacatecas\");";
    }

    public String crearMunicipios(){
        return "USE CollapseAssistance;\n" +
                "\n" +
                "--Insertar estado en tablas de estado (Sin este no prodrá hacer el registro en la tabla de municipios. Ejecutar una vez)\n" +
                "INSERT INTO Estados_Pais (ID_Estado, Nombre_Estado) VALUES (01, \"Aguascalientes\"),\n" +
                "                                                            (02, \"Baja California\"),\n" +
                "                                                            (03, \"Baja California Sur\"),\n" +
                "                                                            (04, \"Campeche\"),\n" +
                "                                                            (05, \"Cohuila\"),\n" +
                "                                                            (06, \"Colima\"),\n" +
                "                                                            (07, \"Chiapas\"),\n" +
                "                                                            (08, \"Chihuahua\"),\n" +
                "                                                            (09, \"Durango\"),\n" +
                "                                                            (10, \"CDMX\"),\n" +
                "                                                            (11, \"Guanajuato\"),\n" +
                "                                                            (12, \"Guerrero\"),\n" +
                "                                                            (13, \"Hidalgo\"),\n" +
                "                                                            (14, \"Jalisco\"),\n" +
                "                                                            (15, \"Estado de México\"),\n" +
                "                                                            (16, \"Michoacán\"),\n" +
                "                                                            (17, \"Morelos\"),\n" +
                "                                                            (18, \"Nayarit\"),\n" +
                "                                                            (19, \"Nuevo León\"),\n" +
                "                                                            (20, \"Oaxaca\"),\n" +
                "                                                            (21, \"Puebla\"),\n" +
                "                                                            (22, \"Querétaro\"),\n" +
                "                                                            (23, \"Quintana Roo\"),\n" +
                "                                                            (24, \"San Luis Potosí\"),\n" +
                "                                                            (25, \"Sinaloa\"),\n" +
                "                                                            (26, \"Sonora\"),\n" +
                "                                                            (27, \"Tabasco\"),\n" +
                "                                                            (28, \"Tamaulipas\"),\n" +
                "                                                            (29, \"Tlaxcala\"),\n" +
                "                                                            (30, \"Veracruz\"),\n" +
                "                                                            (31, \"Yucatán\"),\n" +
                "                                                            (32, \"Zacatecas\");";
    }
}
