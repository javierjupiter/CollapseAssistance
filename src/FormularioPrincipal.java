import java.sql.Connection;
import java.util.Scanner;

public class FormularioPrincipal {

    private static Conexion conexion;
    private static Connection conn;

    public static void main(String[] args) {
        int opcion;
        boolean continuar = true;
        String contrasenya;

        Scanner leer = new Scanner(System.in);
        System.out.print("Contraseña root de mySQL:\t");
        conexion = new Conexion(leer.nextLine());
        conn = conexion.getConnection();
        FormularioEmpleado empleado = new FormularioEmpleado(conn);/*conexion*/
        Formulario_Dias_No_Laborables noLaborables = new Formulario_Dias_No_Laborables(conn);
        FormularioHorario horario = new FormularioHorario(conn);
        Foemulario_Horarios_por_empleado horariosEmpleado = new Foemulario_Horarios_por_empleado(conn);
        Formulario_RegistroAsistencia RegistroAsistencia = new Formulario_RegistroAsistencia(conn);
        Formulario_Justificante_empelados justificanteEmpelados = new Formulario_Justificante_empelados(conn);//esto xd
        Formulario_Incidencias_Empleado incidenciasEmpleado = new Formulario_Incidencias_Empleado(conn);

        do {
            System.out.println("\n_________________________________________________________");
            System.out.println("¿Qué desas hacer?");
            System.out.println("1. Datos Generales\n2. Catalogo de horarios\n3. Horarios por empleado\n4. Dias no laborables\n5. Registro de asistencia\n6. Justificante Empleado\n7. Incidencias Empleado\n8. Salir");
            opcion = leer.nextInt();

            switch (opcion){
                case 1 :
                    empleado.formularioEmpleado();
                    break;
                case 2 :
                    horario.FormularioHorario();
                    break;
                case 3 :
                    horariosEmpleado.Foemulario_Horarios_por_empleado();
                    break;
                case 4 :
                    noLaborables.Formulario_Dias_No_Laborables();
                    break;
                case 5 :
                    RegistroAsistencia.Formulario_RegistroAsistencia();
                    break;
                case 6 :
                    justificanteEmpelados.Formulario_Justificante_empelados();
                    break;
                case 7 :
                    incidenciasEmpleado.Formulario_Incidencias_Empleado();
                    break;
                case 8 :
                    continuar = false;
                    break;
            }

        }while (continuar);
    }
}
