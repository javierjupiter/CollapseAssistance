public class Dias_no_laborables {
    private Fecha Fecha;
    private String Motivo;
    private String Status;

    public Dias_no_laborables(){ Fecha =new Fecha(); }


    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        Motivo = motivo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }


    public void setFecha(int dia, int mes, int anyo) {
        getFecha().setAnyo(anyo);
        getFecha().setMes(mes);
        getFecha().setDia(dia);
    }

    public Fecha getFecha() {
        return Fecha;
    }

}
