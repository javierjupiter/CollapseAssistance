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
        Fecha_Asignacion_Horario.setAnyo(anyo);
        Fecha_Asignacion_Horario.setMes(mes);
        Fecha_Asignacion_Horario.setDia(dia);
    }

    public String getFecha_Asignacion_Horario() {//String
        String fecha = (Fecha_Asignacion_Horario.getDia() + "-" + Fecha_Asignacion_Horario.getMes() + "-" + Fecha_Asignacion_Horario.getAnyo());
        return fecha;
        //colocar esto
    }
}
