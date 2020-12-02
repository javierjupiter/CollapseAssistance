import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //INICIA PROPIEDADES DE HORARIOS
    private HorariosUI objHorariosUI;

    @FXML
    private JFXTextField txtIdHorarioHorarios;

    @FXML
    private JFXTextField txtDescripcionHorarioHorarios;

    @FXML
    private JFXTextField txtEstatusHorarios;

    @FXML
    private JFXButton btnGuardarHorarios;
    //FINALIZA PROPIEDADES DE HORARIOS

    // Inicia propiedades registro de justificantes.
    private RegistroJustificantesUI objRJustificantesUI;
    @FXML
    private JFXComboBox<String> comboTipoRJustificantes;
    @FXML
    private JFXComboBox<String> comboEstatusRJustificantes;
    @FXML
    private JFXTextField txtClaveRJustificantes;
    @FXML
    private JFXTextField txtApellidoMRJustificantes;
    @FXML
    private JFXTextField txtNombreRJustificantes;
    @FXML
    private JFXTextField txtApellidoPRJustificantes;
    @FXML
    private JFXButton btnGuardaRJustificantes;
    // Finaliza propiedades registro de justificantes.

    @FXML
    public void initialize(){
        objHorariosUI = new HorariosUI(txtIdHorarioHorarios,txtDescripcionHorarioHorarios,txtEstatusHorarios,btnGuardarHorarios);
        objRJustificantesUI = new RegistroJustificantesUI(comboTipoRJustificantes, comboEstatusRJustificantes, txtClaveRJustificantes, txtApellidoMRJustificantes, txtNombreRJustificantes, txtApellidoPRJustificantes, btnGuardaRJustificantes);


    }
}