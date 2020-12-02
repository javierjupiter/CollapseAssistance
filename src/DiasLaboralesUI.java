import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.sql.Connection;

public class DiasLaboralesUI {

    private JFXTextField txtMotivoLaborales;
    private JFXComboBox<String> comboStatusLaborales;
    private JFXDatePicker pickerLaboralesFechaLaborales;
    private JFXButton btnGuardarDiasLaborables;
    private Connection connection;


    public DiasLaboralesUI(JFXTextField txtMotivoLaborales, JFXComboBox comboStatusLaborales, JFXDatePicker pickerLaboralesFechaLaborales, JFXButton btnGuardarDiasLaborables){
        this.btnGuardarDiasLaborables=btnGuardarDiasLaborables;
        this.txtMotivoLaborales=txtMotivoLaborales;
        this.comboStatusLaborales=comboStatusLaborales;
        this.pickerLaboralesFechaLaborales=pickerLaboralesFechaLaborales;
        llenarComboboxLaborales();
        llenarMotivo();

    }

    public DiasLaboralesUI(JFXTextField txtMotivoLaborales, JFXComboBox comboStatusLaborales, JFXDatePicker pickerLaboralesFechaLaborales, JFXButton btnGuardarDiasLaborables, Connection connection){
        this.btnGuardarDiasLaborables=btnGuardarDiasLaborables;
        this.txtMotivoLaborales=txtMotivoLaborales;
        this.comboStatusLaborales=comboStatusLaborales;
        this.pickerLaboralesFechaLaborales=pickerLaboralesFechaLaborales;
        this.connection=connection;
        llenarComboboxLaborales();
        llenarMotivo();

    }

    private void llenarMotivo(){
        RequiredFieldValidator validatorClave = new RequiredFieldValidator();
        txtMotivoLaborales.getValidators().add(validatorClave);
        validatorClave.setMessage("¡Campo Obligatoro!");
        txtMotivoLaborales.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtMotivoLaborales.validate();
                }
            }

        });
    }

    private void llenarComboboxLaborales(){
        comboStatusLaborales.getItems().add("Activo");
        comboStatusLaborales.getItems().add("Inactivo");
    }
}
