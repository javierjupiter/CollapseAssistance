public class Incidencias_Empleados {
    private String Clave_Empleado;
    private Fecha Fecha_Incidencia;
    private String Tipo_Incidencia;
    private String Status_Incidencia;


    public String getClave_Empleado() {
        return Clave_Empleado;
    }

    public void setClave_Empleado(String clave_Empleado) {
        Clave_Empleado = clave_Empleado;
    }

    public Incidencias_Empleados(){ Fecha_Incidencia =new Fecha(); }

    public void setFecha(int dia, int mes, int anyo) {
        Fecha_Incidencia.setAnyo(anyo);
        Fecha_Incidencia.setMes(mes);
        Fecha_Incidencia.setDia(dia);
    }

    public String getFecha_Incidencia() {
        String fecha = (Fecha_Incidencia.getDia() + "-" + Fecha_Incidencia.getMes() + "-" + Fecha_Incidencia.getAnyo());
        return fecha;
    }


    public void setTipo_Incidencia(String tipo_Incidencia) {
        Tipo_Incidencia = tipo_Incidencia;
    }

    public String getStatus_Incidencia() {
        return Status_Incidencia;
    }

    public void setStatus_Incidencia(String status_Incidencia) {
        Status_Incidencia = status_Incidencia;
    }

    public String getTipo_Incidencia() {
        return Tipo_Incidencia;
    }

}
