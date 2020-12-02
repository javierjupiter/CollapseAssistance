public class Empleado {

    private String nombreE;
    private String apllidoPaternoE;
    private String apllidoMaternoE;
    private String curpE;
    private Fecha fechaContratacionE;
    private String claveE;
    private String calle;
    private String numeroExterior;
    private String numeroInterior;
    private String colonia;
    private String codigoPostal;
    private String estado;
    private String Estado;
    private String municipio;

    public Empleado(){
        fechaContratacionE = new Fecha();
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




    public String getFechaContratacionE() {
        String fecha = (fechaContratacionE.getDia() + "-" + fechaContratacionE.getMes() + "-" + fechaContratacionE.getAnyo());
        return fecha;
    }


    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
