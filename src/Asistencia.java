import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Asistencia extends RecursiveTreeObject<Asistencia> {
    private StringProperty clave;
    private StringProperty fechaRegistro;
    private StringProperty numeroBiometrico;
    private StringProperty statusRegistro;
    private StringProperty numero;

    public String getNumero() {
        return numero.get();
    }

    public StringProperty numeroProperty() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero.set(numero);
    }

    public String getClave() { return clave.get(); }

    public void setClave(String clave) {
        this.clave.set(clave);
    }

    public String getNumeroBiometrico() {
        return numeroBiometrico.get();
    }

    public void setNumeroBiometrico(String numeroBiometrico) {
        this.numeroBiometrico.set(numeroBiometrico);
    }

    public String getStatusRegistro() {
        return statusRegistro.get();
    }

    public void setStatusRegistro(String statusRegistro) {
        this.statusRegistro.set(statusRegistro);
    }

    public String getFechaRegistro() {
        return fechaRegistro.get();
    }

    public StringProperty fechaRegistroProperty() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro.set(fechaRegistro);
    }


    public StringProperty claveProperty()
    {
        return this.clave;
    }

    public StringProperty numero()
    {
        return this.numero;
    }

    public StringProperty StatusRegistroProperty()
    {
        return  this.statusRegistro;
    }

    public StringProperty numBiometricoProperty()
    {
        return  this.numeroBiometrico;
    }

    // constructor

    public Asistencia(String clave,String fechaRegistro, String numeroBiometrico, String statusRegistro, String  numero)
    {
        this.clave = new SimpleStringProperty(clave);
        this.fechaRegistro = new SimpleStringProperty(fechaRegistro);
        this.numeroBiometrico = new SimpleStringProperty(numeroBiometrico);
        this.statusRegistro = new SimpleStringProperty(statusRegistro);
        this.numero = new SimpleStringProperty(numero);
    }


}
