public class Justificante_empelados {

    private String Clave_Empleado;
    private Fecha Fecha_Incidencia;
    private String ID_Tipo_Justificante; //CONVERTIR A NUMERIC
    private String Status_Justificante;


    public Justificante_empelados(){ Fecha_Incidencia =new Fecha(); }

    public void setFecha(int dia, int mes, int anyo) {
        getFecha_Incidencia().setAnyo(anyo);
        getFecha_Incidencia().setMes(mes);
        getFecha_Incidencia().setDia(dia);
    }

    public Fecha getFecha_Incidencia() { return  Fecha_Incidencia;
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
