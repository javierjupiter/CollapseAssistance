import java.sql.Connection;
import java.util.Scanner;

public class FormularioTipoJustificante {
    private String cadena;
    private Scanner leer = new Scanner(System.in);
    private Validaciones validaciones;
    private Connection connection;//esta
    private TipoJustificante tipoJustificante;
    private BD_Inserciones inserciones;//esta

    public FormularioTipoJustificante(Connection connection) {
        validaciones = new Validaciones();
        this.connection = connection; //esta
        inserciones = new BD_Inserciones(); //esta
    }

    public FormularioTipoJustificante() {
        validaciones = new Validaciones();
    }

    public void FormularioTipoJustificante() {
        tipoJustificante = new TipoJustificante();
        System.out.println("Justificante:");
        do {
            System.out.println("Escriba el ID jistificante(2 numeros): ");
            cadena = leer.nextLine();
        } while (!validaciones.validarBiometrico(cadena));
        tipoJustificante.setIDjustificante(cadena);


        do {
            System.out.println("Escriba la descripcion: ");
            cadena = leer.nextLine();
        } while (!validaciones.validarCadena(cadena));
        tipoJustificante.setDescripcionJustificante(cadena);


        do {
            System.out.println("Escriba el estatus (Cadenas aceptadas: 'A' y 'I'): ");
            cadena = leer.nextLine();
        } while (!validaciones.validarEstatus(cadena));
        tipoJustificante.setStatusJustificante(cadena);


        inserciones.hacerIncercionesJustificantes(connection, tipoJustificante.getIDjustificante(), tipoJustificante.getDescripcionJustificante(), tipoJustificante.getStatusJustificante());

    }
}
