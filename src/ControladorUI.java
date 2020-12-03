import com.jfoenix.controls.*;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class ControladorUI {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private Connection connection;

    //Inicia propiedades del menú
    @FXML
    private SVGPath btnLogo;
    @FXML
    private SVGPath btnHome;
    @FXML
    private SVGPath btnREmpleados;
    @FXML
    private SVGPath btnRHorarios;
    @FXML
    private SVGPath btnDiasLaborales;
    @FXML
    private SVGPath btnAsistencias;
    @FXML
    private SVGPath btnRJustificantes;
    @FXML
    private SVGPath btnConfiguraciones;
    @FXML
    private Label lblHora;
    @FXML
    private Label lblMinutos;
    @FXML
    private Label lblMeridian;
    //Finaliza propiedades del menú

    //Inician propiedades de pantallas
    @FXML
    private VBox vboxPantallas;
    @FXML
    private VBox vboxHome;
    @FXML
    private Label lblTitulo;
    @FXML
    private VBox vBoxREmpleados;
    @FXML
    private VBox vboxRJustificantes;
    @FXML
    private VBox vboxRIncidencias;
    @FXML
    private VBox vboxHorarios;
    @FXML
    private VBox vboxDiasLaborales;
    @FXML
    private VBox vboxRAsistencias;
    @FXML
    private VBox vboxConfiguraciones;
    //Finalizan propiedades de pantallas

    //INICIA PROPIEDADES DE HORARIOS
    @FXML
    private JFXTextField txtIdHorarioHorarios;

    @FXML
    private JFXTextField txtDescripcionHorarioHorarios;

    @FXML
    private JFXTextField txtEstatusHorarios;

    @FXML
    private JFXButton btnGuardarHorarios;

    private void validacionTextFildHorarios() {
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

    @FXML
    public void btnGuardarHorariosOnClicked(){
        System.out.println("Guardar");
    }
    //FINALIZA PROPIEDADES DE HORARIOS



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

    //Finaliza propiedades de registro de Incidencias

    //Inicia propiedades de registro de dias laborales
    private DiasLaboralesUI objDiasLaboralesUI;
    @FXML
    private JFXTextField txtMotivoLaborales;
    @FXML
    private JFXComboBox<String> comboStatusDiasLaborables;
    @FXML
    private JFXDatePicker pickerLaboralesFechaLaborales;
    @FXML
    private JFXButton btnGuardarDiasLaborables;

    private void llenarMotivoLaborales(){
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
        comboStatusDiasLaborables.getItems().add("Activo");
        comboStatusDiasLaborables.getItems().add("Inactivo");
    }
    //Finaliza propiedades de registro de dias laborales

    //Inicia propiedades del registro de empleados
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

    private String idMunicipio;
    private String idEstado;

    @FXML
    private void asignarIDMunicipio(){
        BD_Consultas consultas = new BD_Consultas();
        idMunicipio = consultas.hacerConsultasMunicipiosID(connection, comboMunicipioREmpleados.getValue());
        System.out.println(idMunicipio);
    }

    @FXML
    private void hacerRegistroEmpleados(){
        BD_Inserciones inserciones = new BD_Inserciones();
        String fecha=String.valueOf(pickerFechaREmpleados.getValue());
       // JFXDialog dialog = new JFXDialog();
        if  (inserciones.hacerInsercionEmpleado(connection, txtIdEmpleadoREmpleados.getText(), txtNombresREmpleados.getText(),txtApellidoPaternoREmpleados.getText(),txtApellidoMaternoREmpleados.getText(),txtCurpREmpleados.getText(),fecha,txtCalleREmpleados.getText(),txtNumeroExtREmpleados.getText(),txtNumeroIntREmpleados.getText(),txtColoniaREmpleados.getText(),txtCodigoPostalREmpleados.getText(),idEstado,idMunicipio,"A")) {
            System.out.println("Insercion correcta");
           // dialog.setContent(new Label("Insercion Correcta"));
        }
        else
            System.out.println("Insercion Incorrecta");
           // dialog.setContent(new Label("Insercion Incorrecta"));

       // dialog.show();
    }

    private void comboboxEmpleadosEstados(){
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

    public void generarComboMunicipios(int choose){
        comboMunicipioREmpleados.getItems().clear();
        comboMunicipioREmpleados.setDisable(true);
        BD_Consultas consultas = new BD_Consultas();
        consultas.hacerConsultasMunicipios(connection, choose);
        Municipios[] municipios = consultas.getMunicipios();
        for (int i = 0; i < municipios.length; i++){
            comboMunicipioREmpleados.getItems().add(municipios[i].getNombre());
        }
        comboMunicipioREmpleados.setDisable(false);
    }


    @FXML
    public void cargarMunicipios(){
        String listItem = comboEstadoREmpleados.getValue();
        switch (listItem) {
            case "Aguascalientes": //Action for this item
                generarComboMunicipios(1);
                this.idEstado = "1";
                break;
            case "Baja California":
                generarComboMunicipios(2);
                this.idEstado = "2";
                break;

            case "Baja California Sur":
                generarComboMunicipios(3);
                this.idEstado = "3";
                break;
            case "Campeche":
                generarComboMunicipios(4);
                this.idEstado = "4";
                break;
            case "CDMX":
                generarComboMunicipios(10);
                this.idEstado = "10";
                break;
            case "Chiapas":
                generarComboMunicipios(7);
                this.idEstado = "7";
                break;
            case "Chihuaha":
                generarComboMunicipios(8);
                this.idEstado = "8";
                break;
            case "Coahuila":
                generarComboMunicipios(5);
                this.idEstado = "5";
                break;
            case "Colima":
                generarComboMunicipios(6);
                this.idEstado = "6";
                break;
            case "Durango":
                generarComboMunicipios(9);
                this.idEstado = "9";
                break;
            case "Estado de Mexico":
                generarComboMunicipios(15);
                this.idEstado = "15";
                break;
            case "Guanajuato":
                generarComboMunicipios(11);
                this.idEstado = "11";
                break;
            case "Guerrero":
                generarComboMunicipios(12);
                this.idEstado = "12";
                break;
            case "Hidalgo":
                generarComboMunicipios(13);
                this.idEstado = "13";
                break;
            case "Jalisco":
                generarComboMunicipios(14);
                this.idEstado = "14";
                break;
            case "Michoacan":
                generarComboMunicipios(16);
                this.idEstado = "16";
                break;
            case "Morelos":
                generarComboMunicipios(17);
                this.idEstado = "17";
                break;
            case "Nayarit":
                generarComboMunicipios(18);
                this.idEstado = "18";
                break;
            case "Nuevo Leon":
                generarComboMunicipios(19);
                this.idEstado = "19";
                break;
            case "Oaxaca":
                generarComboMunicipios(20);
                this.idEstado = "20";
                break;
            case "Puebla":
                generarComboMunicipios(21);
                this.idEstado = "21";
                break;
            case "Queretaro":
                generarComboMunicipios(22);
                this.idEstado = "22";
                break;
            case "Quintana Roo":
                generarComboMunicipios(23);
                this.idEstado = "23";
                break;
            case "San Luis Potosí":
                generarComboMunicipios(24);
                this.idEstado = "24";
                break;
            case "Sinaloa":
                generarComboMunicipios(25);
                this.idEstado = "25";
                break;
            case "Sonora":
                generarComboMunicipios(26);
                this.idEstado = "26";
                break;
            case "Tabasco":
                generarComboMunicipios(27);
                this.idEstado = "27";
                break;
            case "Tamaulipas":
                generarComboMunicipios(28);
                this.idEstado = "28";
                break;
            case "Tlaxcala":
                generarComboMunicipios(29);
                this.idEstado = "29";
                break;
            case "Veracruz":
                generarComboMunicipios(30);
                this.idEstado = "30";
                break;
            case "Yucatan":
                generarComboMunicipios(31);
                this.idEstado = "31";
                break;
            case "Zacatecas":
                generarComboMunicipios(32);
                this.idEstado = "32";
                break;
                default: //Default action
                    System.out.println("UPS");
                break;
        }
    }

    private void validacionTextFieldEmpleados(){
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
        validatorClave.setMessage("¡Campo Obligatoro!");
        txtIdEmpleadoREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtIdEmpleadoREmpleados.validate();
                }
            }
        });
        txtCalleREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtCalleREmpleados.validate();
                }
            }
        });
        txtColoniaREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtColoniaREmpleados.validate();
                }
            }
        });
        txtNombresREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtNombresREmpleados.validate();
                }
            }
        });
        txtCurpREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtCurpREmpleados.validate();
                }
            }
        });
        txtNumeroExtREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtNumeroExtREmpleados.validate();
                }
            }
        });
        txtCodigoPostalREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtCodigoPostalREmpleados.validate();
                }
            }
        });
        txtApellidoPaternoREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtApellidoPaternoREmpleados.validate();
                }
            }
        });
        txtNumeroIntREmpleados.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtNumeroIntREmpleados.validate();
                }
            }
        });
    }
    //Finaliza propiedades de registro de empleados

    // Inicia registro de justificantes.
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

    private void llenarComboboxJustificantes(){
        this.comboTipoRJustificantes.getItems().add("Medica");
        this.comboTipoRJustificantes.getItems().add("Retardo menor");
        this.comboTipoRJustificantes.getItems().add("Retardo mayor");
        this.comboTipoRJustificantes.setPromptText("Tipo incidencia");
        this.comboEstatusRJustificantes.getItems().add("Activo");
        this.comboEstatusRJustificantes.getItems().add("Inactivo");
        this.comboEstatusRJustificantes.setPromptText("Estatus");
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
                    txtClaveRJustificantes.validate();
                }
            }
            //}
        });
        txtNombreRJustificantes.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtNombreRJustificantes.validate();
                }
            }
        });
        txtApellidoPRJustificantes.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    txtApellidoPRJustificantes.validate();
                }
            }
        });
        txtApellidoMRJustificantes.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {

                    txtApellidoMRJustificantes.validate();
                }
            }
        });
    }
    // Finaliza propiedades registro de justificantes.

    //Inicias propiedades de configuraciones
    @FXML
    private JFXTextField txtPassword;
    @FXML
    private  JFXButton btnSetPass;
    @FXML
    public void iniciarConexion(){
        Conexion conexion = new Conexion(txtPassword.getText());
        connection = conexion.getConnection();
        if (connection != null){
            System.out.println("Conexión lista");
            vBoxREmpleados.setDisable(false);
            vboxHorarios.setDisable(false);
            vboxDiasLaborales.setDisable(false);
            vboxRAsistencias.setDisable(false);
            vboxRJustificantes.setDisable(false);
        }
    }
    //Finalizan propiedades de configuraciones

    @FXML
    public void initialize(){
        vBoxREmpleados.setDisable(true);
        vboxHorarios.setDisable(true);
        vboxDiasLaborales.setDisable(true);
        vboxRAsistencias.setDisable(true);
        vboxRJustificantes.setDisable(true);

        validacionTextFildHorarios();
        llenarComboboxJustificantes();
        validarTXT();
        comboboxEmpleadosEstados();
        validacionTextFieldEmpleados();
        llenarComboboxLaborales();
        llenarMotivoLaborales();
        System.out.println("Pantalla inicializadas");
    }

    @FXML
    public void mostrarInicio(){
        vboxHome.setVisible(true);
        vboxPantallas.setVisible(false);
    }

    @FXML
    public void mostrarRegistrosEmpleados(){
        vboxHome.setVisible(false);
        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(true);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        vboxConfiguraciones.setVisible(false);
        lblTitulo.setText("Registro de empleados");
    }

    @FXML
    public void mostrarRegistrosHorarios(){
        vboxHome.setVisible(false);
        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(true);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        vboxConfiguraciones.setVisible(false);
        lblTitulo.setText("Registro de horarios");
    }

    @FXML
    public void mostrarRegistrosDiasLaborales(){
        vboxHome.setVisible(false);
        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(true);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        vboxConfiguraciones.setVisible(false);
        lblTitulo.setText("Registro de Días no Laborales");
    }

    @FXML
    public void mostrarRegistrosAsistencias(){
        vboxHome.setVisible(false);
        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(true);
        vboxRJustificantes.setVisible(false);
        vboxConfiguraciones.setVisible(false);
        lblTitulo.setText("Registro de asistencias");
    }

    @FXML
    public void mostrarRegistrosJustificantes(){
        vboxHome.setVisible(false);
        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(true);
        vboxConfiguraciones.setVisible(false);
        lblTitulo.setText("Registro de justificantes");
    }

    @FXML
    public void mostrarConfiguraciones(){
        vboxHome.setVisible(false);
        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        vboxConfiguraciones.setVisible(true);
        lblTitulo.setText("Configuaciones");
    }
}
