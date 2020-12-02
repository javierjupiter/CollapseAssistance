import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.sql.Connection;

public class RegistroJustificantesUI {
    private Validaciones validaciones;
    private JFXComboBox<String> comboTipoRJustificantes;
    private JFXComboBox<String> comboEstatusRJustificantes;
    private JFXTextField txtClaveRJustificantes;
    private JFXTextField txtApellidoMRJustificantes;
    private JFXTextField txtNombreRJustificantes;
    private JFXTextField txtApellidoPRJustificantes;
    private JFXButton btnGuardaRJustificantes;
    private Connection conn;


    public RegistroJustificantesUI (JFXComboBox<String> comboTipoRJustificantes, JFXComboBox<String> comboEstatusRJustificantes, JFXTextField txtClaveRJustificantes, JFXTextField txtApellidoMRJustificantes, JFXTextField txtNombreRJustificantes, JFXTextField txtApellidoPRJustificantes, JFXButton btnGuardaRJustificantes){
        System.out.println("Hola Mundo desde ui.java");
        this.comboTipoRJustificantes = comboTipoRJustificantes;
        this.comboEstatusRJustificantes = comboEstatusRJustificantes;
        this.txtClaveRJustificantes = txtClaveRJustificantes;
        this.txtApellidoMRJustificantes = txtApellidoMRJustificantes;
        this.txtNombreRJustificantes = txtNombreRJustificantes;
        this.txtApellidoPRJustificantes = txtApellidoPRJustificantes;
        this.btnGuardaRJustificantes = btnGuardaRJustificantes;
        llenarComboboxJustificantes();
        validarTXT();

    }

    public RegistroJustificantesUI (JFXComboBox<String> comboTipoRJustificantes, JFXComboBox<String> comboEstatusRJustificantes, JFXTextField txtClaveRJustificantes, JFXTextField txtApellidoMRJustificantes, JFXTextField txtNombreRJustificantes, JFXTextField txtApellidoPRJustificantes, JFXButton btnGuardaRJustificantes, Connection conn){
        System.out.println("Hola Mundo desde ui.java");
        this.comboTipoRJustificantes = comboTipoRJustificantes;
        this.comboEstatusRJustificantes = comboEstatusRJustificantes;
        this.txtClaveRJustificantes = txtClaveRJustificantes;
        this.txtApellidoMRJustificantes = txtApellidoMRJustificantes;
        this.txtNombreRJustificantes = txtNombreRJustificantes;
        this.txtApellidoPRJustificantes = txtApellidoPRJustificantes;
        this.btnGuardaRJustificantes = btnGuardaRJustificantes;
        this.conn = conn;
        llenarComboboxJustificantes();
        validarTXT();

    }

    private void llenarComboboxJustificantes(){
        comboTipoRJustificantes.getItems().add("Medica");
        comboTipoRJustificantes.getItems().add("Retardo menor");
        comboTipoRJustificantes.getItems().add("Retardo mayor");
        comboTipoRJustificantes.setPromptText("Tipo incidencia");
        comboEstatusRJustificantes.getItems().add("Activo");
        comboEstatusRJustificantes.getItems().add("Inactivo");
        comboEstatusRJustificantes.setPromptText("Estatus");
    }
    private void validarTXT(){
        RequiredFieldValidator validatorClave = new RequiredFieldValidator();
        txtClaveRJustificantes.getValidators().add(validatorClave);
        txtNombreRJustificantes.getValidators().add(validatorClave);
        txtApellidoMRJustificantes.getValidators().add(validatorClave);
        txtApellidoPRJustificantes.getValidators().add(validatorClave);
        validatorClave.setMessage("¡Campo Obligatoro!");
        txtClaveRJustificantes.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtClaveRJustificantes.validate();
                }
            }
            //}
        });
        txtNombreRJustificantes.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtNombreRJustificantes.validate();
                }
            }
            //}
        });
        txtApellidoPRJustificantes.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtApellidoPRJustificantes.validate();
                }
            }
            //}
        });
        txtApellidoMRJustificantes.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtApellidoMRJustificantes.validate();
                }
            }
            //}
        });
    }
}
