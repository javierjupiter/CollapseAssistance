import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.fxml.FXML;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class IncidenciasUI {
    @FXML
    private JFXTextField txtMotivo;
    @FXML
    private JFXComboBox<String> comboStatus;
    @FXML
    private JFXDatePicker pickerLaboralesFecha;


    @FXML
    public void initialize(){
        llenarComboboxLaborales();
        llenarMotivo();

    }

    private void llenarMotivo(){
        RequiredFieldValidator validatorClave = new RequiredFieldValidator();
        txtMotivo.getValidators().add(validatorClave);
        validatorClave.setMessage("¡Campo Obligatoro!");
        txtMotivo.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtMotivo.validate();
                }
            }

        });
    }

    private void llenarComboboxLaborales(){
        comboStatus.getItems().add("Activo");
        comboStatus.getItems().add("Inactivo");
    }
}
