public class RegistroAsistencia {
    private Fecha Fecha_Registro;
    private String Clave_Empleado;
    private String Numero_Dispositivo_Biometrico; //CONVERTIR A NUMERIC
    private String Status_Registro;

    public RegistroAsistencia(){ Fecha_Registro =new Fecha(); }

    public void setFecha(int dia, int mes, int anyo) {
        Fecha_Registro.setAnyo(anyo);
        Fecha_Registro.setMes(mes);
        Fecha_Registro.setDia(dia);
    }

    public String getFecha_Registro() {
        String fecha = (Fecha_Registro.getDia() + "-" + Fecha_Registro.getMes() + "-" + Fecha_Registro.getAnyo());
        return fecha;
        //colocar esto
    }

    public String getClave_Empleado() {
        return Clave_Empleado;
    }

    public void setClave_Empleado(String clave_Empleado) {
        Clave_Empleado = clave_Empleado;
    }

    public String getNumero_Dispositivo_Biometrico() {
        return Numero_Dispositivo_Biometrico;
    }

    public void setNumero_Dispositivo_Biometrico(String numero_Dispositivo_Biometrico) {
        Numero_Dispositivo_Biometrico = numero_Dispositivo_Biometrico;
    }

    public String getStatus_Registro() {
        return Status_Registro;
    }

    public void setStatus_Registro(String status_Registro) {
        Status_Registro = status_Registro;
    }


}
