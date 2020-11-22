import java.util.Scanner;

public class FormularioPrincipal {

    //private static Conexion conexion;

    public static void main(String[] args) {
        int opcion;
        boolean continuar = true;
        String contrasenya;

        Scanner leer = new Scanner(System.in);
        System.out.print("Contraseña root de mySQL:\t");
        //conexion = new Conexion(leer.nextLine());

        FormularioEmpleado empleado = new FormularioEmpleado();/*conexion*/

        do {
            System.out.println("¿Qué desas hacer?");
            System.out.println("1. Agregar empleado\n2. Salir");
            opcion = leer.nextInt();

            switch (opcion){
                case 1 :
                    empleado.formulario();
                    break;
                case 2 :
                    continuar = false;
                    break;
            }

        }while (continuar);
    }
}
