import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;

public class ui {
    private Validaciones validaciones;
    @FXML
    private JFXComboBox<String> comboTipoJustificantes;
    @FXML
    private JFXComboBox<String> comboEstatusJustificantes;
    @FXML
    private JFXTextField txtClaveJustificantes;
    @FXML
    private JFXTextField txtApellidoMJustificantes;
    @FXML
    private JFXTextField txtNombreJustificantes;
    @FXML
    private JFXTextField txtApellidoPJustificantes;




    @FXML
    public void initialize(){
        System.out.println("Hola Mundo desde ui.java");
     //   validaciones = new Validaciones();
        llenarComboboxJustificantes();
        validarTXT();


    }

    private void llenarComboboxJustificantes(){
        comboTipoJustificantes.getItems().add("Medica");
        comboTipoJustificantes.getItems().add("Retardo menor");
        comboTipoJustificantes.getItems().add("Retardo mayor");
        comboTipoJustificantes.setPromptText("Tipo incidencia");
        comboEstatusJustificantes.getItems().add("Activo");
        comboEstatusJustificantes.getItems().add("Inactivo");
        comboEstatusJustificantes.setPromptText("Estatus");
    }
    private void validarTXT(){
        RequiredFieldValidator validatorClave = new RequiredFieldValidator();
        txtClaveJustificantes.getValidators().add(validatorClave);
        txtNombreJustificantes.getValidators().add(validatorClave);
        txtApellidoMJustificantes.getValidators().add(validatorClave);
        txtApellidoPJustificantes.getValidators().add(validatorClave);
        validatorClave.setMessage("¡Campo Obligatoro!");
        txtClaveJustificantes.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtClaveJustificantes.validate();
                }
            }
            //}
        });
        txtNombreJustificantes.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtNombreJustificantes.validate();
                }
            }
            //}
        });
        txtApellidoPJustificantes.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtApellidoPJustificantes.validate();
                }
            }
            //}
        });
        txtApellidoMJustificantes.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    //if (!txtIdHorario.getText().matches(validaciones.getRegexClave())) {
                    //if(!validaciones.validarClave(txtIdHorario.getText())){
                    txtApellidoMJustificantes.validate();
                }
            }
            //}
        });
    }
}
