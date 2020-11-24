import java.util.Scanner;

public class FormularioHorario {
        private String cadena;
        private Scanner leer = new Scanner(System.in);
        private Validaciones validaciones;
        private Conexion conexion;
        private Horario horario;

        public FormularioHorario(Conexion conexion) {
            validaciones = new Validaciones();
            this.conexion = conexion;
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

            System.out.println("" + cadena);

            do {
                System.out.println("Escriba la descripcion: ");
                cadena = leer.nextLine();
            } while (!validaciones.validarCadena(cadena));
            horario.setDescripcion_Horario(cadena);

            System.out.println("" + cadena);

            do {
                System.out.println("Escriba el estatus (Cadenas aceptadas: 'A' y 'I'): ");
                cadena = leer.nextLine();
            } while (!validaciones.validarEstatus(cadena));
            horario.setStatus_Horario(cadena);

            System.out.println("" + cadena);
        }
    }
