import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.fxml.FXML;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.sql.Connection;

public class RegistroIncidenciasUI {

    private  Connection connection;

    private JFXTextField txtClaveRegistroIncidencias;

    private JFXDatePicker pickerIncidenciaFechaRegistroIncidencias;

    private JFXDatePicker pickerInsercionRegistroIncidencias;

    private JFXComboBox<String> comboTipoRegistroIncidencias;

    private JFXComboBox<String> comboStatusRegistroIncidencias;

    private JFXButton btnGuardarRegistroIncidencias;

    public RegistroIncidenciasUI(JFXTextField txtClaveRegistroIncidencias, JFXDatePicker pickerIncidenciaFechaRegistroIncidencias, JFXDatePicker pickerInsercionRegistroIncidencias, JFXComboBox<String> comboTipoRegistroIncidencias, JFXComboBox<String> comboStatusRegistroIncidencias, JFXButton btnGuardarRegistroIncidencias){
        System.out.println("Hola desde Incidencias");
        this.txtClaveRegistroIncidencias=txtClaveRegistroIncidencias;
        this.pickerIncidenciaFechaRegistroIncidencias=pickerIncidenciaFechaRegistroIncidencias;
        this.pickerInsercionRegistroIncidencias=pickerInsercionRegistroIncidencias;
        this.comboTipoRegistroIncidencias=comboTipoRegistroIncidencias;
        this.comboStatusRegistroIncidencias=comboStatusRegistroIncidencias;
        this.btnGuardarRegistroIncidencias=btnGuardarRegistroIncidencias;
    }

    public RegistroIncidenciasUI(JFXTextField txtClaveRegistroIncidencias, JFXDatePicker pickerIncidenciaFechaRegistroIncidencias, JFXDatePicker pickerInsercionRegistroIncidencias, JFXComboBox comboTipoRegistroIncidencias, JFXComboBox comboStatusRegistroIncidencias, JFXButton btnGuardarRegistroIncidencias, Connection connection){
        this.txtClaveRegistroIncidencias=txtClaveRegistroIncidencias;
        this.pickerIncidenciaFechaRegistroIncidencias=pickerIncidenciaFechaRegistroIncidencias;
        this.pickerInsercionRegistroIncidencias=pickerInsercionRegistroIncidencias;
        this.comboTipoRegistroIncidencias=comboTipoRegistroIncidencias;
        this.comboStatusRegistroIncidencias=comboStatusRegistroIncidencias;
        this.btnGuardarRegistroIncidencias=btnGuardarRegistroIncidencias;
        this.connection=connection;
    }

    @FXML
    public void initialize(){
        llenarComboboxIncidencias();
        llenarComboboxStatus();
        validarTextFieldIncidencias();
    }

    private void validarTextFieldIncidencias(){
        RequiredFieldValidator validatorClave = new RequiredFieldValidator();
        txtClaveRegistroIncidencias.getValidators().add(validatorClave);
        validatorClave.setMessage("¡Campo Obligatoro!");
        txtClaveRegistroIncidencias.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {

                    txtClaveRegistroIncidencias.validate();
                }
            }

        });
    }

    private void llenarComboboxIncidencias(){

        comboTipoRegistroIncidencias.getItems().add("Interna");
        comboTipoRegistroIncidencias.getItems().add("Externa");
    }

    private void llenarComboboxStatus(){
        comboStatusRegistroIncidencias.getItems().add("Activa");
        comboStatusRegistroIncidencias.getItems().add("Inactiva");
    }
}
