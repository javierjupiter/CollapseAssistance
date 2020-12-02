public class Justificante_empelados {

    private String Clave_Empleado;
    private Fecha Fecha_Incidencia;
    private String ID_Tipo_Justificante; //CONVERTIR A NUMERIC
    private String Status_Justificante;


    public Justificante_empelados(){ Fecha_Incidencia =new Fecha(); }

    public void setFecha(int dia, int mes, int anyo) {
        Fecha_Incidencia.setAnyo(anyo);
        Fecha_Incidencia.setMes(mes);
        Fecha_Incidencia.setDia(dia);
    }

    public String getFecha_Incidencia() {

        String fecha = (Fecha_Incidencia.getDia() + "-" + Fecha_Incidencia.getMes() + "-" + Fecha_Incidencia.getAnyo());
        return fecha;
    }



    public String getClave_Empleado() {
        return Clave_Empleado;
    }

    public void setClave_Empleado(String clave_Empleado) {
        Clave_Empleado = clave_Empleado;
    }


    public String getID_Tipo_Justificante() {
        return ID_Tipo_Justificante;
    }

    public void setID_Tipo_Justificante(String ID_Tipo_Justificante) {
        this.ID_Tipo_Justificante = ID_Tipo_Justificante;
    }

    public String getStatus_Justificante() {
        return Status_Justificante;
    }

    public void setStatus_Justificante(String status_Justificante) {
        Status_Justificante = status_Justificante;
    }
}
