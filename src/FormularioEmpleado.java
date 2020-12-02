import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class FormularioEmpleado {

    private String cadena;
    private Scanner leer = new Scanner(System.in);
    private Validaciones validaciones;
    private Empleado empleado;
    private BD_Inserciones inserciones;//revisar
    private Direccion direccion;
    private Connection connection;//esta

    public FormularioEmpleado(Connection connection){
        validaciones = new Validaciones();
        this.connection = connection; //esta
        inserciones = new BD_Inserciones(); //esta
    }

    //public FormularioEmpleado(){
      //  validaciones = new Validaciones();
    //}


    public void formularioEmpleado(){
        empleado = new Empleado();
        System.out.println("Datos del empleado:");
        do {
            System.out.println("¿Cuál es tu Clave?");
            cadena = leer.nextLine();
        } while (!validaciones.validarClave(cadena));
        empleado.setClaveE(cadena);
        System.out.println(""+cadena);

        do {
            System.out.println("¿Cual es el nombre?");
            cadena = leer.nextLine();
        } while (!validaciones.validarNombre(cadena));
        empleado.setNombreE(cadena);
        System.out.println(""+cadena);

        do {
            System.out.println("¿Cual es el apellido paterno?");
            cadena = leer.nextLine();
        } while (!validaciones.validarNombre(cadena));
        empleado.setApllidoPaternoE(cadena);
        System.out.println(""+cadena);

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
        } while (validaciones.validarNombre(cadena));
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
        } while (validaciones.validarNombre(cadena));
        empleado.setColonia(cadena);

        do {
            System.out.println("¿Cuál es el ID del estado?");
            cadena = leer.nextLine();
        } while (!validaciones.validarBiometrico(cadena));
        empleado.setEstado(cadena);

        do {
            System.out.println("¿Cuál es el ID del municipio?");
            cadena = leer.nextLine();
        } while (!validaciones.validarIDMunicipio(cadena));
        empleado.setMunicipio(cadena);
        System.out.println("holi");
        inserciones.hacerInsercionEmpleado(connection, empleado.getClaveE(), empleado.getNombreE(), empleado.getApllidoPaternoE(), empleado.getApllidoMaternoE(), empleado.getCurpE(),empleado.getFechaContratacionE(),empleado.getCalle(), empleado.getNumeroExterior(), empleado.getNumeroInterior(), empleado.getColonia(), empleado.getCodigoPostal(), empleado.getEstado(), empleado.getMunicipio(),"A"  );




    }
}
