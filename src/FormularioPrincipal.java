import java.util.Scanner;

public class FormularioPrincipal {
        int opcion;
        boolean continuar = true;

        Scanner leer = new Scanner(System.in);
        FormularioEmpleado empleado = new FormularioEmpleado();

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
