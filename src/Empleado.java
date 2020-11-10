public class Empleado {

    private String nombreE;
    private String apllidoPaternoE;
    private String apllidoMaternoE;
    private String curpE;
    private Fecha fechaContratacionE;
    private Direccion direccionE;
    private String claveE;

    public Empleado(){
        fechaContratacionE = new Fecha();
        direccionE = new Direccion();
    }

    public String getClaveE() {
        return claveE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public String getApllidoPaternoE() {
        return apllidoPaternoE;
    }

    public String getApllidoMaternoE() {
        return apllidoMaternoE;
    }

    public String getCurpE() {
        return curpE;
    }

    public void setClaveE(String claveE) {
        this.claveE = claveE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public void setApllidoPaternoE(String apllidoPaternoE) {
        this.apllidoPaternoE = apllidoPaternoE;
    }

    public void setApllidoMaternoE(String apllidoMaternoE) {
        this.apllidoMaternoE = apllidoMaternoE;
    }

    public void setCurpE(String curpE) {
        this.curpE = curpE;
    }

    public void setFechaContratacionE(int dia, int mes, int anyo) {
        fechaContratacionE.setAnyo(anyo);
        fechaContratacionE.setMes(mes);
        fechaContratacionE.setDia(dia);
    }

    public void setDireccionE(String  calle, String numeroInterior, String numeroExterior, String colonia, String codigoPostal, String estado, String municipio) {
        direccionE.setCalle(calle);
        direccionE.setCodigoPostal(codigoPostal);
        direccionE.setColonia(colonia);
        direccionE.setEstado(estado);
        direccionE.setNumeroInterior(numeroInterior);
        direccionE.setNumeroExterior(numeroExterior);
        direccionE.setEstado(estado);
        direccionE.setMunicipio(municipio);
    }

    public Fecha getFechaContratacionE() {
        return fechaContratacionE;
    }

    public Direccion getDireccionE() {
        return direccionE;
    }
}
