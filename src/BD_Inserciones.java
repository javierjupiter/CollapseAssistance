import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BD_Inserciones {
    //__________________YA__________________________________________________________________________________________________________
    public String insertJustificante(String IdTipoJustificante, String descripcion, String status){
        String sql = "INSERT INTO cjusasi (NIDTPJU, CDESJUS, CSTATUS) VALUES (" + IdTipoJustificante + ",'" + descripcion +"','" + status +"')";
        return sql;
    }
    public boolean hacerIncercionesJustificantes(Connection conn, String IdTipoJustificante, String descripcion, String status){
        try{
            PreparedStatement stmt = conn.prepareStatement(insertJustificante(IdTipoJustificante, descripcion, status));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }

    //_______________________________________YA_____________________________________________________________________________________________________
    public String insertEmpleado(String claveE, String nombreE, String apellidoP, String apellidoM, String curpE, String fecha, String calle, String nExterior, String nInterior, String colonia, String cp, String idEstados, String idMunicipios, String Status){
        String sql = "INSERT INTO ddatemp (CCVEEMP, CNOMBRE, CAPEUNO, CAPEDOS, CCURPEM, DFECING, CNMCALL, CNUMEXT, CNUMINT, CCOLONI, CCODPOS, NIDESTA, NIDMUNI, CSTATUS) VALUES (" + claveE + ",'" + nombreE +"','" + apellidoP +"','" + apellidoM + "','" + curpE +"','" + fecha + "','" + calle +"'," + nExterior +","+ nInterior +",'" + colonia +"'," + cp + "," + idEstados +"," + idMunicipios +",'" + Status + "')";
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

    //_______________________________________YA_____________________________________________________________________________________________________
    public String insertHorariosEmpleado(String IdHorario, String clave, String fecha){
        String sql = "INSERT INTO dhremps (NIDHORA, CCVEEMP, DFECAIS) VALUES (" + IdHorario + ", '" + clave +"' , '" + fecha +"')";

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
    //_____________YA_______________________________________________________________________________________________________________________________

    public String insertJustificanteEmpleados(String ClaveE, String fecha, String tipoJustificante, String StatusJustificante){
        String sql = "INSERT INTO pjusasi (CCVEEMP, DFECINC, NIDTPJU, CSTATUS) VALUES ('" + ClaveE+ "', '" + fecha + "' , " + tipoJustificante +", '" + StatusJustificante +"')";
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
    //____________________YA________________________________________________________________________________________________________________________


    public String insertRegistrosAsistencia(String ClaveR, String fecha, String biometrico, String StatusRegistro){
        String sql = "INSERT INTO pregasi(CCVEEMP,DFECREG,CNUMBIO,CSTATUS) ('" + ClaveR+ "', '" + fecha + "' ," + biometrico + ",'" + StatusRegistro +"')";
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
    //________________YA____________________________________________________________________________________________________________________________
    public String insertIncidenciasEmpleado(String ClaveI, String fecha, String tipo, String StatusIncidencia){
        String sql = "INSERT INTO tincemp(CCVEEMP, DFECINC, CTIPINC, CSTATUS) VALUES ('" + ClaveI + "', '" + fecha + "' ,'" + tipo + "','" + StatusIncidencia + "')";
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
    //_______________________YA_____________________________________________________________________________________________________________________
    public String insertDiasNoLaborable(String fecha, String motivo, String statusFecha){
        String sql = "INSERT INTO mdiasnl (DFECHNL, CMOTIVO, CSTATUS) VALUES ('" + fecha + "','" + motivo + "','" + statusFecha + "')";
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
//________________________________YA____________________________________________________________________________________________________________
    public String insertHorario(String IDhorario, String descripcion, String horario){
        String sql = "INSERT INTO chorars (NIDHORA, CDESCHR, CSTATUS) VALUES (" + IDhorario + ",'" + descripcion +"','" + horario +"')";
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
