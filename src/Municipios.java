public class Municipios {
    private String idMunicipio;
    private String nombre;
    private String idEstado;

    public Municipios(String idMunicipio, String nombre, String idEstado){
        this.idMunicipio = idMunicipio;
        this.nombre = nombre;
        this.idEstado = idEstado;
    }

    public String getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }
}
