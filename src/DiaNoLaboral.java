public class DiaNoLaboral {
    private String fecha;
    private String descripcion;
    private String status;

    public DiaNoLaboral(String fecha, String descripcion, String status) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.status = status;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
