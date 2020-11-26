public class Horarios_por_empleado {
    private String ID_Horario; //CONVERTIR A NUMERIC
    private String Clave_Empleado;
    private Fecha Fecha_Asignacion_Horario;

    public Horarios_por_empleado(){ Fecha_Asignacion_Horario =new Fecha(); }

    public String getID_Horario() {
        return ID_Horario;
    }

    public void setID_Horario(String ID_Horario) {
        this.ID_Horario = ID_Horario;
    }

    public String getClave_Empleado() {
        return Clave_Empleado;
    }

    public void setClave_Empleado(String clave_Empleado) {
        Clave_Empleado = clave_Empleado;
    }
    public void setFecha(int dia, int mes, int anyo) {
        getFecha_Asignacion_Horario().setAnyo(anyo);
        getFecha_Asignacion_Horario().setMes(mes);
        getFecha_Asignacion_Horario().setDia(dia);
    }

    public Fecha getFecha_Asignacion_Horario() {
        return Fecha_Asignacion_Horario;
    }
}
