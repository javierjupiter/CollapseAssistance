import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.sql.Connection;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class  HorariosUI {

    private Connection connection;

    private JFXTextField txtIdHorarioHorarios;

    private JFXTextField txtDescripcionHorarioHorarios;

    private JFXTextField txtEstatusHorarios;

    private JFXButton btnGuardarHorarios;

    public HorariosUI(JFXTextField txtIdHorarioHorarios, JFXTextField txtDescripcionHorarioHorarios, JFXTextField txtEstatusHorarios,JFXButton btnGuardarHorarios) {
        System.out.println("HOLA MUNDO DESDE HorariosUI.java");
        this.txtIdHorarioHorarios = txtIdHorarioHorarios;
        this.txtDescripcionHorarioHorarios = txtDescripcionHorarioHorarios;
        this.txtEstatusHorarios = txtEstatusHorarios;
        this.btnGuardarHorarios = btnGuardarHorarios;
        validacionTextFild();
    }

    public HorariosUI(JFXTextField txtIdHorarioHorarios, JFXTextField txtDescripcionHorarioHorarios, JFXTextField txtEstatusHorarios, JFXButton btnGuardarHorarios, Connection connection) {
        System.out.println("HOLA MUNDO DESDE HorariosUI.java");
        this.txtIdHorarioHorarios = txtIdHorarioHorarios;
        this.txtDescripcionHorarioHorarios = txtDescripcionHorarioHorarios;
        this.txtEstatusHorarios = txtEstatusHorarios;
        this.btnGuardarHorarios = btnGuardarHorarios;
        this.connection = connection;
        validacionTextFild();
    }
    private void validacionTextFild() {
        RequiredFieldValidator validatorClave = new RequiredFieldValidator();
        txtIdHorarioHorarios.getValidators().add(validatorClave);
        txtDescripcionHorarioHorarios.getValidators().add(validatorClave);
        txtEstatusHorarios.getValidators().add(validatorClave);
        validatorClave.setMessage("¡Campo Obligatoro!");
        txtIdHorarioHorarios.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtIdHorarioHorarios.validate();
                }
            }
        });
        txtDescripcionHorarioHorarios.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtDescripcionHorarioHorarios.validate();
                }
            }
        });
        txtEstatusHorarios.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtEstatusHorarios.validate();
                }
            }
        });

    }
}