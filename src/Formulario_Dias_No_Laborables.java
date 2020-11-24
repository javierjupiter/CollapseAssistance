import java.util.Scanner;

public class Formulario_Dias_No_Laborables {
    private String cadena;
    private Scanner leer = new Scanner(System.in);
    private Validaciones validaciones;
    private Conexion conexion;
    private Dias_no_laborables dias_no_laborables;

    public Formulario_Dias_No_Laborables(Conexion conexion){
        validaciones = new Validaciones();
        this.conexion = conexion;
    }
    public Formulario_Dias_No_Laborables(){
        validaciones = new Validaciones();
    }

    public void Formulario_Dias_No_Laborables() {
        dias_no_laborables = new Dias_no_laborables();
        System.out.println("Dias no laborables:");
        do {
            System.out.println("Escriba la fecha: ");
            cadena = leer.nextLine();
        } while (!validaciones.validarFecha(cadena));
        dias_no_laborables.setFecha(Integer.parseInt(cadena.substring(0,4)), Integer.parseInt(cadena.substring(5,7)), Integer.parseInt(cadena.substring(8,10)));

        System.out.println(""+cadena);

        do {
            System.out.println("Escriba el motivo: ");
            cadena = leer.nextLine();
        } while (!validaciones.validarCadena(cadena));
        dias_no_laborables.setMotivo(cadena);

        System.out.println(""+cadena);

        do {
            System.out.println("Escriba el estatus (Cadenas aceptadas: 'A' y 'I'): ");
            cadena = leer.nextLine();
        } while (!validaciones.validarEstatus(cadena));
        dias_no_laborables.setStatus(cadena);

        System.out.println(""+cadena);
    }
    }
