import java.util.Scanner;

public class CosultaEstadosMunicipios {

    public static void main(String[] args) {
        Conexion conexion;
        String pass;
        Scanner sn = new Scanner(System.in);
        System.out.println("Dame la contraseña del MySQL: ");
        pass=sn.nextLine();
        BD_Consultas consultas = new BD_Consultas();
        String choose;

        conexion = new Conexion(pass);

        if(consultas.hacerConsultasEstados(conexion.getConnection())){
            Estados[] estados = consultas.getEstados();
            System.out.println("Seleccione un estado: ");
            for (int i=0; i < consultas.getTamanioEstados(); i++){
                System.out.println(estados[i].getIdEstado() + ". " + estados[i].getNombre());
            }
            choose = sn.nextLine();
            if (consultas.hacerConsultasMunicipios(conexion.getConnection(), Integer.parseInt(choose))){
                Municipios[] municipios = consultas.getMunicipios();
                System.out.printf("Municipios del estado " + choose);
                for (int i = 0; i < consultas.getTamnnioMunicipios(); i++){
                    System.out.println(municipios[i].getIdMunicipio() + ". " + municipios[i].getNombre() + " del estado " + municipios[i].getIdEstado());
                }
            }
        }
    }
}
