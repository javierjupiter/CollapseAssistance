import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BD_Actualizaciones {
     public Boolean actualizarJustificantes (Connection conn, String idJustificante, String descripcionJustificante, String estatus){
         try {
             Statement stmt = conn.createStatement();
             stmt.executeUpdate(generarQueryJustificantes(idJustificante,descripcionJustificante,estatus));
             return true;
         }
         catch (SQLException e){
             System.out.println(e);
             return false;
         }
     }
     public String generarQueryJustificantes (String idJustificante, String descripcionJustificante, String estatus){
         String sql = "UPDATE cjusasi SET CDESJUS = '" + descripcionJustificante + "', CSTATUS = '" + estatus + "' WHERE NIDTPJU = '" + idJustificante + "' ";
         return sql;
     }


    public Boolean actualizarHorarios (Connection conn, String idHorario, String descripcionHorario,  String diaSemana,String horaEntrada, String horaSalida, String estatus){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(generarQueryHorariosDetalle(idHorario, diaSemana,horaEntrada,horaSalida,estatus));
            stmt.executeUpdate(generarQueryHorarios(idHorario,descripcionHorario,estatus));
            return true;
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }

    public String generarQueryHorariosDetalle ( String idHorario, String diaSemana, String horaEntrada, String horaSalida, String estatus){
       String sql = "UPDATE ddethor SET NDIASEM = '" + diaSemana + "', CHORENT = '" + horaEntrada + "', CHORSAL = '"+ horaSalida +"', CSTATUS ='" + estatus +"'   WHERE NIDHORA = '" + idHorario + "' ";
        return sql;
        }

    public String generarQueryHorarios ( String idhorario, String descripcionHorario, String estatus){
        String sql = "UPDATE chorars SET DDCDESCHR  = '" + descripcionHorario +  "', CSTATUS = '" + estatus +"' WHERE NIDHORA = '" + idhorario +  "'  ";
        return sql;
    }

    public Boolean actualizarDiasNoLaborales (Connection conn, String fecha, String motivo,  String estatus){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(generarQueryDiasNoLaborales(fecha,motivo,estatus));
            return true;
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }
    public String generarQueryDiasNoLaborales (String fecha, String motivo,  String estatus ){
        String sql = "UPDATE mdiasnl SET  CMOTIVO = '" + motivo + "' CSTATUS = '"+ estatus+ "'  WHERE DFECHNL = '" + fecha + "' ";
        return sql;
    }

    public Boolean actualizarRegistroIncidencias (Connection conn, String claveEmpleado, String fechaRegistro,  String noDispositivoBiometrico, String estatusRegistro, String gato){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(generarQueryRegistroIncidencias(claveEmpleado, fechaRegistro , noDispositivoBiometrico, estatusRegistro));
            return true;
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }
    public String generarQueryRegistroIncidencias(String claveEmpleado, String fechaRegistro,  String noDispositivoBiometrico, String estatusRegistro){
    String sql = "UPDATE TINCEMP SET   DFECINC= '" + fechaRegistro + "' CTIPINC = '"+ noDispositivoBiometrico+ "' CSTATUS = '" + estatusRegistro +"' WHERE CCVEEMP = '" + claveEmpleado + "' ";
        return sql;
    }


    public Boolean actualizarRegistroEmpleados (Connection conn,String idEmpleado, String nombre, String apellidoPaterno,  String apellidoMaterno, String curp, String fechaIngreso, String calle, String numeroExt ,String numerInt, String codigoPostal, String colonia, String estado, String municipioAlcaldia){
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(generarQueryRegistroEmpleados(idEmpleado,nombre, apellidoPaterno, apellidoPaterno, curp, fechaIngreso, calle, numeroExt, numerInt, codigoPostal, colonia, estado, municipioAlcaldia));
            return true;
        }
        catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }
    public String generarQueryRegistroEmpleados( String idEmpleado,String nombre, String apellidoPaterno,  String apellidoMaterno, String curp, String fechaIngreso, String calle, String numeroExt ,String numerInt, String codigoPostal, String colonia, String estado, String municipioAlcaldia){
        String sql = "UPDATE DDATEMP SET CNOMBRE  = '" + nombre + "' CAPEUNO = '"+ apellidoPaterno+ "' CAPEDOS = '" + apellidoMaterno + "'CCURPEM = '" + curp + "' DFECING = '" + fechaIngreso+ "' CNMCALL ='" +calle+ "' CNUMEXT = '" + numeroExt + "' CNUMINT = '" + numerInt + "' CCODPOS = '" + codigoPostal + "' CCOLONI ='"  + colonia + "' NIDESTE = '" +estado+ "' NIDMUNI = '" + municipioAlcaldia + "' WHERE CCVEEMP = '" + idEmpleado + "' ' ";
        return sql;
    }
}

