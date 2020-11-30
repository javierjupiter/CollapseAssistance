public class BD_Inserciones {


    public String insertEmpleados(){
        String sql = "INSERT INTO Empleados (Clave_Empleado,Nombre_Empleado,Apellido_Paterno_Empleado,Apellido_Materno_Empleado,CURP_Empleado,"
                + "Fecha_Contratacion,Direccion_Calle,Direccion_No_Exterior,Direccion_No_Interior,Direccion_Colonia,Direccion_Codigo_Postal,"
                + "ID_Estado,ID_Municipios,Status_Empleado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return sql;
    }

    public String insertIncidenciasEmpleado(){
        String sql = "INSERT INTO Incidencias_Empleados (Clave_Empleado,Fecha_Incidencia,Tipo_Incidencia,Status_Incidencia) VALUES (?,?,?,?)";
        return sql;
    }

    public String insertDiasNoLaborable(){
        String sql = "INSERT INTO Dias_No_Laborales (Fecha,Motivo,Status_Fecha_No_Laboral) VALUES (?,?,?)";
        return sql;
    }

    public String insertHorario(){
        String sql = "INSERT INTO Horarios (ID_Horario,Descripcion_Horario,Status_Horario) VALUES (?,?,?)";
        return sql;
    }

    public String insertHorariosEmpleado(){
        String sql = "INSERT INTO Horario_Empleados (ID_Horario,Clave_Empleado,Fecha_Asignacion_Horario) VALUES (?,?,?)";
        return sql;
    }

    public String insertJustificanteEmpleados(){
        String sql = "INSERT INTO Justificantes_Empleados (Clave_Empleado,Fecha_Incidencia,ID_Tipo_Justificante,Status_Justificante) VALUES (?,?,?,?)";
        return sql;
    }
    public String insertRegistrosAsistencia(){
        String sql = "INSERT INTO Registro_Asistencias (Clave_Empleado,Fecha_Registro,Numero_Dispositivo_Biometrico,Status_Registro) VALUES (?,?,?,?)";
        return sql;
    }

}
