import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class CosultaEstadosMunicipios {


    public static void main(String[] args) {
        Conexion conexion;
        String pass;
        Scanner sn = new Scanner(System.in);
        System.out.println("Dame la contraseña del MySQL: ");
        pass=sn.nextLine();
        BD_Consultas consultas = new BD_Consultas();

        conexion = new Conexion(pass);

        if(consultas.hacerConsultasEstados(conexion.getConnection())){
            Estados[] estados = consultas.getEstados();
            System.out.println("Seleccione un estado: ");
            for (int i=0; i < consultas.getTamanioEstados(); i++){
                System.out.println(estados[i].getIdEstado() + ". " + estados[i].getNombre());

            }
        }

    }

}
