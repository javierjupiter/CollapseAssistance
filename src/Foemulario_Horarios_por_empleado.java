import java.util.Scanner;

public class Foemulario_Horarios_por_empleado {
    private String cadena;
    private Scanner leer = new Scanner(System.in);
    private Validaciones validaciones;
    private Conexion conexion;
    private Horarios_por_empleado horario;

    public Foemulario_Horarios_por_empleado(Conexion conexion) {
        validaciones = new Validaciones();
        this.conexion = conexion;
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

        System.out.println("" + cadena);

        do {
            System.out.println("Escriba el ID del empleado: ");
            cadena = leer.nextLine();
        } while (!validaciones.validarClave(cadena));
        horario.setClave_Empleado(cadena);

        System.out.println("" + cadena);

        do {
            System.out.println("Escriba la fecha: ");
            cadena = leer.nextLine();
        } while (!validaciones.validarFecha(cadena));
        horario.setFecha(Integer.parseInt(cadena.substring(0,4)), Integer.parseInt(cadena.substring(5,7)), Integer.parseInt(cadena.substring(8,10)));


    }
}
