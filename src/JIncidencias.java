public class JIncidencias {

    private String fechaIncidencia;
    private String tipoIncidencia;
    private String statusIncidencia;
    private String IDEmpleado;

    public JIncidencias(String fechaIncidencia, String tipoIncidencia, String statusIncidencia, String IDEmpleado) {
        this.fechaIncidencia = fechaIncidencia;
        this.tipoIncidencia = tipoIncidencia;
        this.statusIncidencia = statusIncidencia;
        this.IDEmpleado = IDEmpleado;
    }

    public String getFechaIncidencia() {
        return fechaIncidencia;
    }

    public void setFechaIncidencia(String fechaIncidencia) {
        this.fechaIncidencia = fechaIncidencia;
    }

    public String getTipoIncidencia() {
        return tipoIncidencia;
    }

    public void setTipoIncidencia(String tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    public String getStatusIncidencia() {
        return statusIncidencia;
    }

    public void setStatusIncidencia(String statusIncidencia) {
        this.statusIncidencia = statusIncidencia;
    }
}
