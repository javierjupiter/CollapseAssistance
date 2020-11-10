import java.util.Scanner;
import java.util.regex.Pattern;

public class FormularioEmpleado {

    private String cadena;
    private Scanner leer = new Scanner(System.in);
    private Validaciones validaciones;

    public FormularioEmpleado(){
        validaciones = new Validaciones();
    }

    public void formulario(){
        do {
            System.out.println("¿Cuál es el CURP?");
            cadena = leer.nextLine();
        } while (!validaciones.validarCURP(cadena));

        do {
            System.out.println("¿Cuál es la fecha de ingreso?");
            cadena = leer.nextLine();
        } while (!validaciones.validarFecha(cadena));

        do {
            System.out.println("¿Cual es el nombre");
            cadena = leer.nextLine();
        } while (!validaciones.validarNombre(cadena));

        do {
            System.out.println("¿Cual es el apellido paterno");
            cadena = leer.nextLine();
        } while (!validaciones.validarNombre(cadena));

        System.out.println("¿Cual es el apellido materno");
        cadena = leer.nextLine();

    }


}
