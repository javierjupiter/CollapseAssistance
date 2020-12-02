import com.jfoenix.controls.JFXButton;
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

    @FXML
    public void initialize(){
        objHorariosUI = new HorariosUI(txtIdHorarioHorarios,txtDescripcionHorarioHorarios,txtEstatusHorarios,btnGuardarHorarios);

    }
}
