import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BD_Inserciones {


    public String insertEmpleado(String claveE, String nombreE, String apellidoP, String apellidoM, String curpE, String fecha, String calle, String nExterior, String nInterior, String colonia, String cp, String idEstados, String idMunicipios, String Status){
        String sql = "INSERT INTO Empleados (Clave_Empleado,Nombre_Empleado,Apellido_Paterno_Empleado,Apellido_Materno_Empleado,CURP_Empleado,"
                + "Fecha_Contratacion,Direccion_Calle,Direccion_No_Exterior,Direccion_No_Interior,Direccion_Colonia,Direccion_Codigo_Postal,"
                + "ID_Estado,ID_Municipios,Status_Empleado) VALUES (" + claveE + ",'" + nombreE +"','" + apellidoP +"','" + apellidoM + "','" + curpE +"','" + fecha + "','" + calle +"'," + nExterior +","+ nInterior +",'" + colonia +"'," + cp + "," + idEstados +"," + idMunicipios +",'" + Status + "')";
        return sql;
    }
    public boolean hacerInsercionEmpleado(Connection conn, String claveE, String nombreE, String apellidoP, String apellidoM, String curpE, String fecha, String calle, String nExterior, String nInterior, String colonia, String cp, String idEstados, String idMunicipios, String Status){
        try{
            PreparedStatement stmt = conn.prepareStatement(insertEmpleado(claveE,nombreE,apellidoP, apellidoM,curpE,fecha,calle,nExterior,nInterior, colonia, cp, idEstados, idMunicipios, Status));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }

    //____________________________________________________________________________________________________________________________________________
    public String insertHorariosEmpleado(String IdHorario, String clave, String fecha){
        String sql = "INSERT INTO Horario_Empleados (ID_Horario,Clave_Empleado,Fecha_Asignacion_Horario) VALUES (" + IdHorario + ", '" + clave +"' , '" + fecha +"')";

        return sql;
    }
    public boolean hacerInsercionHorariosEmpleado(Connection conn, String IdHorario, String clave, String fecha){
        try{
            PreparedStatement stmt = conn.prepareStatement(insertHorariosEmpleado(IdHorario, clave, fecha));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }
    //____________________________________________________________________________________________________________________________________________

    public String insertJustificanteEmpleados(String ClaveE, String fecha, String tipoJustificante, String StatusJustificante){
        String sql = "INSERT INTO Justificantes_Empleados (Clave_Empleado,Fecha_Incidencia,ID_Tipo_Justificante,Status_Justificante) VALUES ('" + ClaveE+ "', '" + fecha + "' , " + tipoJustificante +", '" + StatusJustificante +"')";
        return sql;
    }
    public boolean hacerInsercionJustificantesEmpleados(Connection conn, String ClaveE, String fecha, String tipoJustificante, String StatusJustificante){
        try{
            PreparedStatement stmt = conn.prepareStatement(insertJustificanteEmpleados(ClaveE, fecha, tipoJustificante, StatusJustificante));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }
    //____________________________________________________________________________________________________________________________________________


    public String insertRegistrosAsistencia(String ClaveR, String fecha, String biometrico, String StatusRegistro){
        String sql = "INSERT INTO Registro_Asistencias (Clave_Empleado,Fecha_Registro,Numero_Dispositivo_Biometrico,Status_Registro) VALUES ('" + ClaveR+ "', '" + fecha + "' ," + biometrico + ",'" + StatusRegistro +"')";
        return sql;
    }
    public boolean hacerInsercionRegistroAsistencia(Connection conn, String ClaveR, String fecha, String biometrico, String StatusRegistro){
        try{
            PreparedStatement stmt = conn.prepareStatement(insertRegistrosAsistencia(ClaveR, fecha, biometrico, StatusRegistro));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }
    //____________________________________________________________________________________________________________________________________________
    public String insertIncidenciasEmpleado(String ClaveI, String fecha, String tipo, String StatusIncidencia){
        String sql = "INSERT INTO Incidencias_Empleados (Clave_Empleado,Fecha_Incidencia,Tipo_Incidencia,Status_Incidencia) VALUES ('" + ClaveI + "', '" + fecha + "' ,'" + tipo + "','" + StatusIncidencia + "')";
        return sql;
    }
    public boolean hacerIncercionesIEmpleado(Connection conn, String ClaveI, String fecha, String tipo, String StatusIncidencia){
        try{
            PreparedStatement stmt = conn.prepareStatement(insertIncidenciasEmpleado(ClaveI, fecha, tipo, StatusIncidencia));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }
    //____________________________________________________________________________________________________________________________________________
    public String insertDiasNoLaborable(String fecha, String motivo, String statusFecha){
        String sql = "INSERT INTO Dias_No_Laborales (Fecha,Motivo,Status_Fecha_No_Laboral) VALUES ('" + fecha + "','" + motivo + "','" + statusFecha + "')";
        return sql;
    }
    public boolean hacerIncercionesDiasNoLaborables(Connection conn, String fecha, String motivo, String StatusFecha){
        try{
            PreparedStatement stmt = conn.prepareStatement(insertDiasNoLaborable(fecha, motivo, StatusFecha));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }
//____________________________________________________________________________________________________________________________________________
    public String insertHorario(String IDhorario, String descripcion, String horario){
        String sql = "INSERT INTO Horarios (ID_Horario,Descripcion_Horario,Status_Horario) VALUES (" + IDhorario + ",'" + descripcion +"','" + horario +"')";
        return sql;
    }
    public boolean hacerIncercionesCatalogoHorarios(Connection conn, String IDhorario, String descripcion, String horario){
        try{
            PreparedStatement stmt = conn.prepareStatement(insertHorario(IDhorario, descripcion, horario));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }


}
