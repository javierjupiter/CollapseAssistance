import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.fxml.FXML;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.sql.Connection;

public class RegistroEmpleadosUI {

    private JFXTextField txtIdEmpleadoREmpleados;

    private JFXComboBox<String> comboMunicipioREmpleados;

    private JFXDatePicker pickerFechaREmpleados;

    private JFXButton btnGuardarREmpleados;

    private JFXTextField txtNombresREmpleados;

    private JFXTextField txtCurpREmpleados;

    private JFXTextField txtNumeroExtREmpleados;

    private JFXTextField txtCodigoPostalREmpleados;

    private JFXTextField txtApellidoMaternoREmpleados;

    private JFXTextField txtCalleREmpleados;

    private JFXTextField txtColoniaREmpleados;

    private JFXTextField txtApellidoPaternoREmpleados;

    private JFXTextField txtNumeroIntREmpleados;

    private JFXComboBox<String> comboEstadoREmpleados;

    private Connection connection;



    private void validacionTextField(){
        RequiredFieldValidator validatorClave = new RequiredFieldValidator();
        txtIdEmpleadoREmpleados.getValidators().add(validatorClave);
        txtCalleREmpleados.getValidators().add(validatorClave);
        txtColoniaREmpleados.getValidators().add(validatorClave);
        txtNombresREmpleados.getValidators().add(validatorClave);
        txtCurpREmpleados.getValidators().add(validatorClave);
        txtNumeroExtREmpleados.getValidators().add(validatorClave);
        txtCodigoPostalREmpleados.getValidators().add(validatorClave);
        txtApellidoPaternoREmpleados.getValidators().add(validatorClave);
        txtNumeroIntREmpleados.getValidators().add(validatorClave);
        //txtEstatus.getValidators().add(validatorClave);
        validatorClave.setMessage("¡Campo Obligatoro!");
        txtIdEmpleadoREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtIdEmpleadoREmpleados.validate();
                }
            }
            //}
        });
        txtCalleREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtCalleREmpleados.validate();
                }
            }
            //}
        });
        txtColoniaREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtColoniaREmpleados.validate();
                }
            }
            //}
        });
        txtNombresREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtNombresREmpleados.validate();
                }
            }
            //}
        });
        txtCurpREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtCurpREmpleados.validate();
                }
            }
            //}
        });
        txtNumeroExtREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtNumeroExtREmpleados.validate();
                }
            }
            //}
        });
        txtCodigoPostalREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtCodigoPostalREmpleados.validate();
                }
            }
            //}
        });
        txtApellidoPaternoREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtApellidoPaternoREmpleados.validate();
                }
            }
            //}
        });
        txtNumeroIntREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtNumeroIntREmpleados.validate();
                }
            }
            //}
        });
    }


    public RegistroEmpleadosUI (JFXTextField txtIdEmpleadoREmpleados, JFXComboBox<String> comboMunicipioREmpleados, JFXDatePicker pickerFechaREmpleados, JFXButton btnGuardarREmpleados, JFXTextField txtNombresREmpleados, JFXTextField txtCurpREmpleados, JFXTextField txtNumeroExtREmpleados, JFXTextField txtCodigoPostalREmpleados, JFXTextField txtApellidoMaternoREmpleados, JFXTextField txtCalleREmpleados, JFXTextField txtColoniaREmpleados, JFXTextField txtApellidoPaternoREmpleados, JFXTextField txtNumeroIntREmpleados, JFXComboBox<String> comboEstadoREmpleados){
        this.txtIdEmpleadoREmpleados = txtIdEmpleadoREmpleados;
        this.comboMunicipioREmpleados = comboMunicipioREmpleados;
        this.pickerFechaREmpleados = pickerFechaREmpleados;
        this.btnGuardarREmpleados = btnGuardarREmpleados;
        this.txtNombresREmpleados = txtNombresREmpleados;
        this.txtCurpREmpleados = txtCurpREmpleados;
        this.txtNumeroExtREmpleados = txtNumeroExtREmpleados;
        this.txtCodigoPostalREmpleados = txtCodigoPostalREmpleados;
        this.txtApellidoMaternoREmpleados = txtApellidoMaternoREmpleados;
        this.txtCalleREmpleados = txtCalleREmpleados;
        this.txtColoniaREmpleados = txtColoniaREmpleados;
        this.txtApellidoPaternoREmpleados = txtApellidoPaternoREmpleados;
        this.txtNumeroIntREmpleados = txtNumeroIntREmpleados;
        this.comboEstadoREmpleados = comboEstadoREmpleados;
        comboboxEmpleados();
        System.out.println("Hola Mundo");
        validacionTextField();
    }
    public RegistroEmpleadosUI (JFXTextField txtIdEmpleadoREmpleados, JFXComboBox<String> comboMunicipioREmpleados, JFXDatePicker pickerFechaREmpleados, JFXButton btnGuardarREmpleados, JFXTextField txtNombresREmpleados, JFXTextField txtCurpREmpleados, JFXTextField txtNumeroExtREmpleados, JFXTextField txtCodigoPostalREmpleados, JFXTextField txtApellidoMaternoREmpleados, JFXTextField txtCalleREmpleados, JFXTextField txtColoniaREmpleados, JFXTextField txtApellidoPaternoREmpleados, JFXTextField txtNumeroIntREmpleados, JFXComboBox<String> comboEstadoREmpleados, Connection conn){
        this.txtIdEmpleadoREmpleados = txtIdEmpleadoREmpleados;
        this.comboMunicipioREmpleados = comboMunicipioREmpleados;
        this.pickerFechaREmpleados = pickerFechaREmpleados;
        this.btnGuardarREmpleados = btnGuardarREmpleados;
        this.txtNombresREmpleados = txtNombresREmpleados;
        this.txtCurpREmpleados = txtCurpREmpleados;
        this.txtNumeroExtREmpleados = txtNumeroExtREmpleados;
        this.txtCodigoPostalREmpleados = txtCodigoPostalREmpleados;
        this.txtApellidoMaternoREmpleados = txtApellidoMaternoREmpleados;
        this.txtCalleREmpleados = txtCalleREmpleados;
        this.txtColoniaREmpleados = txtColoniaREmpleados;
        this.txtApellidoPaternoREmpleados = txtApellidoPaternoREmpleados;
        this.txtNumeroIntREmpleados = txtNumeroIntREmpleados;
        this.comboEstadoREmpleados = comboEstadoREmpleados;
        this.connection = conn;
        comboboxEmpleados();
        System.out.println("Hola Mundo");
        validacionTextField();
    }

    private void comboboxEmpleados(){
        comboMunicipioREmpleados.setDisable(true);
        comboEstadoREmpleados.getItems().add("Aguascalientes");
        comboEstadoREmpleados.getItems().add("Baja California");
        comboEstadoREmpleados.getItems().add("Baja California Sur");
        comboEstadoREmpleados.getItems().add("Campeche");
        comboEstadoREmpleados.getItems().add("Coahuila");
        comboEstadoREmpleados.getItems().add("Colima");
        comboEstadoREmpleados.getItems().add("Chiapas");
        comboEstadoREmpleados.getItems().add("Durango");
        comboEstadoREmpleados.getItems().add("CDMX");
        comboEstadoREmpleados.getItems().add("Guanajuato");
        comboEstadoREmpleados.getItems().add("Guerrero");
        comboEstadoREmpleados.getItems().add("Hidalgo");
        comboEstadoREmpleados.getItems().add("Jalisco");
        comboEstadoREmpleados.getItems().add("Estado de Mexico");
        comboEstadoREmpleados.getItems().add("Michoacan");
        comboEstadoREmpleados.getItems().add("Morelos");
        comboEstadoREmpleados.getItems().add("Nayarit");
        comboEstadoREmpleados.getItems().add("Nuevo Leon");
        comboEstadoREmpleados.getItems().add("Oaxaca");
        comboEstadoREmpleados.getItems().add("Puebla");
        comboEstadoREmpleados.getItems().add("Queretaro");
        comboEstadoREmpleados.getItems().add("Quintana Roo");
        comboEstadoREmpleados.getItems().add("San Luis Potosi");
        comboEstadoREmpleados.getItems().add("Sinaloa");
        comboEstadoREmpleados.getItems().add("Sonora");
        comboEstadoREmpleados.getItems().add("Tabasco");
        comboEstadoREmpleados.getItems().add("Tamaulipas");
        comboEstadoREmpleados.getItems().add("Tlaxcala");
        comboEstadoREmpleados.getItems().add("Veracruz");
        comboEstadoREmpleados.getItems().add("Yucatan");
        comboEstadoREmpleados.getItems().add("Zacatecas");
    }
}
