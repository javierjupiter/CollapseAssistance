import java.sql.Connection;
import java.sql.PreparedStatement;
public class BD_Eliminar {
    //Registro de justificantes---------ya---------------------------------------------------------------
    public String deleteJustificantes(String IdTipoJustificante){
        String sql = "DELETE FROM cjusasi WHERE NIDTPJU = " + IdTipoJustificante;
        return sql;
    }
    public boolean EliminarJustificantes(Connection conn, String IdTipoJustificante){
        try{
            PreparedStatement stmt = conn.prepareStatement(deleteJustificantes(IdTipoJustificante));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }

    //HORARIOS----------------ya---------------------------------------------------
    public String deleteHorarios(String IdHorario){
        String sql = "DELETE FROM chorars WHERE NIDHORA = " + IdHorario;
        return sql;
    }
    public boolean EliminarHorarios(Connection conn, String IdHorario){
        try{
            PreparedStatement stmt = conn.prepareStatement(deleteHorarios(IdHorario));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }


    //DIAS NO LABORABLES----------YA---------------------------------------------------------
    public String deleteDiasNoLaboralbles(String FechaNoLaborable){
        String sql = "DELETE FROM mdiasnl WHERE DFECHNL = " + FechaNoLaborable;
        return sql;
    }
    public boolean deleteDiasNoLaboralbles(Connection conn, String FechaNoLaborable){
        try{
            PreparedStatement stmt = conn.prepareStatement(deleteDiasNoLaboralbles(FechaNoLaborable));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }


    //Empleados-----------YA--------------------------------------------------------
    public String deleteEmpleados(String IdEmpleado){
        String sql = "DELETE FROM ddatemp WHERE CCVEEMP = " + IdEmpleado;
        return sql;
    }
    public boolean deleteEmpleados(Connection conn, String IdEmpleado){
        try{
            PreparedStatement stmt = conn.prepareStatement(deleteEmpleados(IdEmpleado));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }



    //Horarios Empleados-----------YA--------------------------------------------------------
    //eliminar por la clave empleado
    public String deleteHorariosEmpleadosClaveEmpleado(String IdEmpleado){
        String sql = "DELETE FROM dhremps WHERE CCVEEMP = " + IdEmpleado;
        return sql;
    }
    public boolean deleteHorariosEmpleadosClaveEmpleado(Connection conn, String IdEmpleado){
        try{
            PreparedStatement stmt = conn.prepareStatement(deleteHorariosEmpleadosClaveEmpleado(IdEmpleado));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }

    //Horarios Empleados---------YA----------------------------------------------------------
    //eliminar por el id horario
    public String deleteHorariosEmpleadosIdHorario(String IdHorario){
        String sql = "DELETE FROM dhremps WHERE NIDHORA = " + IdHorario;
        return sql;
    }
    public boolean deleteHorariosEmpleadosIdHorario(Connection conn, String IdHorario){
        try{
            PreparedStatement stmt = conn.prepareStatement(deleteHorariosEmpleadosIdHorario(IdHorario));
            stmt.execute();
            return true;

        }catch (Exception e){
            System.out.println("No jalo xd"+e);
            return false;
        }

    }

}
