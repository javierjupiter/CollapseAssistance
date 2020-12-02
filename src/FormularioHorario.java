import java.sql.Connection;
import java.util.Scanner;

public class FormularioHorario {
        private String cadena;
        private Scanner leer = new Scanner(System.in);
        private Validaciones validaciones;
        private Connection connection;//esta
        private Horario horario;
        private BD_Inserciones inserciones;//esta

        public FormularioHorario(Connection connection) {
            validaciones = new Validaciones();
            this.connection = connection; //esta
            inserciones = new BD_Inserciones(); //esta
        }

        public FormularioHorario() {
            validaciones = new Validaciones();
        }

        public void FormularioHorario() {
            horario = new Horario();
            System.out.println("Horario:");
            do {
                System.out.println("Escriba el ID Horario(5 numeros): ");
                cadena = leer.nextLine();
            } while (!validaciones.validarCP(cadena));
            horario.setID_Horario(cadena);

            System.out.println("El get guardo:" + horario.getID_Horario());

            do {
                System.out.println("Escriba la descripcion: ");
                cadena = leer.nextLine();
            } while (!validaciones.validarCadena(cadena));
            horario.setDescripcion_Horario(cadena);

            System.out.println("El get guardo:" + horario.getDescripcion_Horario());

            do {
                System.out.println("Escriba el estatus (Cadenas aceptadas: 'A' y 'I'): ");
                cadena = leer.nextLine();
            } while (!validaciones.validarEstatus(cadena));
            horario.setStatus_Horario(cadena);

            System.out.println("El get guardo:" + horario.getStatus_Horario());

            inserciones.hacerIncercionesCatalogoHorarios(connection, horario.getID_Horario(), horario.getDescripcion_Horario(), horario.getStatus_Horario());

        }
    }
