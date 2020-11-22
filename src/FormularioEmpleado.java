import java.util.Scanner;

public class FormularioEmpleado {

    private String cadena;
    private Scanner leer = new Scanner(System.in);
    private Validaciones validaciones;
    private Conexion conexion;

    public FormularioEmpleado(Conexion conexion){
        validaciones = new Validaciones();
        this.conexion = conexion;
    }

    public FormularioEmpleado(){
        validaciones = new Validaciones();
    }

    public void formulario(){
        System.out.println("Datos del empleado:");
        do {
            System.out.println("¿Cuál es tu Clave?");
            cadena = leer.nextLine();
        } while (!validaciones.validarClave(cadena));

        do {
            System.out.println("¿Cual es el nombre?");
            cadena = leer.nextLine();
        } while (!validaciones.validarNombre(cadena));

        do {
            System.out.println("¿Cual es el apellido paterno?");
            cadena = leer.nextLine();
        } while (!validaciones.validarNombre(cadena));

        do {
            System.out.println("¿Cual es el apellido materno?");
            cadena = leer.nextLine();
        }while (!validaciones.validarNombre(cadena));

        do {
            System.out.println("¿Cuál es el CURP?");
            cadena = leer.nextLine();
        } while (!validaciones.validarCURP(cadena));

        do {
            System.out.println("¿Cuál es la fecha de ingreso?");
            cadena = leer.nextLine();
        } while (!validaciones.validarFecha(cadena));

        System.out.println("Datos de la dirección:");
        do {
            System.out.println("¿Cuál es la calle?");
            cadena = leer.nextLine();
        } while (!validaciones.validarCadenas(cadena));

        do {
            System.out.println("¿Cuál es el número exterior?");
            cadena = leer.nextLine();
        } while(!validaciones.validarNumeroDireccion(cadena));

        do {
            System.out.println("¿Cuál es el número interior?");
            cadena = leer.nextLine();
        } while(!validaciones.validarNumeroDireccion(cadena));

        do {
            System.out.println("¿Cuál es el Código Postal?");
            cadena = leer.nextLine();
        } while (!validaciones.validarCP(cadena));

        do {
            System.out.println("¿Cuál es la colonia?");
            cadena = leer.nextLine();
        } while (!validaciones.validarCadenas(cadena));

        do {
            System.out.println("¿Cuál es el ID del estado?");
            cadena = leer.nextLine();
        } while (!validaciones.validarIDEstado(cadena));

        do {
            System.out.println("¿Cuál es el ID del municipio?");
            cadena = leer.nextLine();
        } while (!validaciones.validarIDMunicipio(cadena));
    }
}
