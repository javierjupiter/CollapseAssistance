import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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

    //Inicia propiedades de registro de Incidencias
    @FXML
    private RegistroIncidenciasUI objRegistroIncidenciasUI;
    @FXML
    private JFXTextField txtClaveRegistroIncidencias;
    @FXML
    private JFXDatePicker pickerIncidenciaFechaRegistroIncidencias;
    @FXML
    private JFXDatePicker pickerInsercionRegistroIncidencias;
    @FXML
    private JFXComboBox comboTipoRegistroIncidencias;
    @FXML
    private JFXComboBox comboStatusRegistroIncidencias;
    @FXML
    private JFXButton btnGuardarRegistroIncidencias;
    //Finaliza propiedades de registro de Incidencias

    //Inicia propiedades de registro de dias laborales
    private DiasLaboralesUI objDiasLaboralesUI;
    @FXML
    private JFXTextField txtMotivoLaborales;
    @FXML
    private JFXComboBox<String> comboStatusLaborales;
    @FXML
    private JFXDatePicker pickerLaboralesFechaLaborales;
    @FXML
    private JFXButton btnGuardarDiasLaborables;
    //Finaliza propiedades de registro de dias laborales

    //Inicia propiedades del registro de empleados
    private RegistroEmpleadosUI objRegitroEmpleadosUI;
    @FXML
    private JFXTextField txtIdEmpleadoREmpleados;
    @FXML
    private JFXComboBox<String> comboMunicipioREmpleados;
    @FXML
    private JFXDatePicker pickerFechaREmpleados;
    @FXML
    private JFXButton btnGuardarREmpleados;
    @FXML
    private JFXTextField txtNombresREmpleados;
    @FXML
    private JFXTextField txtCurpREmpleados;
    @FXML
    private JFXTextField txtNumeroExtREmpleados;
    @FXML
    private JFXTextField txtCodigoPostalREmpleados;
    @FXML
    private JFXTextField txtApellidoMaternoREmpleados;
    @FXML
    private JFXTextField txtCalleREmpleados;
    @FXML
    private JFXTextField txtColoniaREmpleados;
    @FXML
    private JFXTextField txtApellidoPaternoREmpleados;
    @FXML
    private JFXTextField txtNumeroIntREmpleados;
    @FXML
    private JFXComboBox<String> comboEstadoREmpleados;
    //Finaliza propiedades de registro de empleados

    @FXML
    public void initialize(){
        objDiasLaboralesUI = new DiasLaboralesUI(txtMotivoLaborales,comboStatusLaborales,pickerLaboralesFechaLaborales,btnGuardarDiasLaborables);
        objHorariosUI = new HorariosUI(txtIdHorarioHorarios,txtDescripcionHorarioHorarios,txtEstatusHorarios,btnGuardarHorarios);
        objRJustificantesUI = new RegistroJustificantesUI(comboTipoRJustificantes, comboEstatusRJustificantes, txtClaveRJustificantes, txtApellidoMRJustificantes, txtNombreRJustificantes, txtApellidoPRJustificantes, btnGuardaRJustificantes);
        objRegistroIncidenciasUI = new RegistroIncidenciasUI(txtClaveRegistroIncidencias,pickerIncidenciaFechaRegistroIncidencias,pickerInsercionRegistroIncidencias,comboTipoRegistroIncidencias,comboStatusRegistroIncidencias,btnGuardarRegistroIncidencias);
        objRegitroEmpleadosUI = new RegistroEmpleadosUI(txtIdEmpleadoREmpleados, comboMunicipioREmpleados, pickerFechaREmpleados, btnGuardarREmpleados, txtNombresREmpleados, txtCurpREmpleados, txtNumeroExtREmpleados, txtCodigoPostalREmpleados, txtApellidoMaternoREmpleados, txtCalleREmpleados, txtColoniaREmpleados, txtApellidoPaternoREmpleados, txtNumeroIntREmpleados, comboEstadoREmpleados);
    }
}
