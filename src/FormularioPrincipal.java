import java.util.Scanner;

public class FormularioPrincipal {

    //private static Conexion conexion;

    public static void main(String[] args) {
        int opcion;
        boolean continuar = true;
        String contrasenya;

        Scanner leer = new Scanner(System.in);
        System.out.print("Contraseña root de mySQL:\t");
        //conexion = new Conexion(leer.nextLine());

        FormularioEmpleado empleado = new FormularioEmpleado();/*conexion*/
        Formulario_Dias_No_Laborables noLaborables = new Formulario_Dias_No_Laborables();
        FormularioHorario horario = new FormularioHorario();
        Foemulario_Horarios_por_empleado horariosEmpleado = new Foemulario_Horarios_por_empleado();
        Formulario_RegistroAsistencia RegistroAsistencia = new Formulario_RegistroAsistencia();

        do {
            System.out.println("¿Qué desas hacer?");
            System.out.println("1. Datos Generales\n2. Catalogo de horarios\n3. Horarios por empleado\n4. Dias no laborables\n5. Registro de asistencia\n6. Salir");
            opcion = leer.nextInt();

            switch (opcion){
                case 1 :
                    empleado.formulario();
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
                    continuar = false;
                    break;
            }

        }while (continuar);
    }
}
