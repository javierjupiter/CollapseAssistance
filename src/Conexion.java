import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    static String bd = "collapseassistance";
    static String login = "root";
    static String url = "jdbc:mysql://localhost:3306/" + bd + "?verifyServerCertificate=false&useSSL=true";

    Connection conn = null;

    /* Constructor de Conexion */
    public Conexion(String password) {
        try{
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //obtenemos la conexión
            conn = DriverManager.getConnection(url,login,password);
            if (conn!=null){
                System.out.println("Conección a base de datos "+bd+" OK");
            }
        }catch(SQLException e){
            System.out.println(e+ "Error en la conexion");
        }catch(ClassNotFoundException e){
            System.out.println(e+ "error en la conexion 2");
        }
    }
    /*Permite retornar la conexión*/
    public Connection getConnection(){
        return conn;
    }

    public void desconectar(){
        conn = null;
    }

    Statement createStatement() {/////////////////revisaaaaaaaaaaaaaar
        throw new UnsupportedOperationException("No Conectado");
    }
}
