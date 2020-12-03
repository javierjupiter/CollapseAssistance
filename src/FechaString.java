import javafx.beans.property.StringProperty;

public class FechaString {
    private StringProperty dia;
    private StringProperty mes;
    private StringProperty anio;

    public String getDia() {
        return dia.get();
    }

    public StringProperty diaProperty() {
        return dia;
    }

    public String getMes() {
        return mes.get();
    }

    public StringProperty mesProperty() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes.set(mes);
    }

    public String getAnio() {
        return anio.get();
    }

    public StringProperty anioProperty() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio.set(anio);
    }

    public void setDia(String dia) {
        this.dia.set(dia);
    }
}
