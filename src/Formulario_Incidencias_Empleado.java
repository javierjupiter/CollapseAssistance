import java.sql.Connection;
import java.util.Scanner;

public class Formulario_Incidencias_Empleado {
    private String cadena;
    private Scanner leer = new Scanner(System.in);
    private Validaciones validaciones;
    private Connection connection;//esta
    private Incidencias_Empleados incidenciasEmpleados;
    private BD_Inserciones inserciones;//esta

    public Formulario_Incidencias_Empleado  (Connection connection) {
        validaciones = new Validaciones();
        this.connection = connection; //esta
        inserciones = new BD_Inserciones(); //esta
    }

    public Formulario_Incidencias_Empleado() {
        validaciones = new Validaciones();
    }

    public void Formulario_Incidencias_Empleado  () {
        incidenciasEmpleados = new Incidencias_Empleados();
        System.out.println("Incidencias Empleados:");

        do {
            System.out.println("Escriba la clave del empleado: ");
            cadena = leer.nextLine();
        } while (!validaciones.validarClave(cadena));
        incidenciasEmpleados.setClave_Empleado(cadena);
        System.out.println("El get guardo:" + incidenciasEmpleados.getClave_Empleado());


        do {
            System.out.println("¿Cuál es la fecha de incidencia?");
            cadena = leer.nextLine();
        } while (!validaciones.validarFecha(cadena));
        incidenciasEmpleados.setFecha(Integer.parseInt(cadena.substring(0, 4)), Integer.parseInt(cadena.substring(5, 7)), Integer.parseInt(cadena.substring(8, 10)));
        System.out.println("El get guardo:" + incidenciasEmpleados.getFecha_Incidencia());


        do {
            System.out.println("Escriba la tipo de Incidencia(A-Z): "); //cambiar cuando preguntemos al profe
            cadena = leer.nextLine();
        } while (!validaciones.validarIncidencia(cadena));
        incidenciasEmpleados.setTipo_Incidencia(cadena);
        System.out.println("El get guardo:" + incidenciasEmpleados.getTipo_Incidencia());

        do {
            System.out.println("Escriba el Status ('R' 'J' 'A'): "); //cambiar cuando preguntemos al profe
            cadena = leer.nextLine();
        } while (!validaciones.validarStatusIncidencia(cadena));
        incidenciasEmpleados.setStatus_Incidencia(cadena);
        System.out.println("El get guardo:" + incidenciasEmpleados.getStatus_Incidencia());

        inserciones.hacerIncercionesIEmpleado(connection, incidenciasEmpleados.getClave_Empleado(), incidenciasEmpleados.getFecha_Incidencia(), incidenciasEmpleados.getTipo_Incidencia(), incidenciasEmpleados.getStatus_Incidencia());


    }
}
