import java.util.Scanner;

public class FormularioEmpleado {

    private String cadena;
    private Scanner leer = new Scanner(System.in);
    private Validaciones validaciones;
    private Conexion conexion;
    private Empleado empleado;

    public FormularioEmpleado(Conexion conexion){
        validaciones = new Validaciones();
        this.conexion = conexion;
    }

    public FormularioEmpleado(){
        validaciones = new Validaciones();
    }

    public void formulario(){
        empleado = new Empleado();
        System.out.println("Datos del empleado:");
        do {
            System.out.println("¿Cuál es tu Clave?");
            cadena = leer.nextLine();
        } while (!validaciones.validarClave(cadena));
        empleado.setClaveE(cadena);

        do {
            System.out.println("¿Cual es el nombre?");
            cadena = leer.nextLine();
        } while (!validaciones.validarNombre(cadena));
        empleado.setNombreE(cadena);

        do {
            System.out.println("¿Cual es el apellido paterno?");
            cadena = leer.nextLine();
        } while (!validaciones.validarNombre(cadena));
        empleado.setApllidoPaternoE(cadena);

        do {
            System.out.println("¿Cual es el apellido materno?");
            cadena = leer.nextLine();
        }while (!validaciones.validarNombre(cadena));
        empleado.setApllidoMaternoE(cadena);

        do {
            System.out.println("¿Cuál es el CURP?");
            cadena = leer.nextLine();
        } while (!validaciones.validarCURP(cadena));
        empleado.setCurpE(cadena);

        do {
            System.out.println("¿Cuál es la fecha de ingreso?");
            cadena = leer.nextLine();
        } while (!validaciones.validarFecha(cadena));
        empleado.setFechaContratacionE(Integer.parseInt(cadena.substring(0,4)), Integer.parseInt(cadena.substring(5,7)), Integer.parseInt(cadena.substring(8,10)));

        System.out.println("Datos de la dirección:");
        do {
            System.out.println("¿Cuál es la calle?");
            cadena = leer.nextLine();
        } while (validaciones.validarCadena(cadena));
        empleado.setCalle(cadena);

        do {
            System.out.println("¿Cuál es el número exterior?");
            cadena = leer.nextLine();
        } while(!validaciones.validarNumeroDireccion(cadena));
        empleado.setNumeroExterior(cadena);

        do {
            System.out.println("¿Cuál es el número interior?");
            cadena = leer.nextLine();
        } while(!validaciones.validarNumeroDireccion(cadena));
        empleado.setNumeroInterior(cadena);

        do {
            System.out.println("¿Cuál es el Código Postal?");
            cadena = leer.nextLine();
        } while (!validaciones.validarCP(cadena));
        empleado.setCodigoPostal(cadena);

        do {
            System.out.println("¿Cuál es la colonia?");
            cadena = leer.nextLine();
        } while (validaciones.validarCadena(cadena));
        empleado.setColonia(cadena);

        do {
            System.out.println("¿Cuál es el ID del estado?");
            cadena = leer.nextLine();
        } while (!validaciones.validarIDEstado(cadena));
        empleado.setEstado(cadena);

        do {
            System.out.println("¿Cuál es el ID del municipio?");
            cadena = leer.nextLine();
        } while (!validaciones.validarIDMunicipio(cadena));
        empleado.setMunicipio(cadena);
    }
}
