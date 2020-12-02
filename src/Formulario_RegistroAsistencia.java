import java.sql.Connection;
import java.util.Scanner;

public class Formulario_RegistroAsistencia {
    private String cadena;
    private Scanner leer = new Scanner(System.in);
    private Validaciones validaciones;
    private Connection connection;//esta
    private RegistroAsistencia registroAsistencia;
    private BD_Inserciones inserciones;//esta

    public Formulario_RegistroAsistencia (Connection connection) {
        validaciones = new Validaciones();
        this.connection = connection; //esta
        inserciones = new BD_Inserciones(); //esta
    }

    public Formulario_RegistroAsistencia () {
        validaciones = new Validaciones();
    }

    public void Formulario_RegistroAsistencia () {
        registroAsistencia = new RegistroAsistencia();
        System.out.println("Registro de Asistencia:");

        do {
            System.out.println("Escriba la clave del empleado: ");
            cadena = leer.nextLine();
        } while (!validaciones.validarClave(cadena));
        registroAsistencia.setClave_Empleado(cadena);
        System.out.println("El get guardo:" + registroAsistencia.getClave_Empleado());


        do {
            System.out.println("¿Cuál es la fecha de registro?");
            cadena = leer.nextLine();
        } while (!validaciones.validarFecha(cadena));
        registroAsistencia.setFecha(Integer.parseInt(cadena.substring(0,4)), Integer.parseInt(cadena.substring(5,7)), Integer.parseInt(cadena.substring(8,10)));
        System.out.println("El get guardo:" + registroAsistencia.getFecha_Registro());



        do {
            System.out.println("Escriba el numero de dispositivo Biometricp ");
            cadena = leer.nextLine();

        } while (!validaciones.validarBiometrico(cadena));
        registroAsistencia.setNumero_Dispositivo_Biometrico(cadena);
        System.out.println("El get guardo:" + registroAsistencia.getNumero_Dispositivo_Biometrico());

        do {
            System.out.println("Escriba el estatus (Cadenas aceptadas: 'R' y 'P'): ");
            cadena = leer.nextLine();
        } while (!validaciones.validarStatusRAsistencia(cadena));
        registroAsistencia.setStatus_Registro(cadena);

        System.out.println("El get guardo:"+registroAsistencia.getStatus_Registro());

        inserciones.hacerInsercionRegistroAsistencia(connection, registroAsistencia.getClave_Empleado(), registroAsistencia.getFecha_Registro(), registroAsistencia.getNumero_Dispositivo_Biometrico(), registroAsistencia.getStatus_Registro());

    }
}
