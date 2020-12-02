import java.sql.Connection;
import java.util.Scanner;

public class Foemulario_Horarios_por_empleado {
    private String cadena;
    private Scanner leer = new Scanner(System.in);
    private Validaciones validaciones;
    private Connection connection;//esta
    private Horarios_por_empleado horario;
    private BD_Inserciones inserciones;//esta

    public Foemulario_Horarios_por_empleado(Connection connection) {//estoooooooooooooooooooooo
        validaciones = new Validaciones();
        this.connection = connection; //esta
        inserciones = new BD_Inserciones(); //esta

    }

    public Foemulario_Horarios_por_empleado() {
        validaciones = new Validaciones();
    }


    public void Foemulario_Horarios_por_empleado() {
        horario = new Horarios_por_empleado();
        System.out.println("Horarios por empleado:");
        do {
            System.out.println("Escriba el ID Horario(5 numeros): ");
            cadena = leer.nextLine();
        } while (!validaciones.validarCP(cadena));
        horario.setID_Horario(cadena);

        System.out.println("El get guardo:" + horario.getID_Horario());

        do {
            System.out.println("Escriba el ID del empleado: ");
            cadena = leer.nextLine();
        } while (!validaciones.validarClave(cadena));
        horario.setClave_Empleado(cadena);

        System.out.println("El get guardo:" + horario.getClave_Empleado());

        do {
            System.out.println("Escriba la fecha: ");
            cadena = leer.nextLine();
        } while (!validaciones.validarFecha(cadena));
        horario.setFecha(Integer.parseInt(cadena.substring(0,4)), Integer.parseInt(cadena.substring(5,7)), Integer.parseInt(cadena.substring(8,10)));

        System.out.println("El get guardo:" + horario.getFecha_Asignacion_Horario());

        inserciones.hacerInsercionHorariosEmpleado(connection, horario.getID_Horario(), horario.getClave_Empleado(), horario.getFecha_Asignacion_Horario());



    }
}
