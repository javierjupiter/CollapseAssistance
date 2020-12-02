public class Estados {
    private String IdEstado;
    private String nombre;

    public Estados(String IdEstado, String nombre){
        this.IdEstado = IdEstado;
        this.nombre = nombre;
    }

    public String getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(String idEstado) {
        IdEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
