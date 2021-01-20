public class Empleado {
    private String claveE;
    private String nombreE;
    private String apllidoPaternoE;
    private String apllidoMaternoE;
    private String curpE;
    private String fechaContratacionE;
    private String calle;
    private String numeroExterior;
    private String numeroInterior;
    private String colonia;
    private String codigoPostal;
    private String estado;
    private String Estado;
    private String municipio;
    private String status;


    public Empleado(String claveE, String nombreE, String apllidoPaternoE, String apllidoMaternoE, String curpE, String fechaContratacionE, String calle, String numeroExterior, String numeroInterior, String colonia, String codigoPostal, String estado, String municipio, String status) {
        this.claveE = claveE;
        this.nombreE = nombreE;
        this.apllidoPaternoE = apllidoPaternoE;
        this.apllidoMaternoE = apllidoMaternoE;
        this.curpE = curpE;
        this.fechaContratacionE = fechaContratacionE;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.municipio = municipio;
        this.status = status;
    }

    public Empleado(String nombreE, String apllidoPaternoE, String apllidoMaternoE, String claveE) {
        this.nombreE = nombreE;
        this.apllidoPaternoE = apllidoPaternoE;
        this.apllidoMaternoE = apllidoMaternoE;
        this.claveE = claveE;
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
