import java.util.Scanner;

public class Formulario_RegistroAsistencia {
    private String cadena;
    private Scanner leer = new Scanner(System.in);
    private Validaciones validaciones;
    private Conexion conexion;
    private RegistroAsistencia registroAsistencia;

    public Formulario_RegistroAsistencia (Conexion conexion) {
        validaciones = new Validaciones();
        this.conexion = conexion;
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
        System.out.println("" + cadena);


        do {
            System.out.println("¿Cuál es la fecha de registro?");
            cadena = leer.nextLine();
        } while (!validaciones.validarFecha(cadena));
        registroAsistencia.setFecha(Integer.parseInt(cadena.substring(0,4)), Integer.parseInt(cadena.substring(5,7)), Integer.parseInt(cadena.substring(8,10)));
        System.out.println("" + cadena);



        do {
            System.out.println("Escriba el numero de dispositivo Biometricp ");
            cadena = leer.nextLine();

        } while (!validaciones.validarBiometrico(cadena));
        registroAsistencia.setNumero_Dispositivo_Biometrico(cadena);
        System.out.println("" + cadena);

        do {
            System.out.println("Escriba el estatus (Cadenas aceptadas: 'A' y 'I'): ");
            cadena = leer.nextLine();
        } while (!validaciones.validarEstatus(cadena));
        registroAsistencia.setStatus_Registro(cadena);

        System.out.println(""+cadena);
    }
}
