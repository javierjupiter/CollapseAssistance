import java.util.Scanner;

public class Formulario_Incidencias_Empleado {
    private String cadena;
    private Scanner leer = new Scanner(System.in);
    private Validaciones validaciones;
    private Conexion conexion;
    private Incidencias_Empleados incidenciasEmpleados;

    public Formulario_Incidencias_Empleado  (Conexion conexion) {
        validaciones = new Validaciones();
        this.conexion = conexion;
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
            System.out.println("Escriba la tipo de Incidencia(0-9): "); //cambiar cuando preguntemos al profe
            cadena = leer.nextLine();
        } while (!validaciones.validarIncidencia(cadena));
        incidenciasEmpleados.setTipo_Incidencia(cadena);
        System.out.println("El get guardo:" + incidenciasEmpleados.getTipo_Incidencia());

        do {
            System.out.println("Escriba el Status ('R' 'J' 'A'): "); //cambiar cuando preguntemos al profe
            cadena = leer.nextLine();
        } while (!validaciones.validarStatusIncidencia(cadena));
        incidenciasEmpleados.setTipo_Incidencia(cadena);
        System.out.println("El get guardo:" + incidenciasEmpleados.getStatus_Incidencia());



    }
}
