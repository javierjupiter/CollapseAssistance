import com.jfoenix.controls.*;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import javax.swing.*;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ControladorUI {

    private Connection connection;

    private int posicionPantalla;
    //0: Home, 1: Empleados, 2: Horarios, 3: Días no laborales, 4: Asistencias, 5: Justificantes, 6: Justificar Incidencias, 7:Asignación de horarios

    //Inicia propiedades del menú
    @FXML
    private VBox vboxMenu;
    @FXML
    private HBox hBoxPestanyas;
    @FXML
    private HBox panePestanyasFondo;
    @FXML
    private VBox vBoxJustificantes;
    @FXML
    private Pane paneAgregar;
    @FXML
    private Pane paneBuscar;
    @FXML
    private Pane paneHome;
    @FXML
    private Pane paneREmpleados;
    @FXML
    private Pane paneRHorarios;
    @FXML
    private Pane paneDiasLaborales;
    @FXML
    private Pane paneAsistencias;
    @FXML
    private Pane paneRJustificantes;
    @FXML
    private Pane paneJIncidencias;
    @FXML
    private Pane paneAHorario;
    @FXML
    private Pane paneReloj;
    @FXML
    private Label lblHora;
    @FXML
    private Label lblMinutos;
    @FXML
    private Label lblMeridian;
    @FXML
    private Label lblFecha;

    public void crearMenuLateral(){
        JFXRippler ripplerHome = new JFXRippler(paneHome);
        ripplerHome.setRipplerFill(Paint.valueOf("#FE81BB"));
        vboxMenu.getChildren().add(ripplerHome);

        Tooltip tooltipHome = new Tooltip("Inicio");

        Tooltip.install(paneHome, tooltipHome);

        JFXRippler ripplerREmpleados = new JFXRippler(paneREmpleados);
        ripplerREmpleados.setRipplerFill(Paint.valueOf("#FE81BB"));
        vboxMenu.getChildren().add(ripplerREmpleados);
        Tooltip tooltipREmpleados = new Tooltip("Empleados");
        Tooltip.install(paneREmpleados, tooltipREmpleados);

        JFXRippler ripplerRHorarios = new JFXRippler(paneRHorarios);
        ripplerRHorarios.setRipplerFill(Paint.valueOf("#FE81BB"));
        vboxMenu.getChildren().add(ripplerRHorarios);
        Tooltip tooltipRHorarios = new Tooltip("Horarios");
        Tooltip.install(paneRHorarios, tooltipRHorarios);

        JFXRippler ripplerDiasLaborales = new JFXRippler(paneDiasLaborales);
        ripplerDiasLaborales.setRipplerFill(Paint.valueOf("#FE81BB"));
        vboxMenu.getChildren().add(ripplerDiasLaborales);
        Tooltip tooltipDiasLaborales = new Tooltip("Dias No Laborales");
        Tooltip.install(paneDiasLaborales, tooltipDiasLaborales);

        JFXRippler ripplerAsistencias = new JFXRippler(paneAsistencias);
        ripplerAsistencias.setRipplerFill(Paint.valueOf("#FE81BB"));
        vboxMenu.getChildren().add(ripplerAsistencias);
        Tooltip tooltipAsistencias = new Tooltip("Asistencias");
        Tooltip.install(paneAsistencias, tooltipAsistencias);

        JFXRippler ripplerRJustificantes = new JFXRippler(paneRJustificantes);
        ripplerRJustificantes.setRipplerFill(Paint.valueOf("#FE81BB"));
        vboxMenu.getChildren().add(ripplerRJustificantes);
        Tooltip tooltipRJustificantes = new Tooltip("Tipos de Justificantes");
        Tooltip.install(paneRJustificantes, tooltipRJustificantes);

        JFXRippler ripplerJIncidencias = new JFXRippler(paneJIncidencias);
        ripplerJIncidencias.setRipplerFill(Paint.valueOf("#FE81BB"));
        vboxMenu.getChildren().add(ripplerJIncidencias);

        Tooltip tooltipJIncidencias = new Tooltip("Justificacar Incidencias");
        Tooltip.install(paneJIncidencias, tooltipJIncidencias);


        JFXRippler ripplerAHorario = new JFXRippler(paneAHorario);
        ripplerAHorario.setRipplerFill(Paint.valueOf("#FE81BB"));
        vboxMenu.getChildren().add(ripplerAHorario);

        Tooltip tooltipAHorario = new Tooltip("Asignaciones de Horarios");
        Tooltip.install(paneAHorario, tooltipAHorario);

        JFXRippler ripplerReloj = new JFXRippler(paneReloj);
        ripplerReloj.setRipplerFill(Paint.valueOf("#FFFFFF"));
        vboxMenu.getChildren().add(ripplerReloj);

        JFXRippler ripplerAgregar = new JFXRippler(paneAgregar);
        ripplerAgregar.setRipplerFill(Paint.valueOf("#FF4E10"));
        hBoxPestanyas.getChildren().add(ripplerAgregar);

        JFXRippler ripplerBuscar = new JFXRippler(paneBuscar);
        ripplerBuscar.setRipplerFill(Paint.valueOf("#FF4E10"));
        hBoxPestanyas.getChildren().add(ripplerBuscar);



        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            int h = currentTime.getHour() > 12? currentTime.getHour() - 12 : currentTime.getHour();
            lblHora.setText(h > 9 ? "" + h : "0" + h);
            int m = currentTime.getMinute();
            lblMinutos.setText(m > 9 ? "" + m : "0" + m);
            String meridiano = currentTime.getHour() > 11 ? "PM" : "AM";
            lblMeridian.setText(meridiano);

            LocalDateTime currentDate = LocalDateTime.now();
            String diaSemana;

            switch (String.valueOf(currentDate.getDayOfWeek())){
                case "MONDAY":
                    diaSemana = "Lun.";
                    break;
                case "TUESDAY":
                    diaSemana = "Mar.";
                    break;
                case "WEDNESDAY":
                    diaSemana = "Mie.";
                    break;
                case "THURSDAY":
                    diaSemana = "Jue.";
                    break;
                case "FRIDAY":
                    diaSemana = "Vie.";
                    break;
                case "SATURDAY":
                    diaSemana = "Sab.";
                    break;
                case "SUNDAY":
                    diaSemana = "Dom.";
                    break;
                default:
                    diaSemana = "Non.";
                    break;
            }

            String mes;
            switch(String.valueOf(currentDate.getMonth())){
                case "JANUARY":
                    mes = "Ene.";
                    break;
                case "FEBRUARY":
                    mes = "Feb.";
                    break;
                case "MARCH":
                    mes = "Mar.";
                    break;
                case "APRIL":
                    mes = "Abr.";
                    break;
                case "MAY":
                    mes = "May.";
                    break;
                case "JUNE":
                    mes = "Jun.";
                    break;
                case "JULY":
                    mes = "Jul.";
                    break;
                case "AUGUST":
                    mes = "Ago.";
                    break;
                case "SEPTEMBER":
                    mes = "Sep.";
                    break;
                case "OCTOBER":
                    mes = "Oct.";
                    break;
                case "NOVEMBER":
                    mes = "Nov.";
                    break;
                case "DECEMBER":
                    mes = "Dec.";
                    break;
                default:
                    mes = "Non.";
                    break;
            }

            lblFecha.setText(diaSemana + " " + mes + " " + currentDate.getDayOfMonth());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }
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
    private VBox vboxHorarios;
    @FXML
    private VBox vboxDiasLaborales;
    @FXML
    private VBox vboxRAsistencias;
    @FXML
    private VBox vBoxAHorarios;
    //Finalizan propiedades de pantallas

    //INICIA PROPIEDADES DE HORARIOS
    @FXML
    private JFXTextField txtIdHorarioHorarios;

    @FXML
    private JFXTextField txtDescripcionHorarioHorarios;

    @FXML
    private JFXTextField txtEstatusHorarios;

    private void validacionTextFildHorarios() {
        RequiredFieldValidator validatorClave = new RequiredFieldValidator();
        txtIdHorarioHorarios.getValidators().add(validatorClave);
        txtDescripcionHorarioHorarios.getValidators().add(validatorClave);
        txtEstatusHorarios.getValidators().add(validatorClave);
        validatorClave.setMessage("¡Campo Obligatoro!");
        txtIdHorarioHorarios.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtIdHorarioHorarios.validate();
            }
        });
        txtDescripcionHorarioHorarios.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtDescripcionHorarioHorarios.validate();
            }
        });
        txtEstatusHorarios.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtEstatusHorarios.validate();
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
    private JFXTextField txtClaveRegistroIncidencias;
    @FXML
    private JFXComboBox<String> comboTipoRegistroIncidencias;
    @FXML
    private JFXComboBox<String> comboStatusRegistroIncidencias;

    private void validarTextFieldIncidencias(){
        RequiredFieldValidator validatorClave = new RequiredFieldValidator();
        txtClaveRegistroIncidencias.getValidators().add(validatorClave);
        validatorClave.setMessage("¡Campo Obligatoro!");
        txtClaveRegistroIncidencias.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {

                txtClaveRegistroIncidencias.validate();
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
    @FXML
    private JFXTextField txtMotivoLaborales;
    @FXML
    private JFXComboBox<String> comboStatusDiasLaborables;
    @FXML
    private JFXDatePicker pickerFechaLaborales;

    @FXML
    public void hacerInserccionesDiasNoLaborales(){
        BD_Inserciones Inserciones = new BD_Inserciones();
        String Estatus, fecha =  String.valueOf(pickerFechaLaborales.getValue());
        if (comboStatusDiasLaborables.getValue().equals("Activo")){
            Estatus = "A";
        }
        else{
            Estatus = "I";
        }
        if (Inserciones.hacerIncercionesDiasNoLaborables(connection, fecha, txtMotivoLaborales.getText(), Estatus)){
            System.out.println("Insercion correcta");
        }
        else{
            System.out.println("Insercion incorrecta");
        }
    }

    private void llenarMotivoLaborales(){
        RequiredFieldValidator validatorClave = new RequiredFieldValidator();
        txtMotivoLaborales.getValidators().add(validatorClave);
        validatorClave.setMessage("¡Campo Obligatoro!");
        txtMotivoLaborales.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtMotivoLaborales.validate();
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
        //JFXDialog dialog = new JFXDialog(stackP);
        if  (inserciones.hacerInsercionEmpleado(connection, txtIdEmpleadoREmpleados.getText(), txtNombresREmpleados.getText(),txtApellidoPaternoREmpleados.getText(),txtApellidoMaternoREmpleados.getText(),txtCurpREmpleados.getText(),fecha,txtCalleREmpleados.getText(),txtNumeroExtREmpleados.getText(),txtNumeroIntREmpleados.getText(),txtColoniaREmpleados.getText(),txtCodigoPostalREmpleados.getText(),idEstado,idMunicipio,"A")) {
            System.out.println("Insercion correcta");
            //dialog.setContent(new Label("Insercion Correcta"));
            JOptionPane.showMessageDialog((new JFrame()),"Insercion Correcta");
        }
        else {
            //dialog.setContent(new Label("Insercion Incorrecta"));
            JOptionPane.showMessageDialog((new JFrame()),"Insercion Incorrecta");
        }
        //dialog.show(rootStack);
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
        for (Municipios municipio : municipios) {
            comboMunicipioREmpleados.getItems().add(municipio.getNombre());
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
        txtIdEmpleadoREmpleados.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtIdEmpleadoREmpleados.validate();
            }
        });
        txtCalleREmpleados.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtCalleREmpleados.validate();
            }
        });
        txtColoniaREmpleados.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtColoniaREmpleados.validate();
            }
        });
        txtNombresREmpleados.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtNombresREmpleados.validate();
            }
        });
        txtCurpREmpleados.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtCurpREmpleados.validate();
            }
        });
        txtNumeroExtREmpleados.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtNumeroExtREmpleados.validate();
            }
        });
        txtCodigoPostalREmpleados.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtCodigoPostalREmpleados.validate();
            }
        });
        txtApellidoPaternoREmpleados.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtApellidoPaternoREmpleados.validate();
            }
        });
        txtNumeroIntREmpleados.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtNumeroIntREmpleados.validate();
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
    private JFXDatePicker pickerFechaJustificantes;

    @FXML
    public void guardarJustificantes(){
        BD_Inserciones inserciones = new BD_Inserciones();
        String fecha = String.valueOf(pickerFechaJustificantes.getValue()), estatus;
        if (comboEstatusRJustificantes.getValue().equals("Activo")){
            estatus = "A";
        } else{
            estatus = "I";
        }
        if (inserciones.hacerInsercionJustificantesEmpleados(connection, txtClaveRJustificantes.getText(), fecha, String.valueOf(comboTipoRegistroIncidencias.getValue()), estatus)){
            System.out.println("Insercion correcta");
        } else{
            System.out.println("Insercion incorrecta");
        }
    }

    private void llenarComboboxJustificantes(){
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
        //}
        txtClaveRJustificantes.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtClaveRJustificantes.validate();
            }
        });
        txtNombreRJustificantes.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtNombreRJustificantes.validate();
            }
        });
        txtApellidoPRJustificantes.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                txtApellidoPRJustificantes.validate();
            }
        });
        txtApellidoMRJustificantes.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {

                txtApellidoMRJustificantes.validate();
            }
        });
    }
    // Finaliza propiedades registro de justificantes.

    //Inicias propiedades de configuraciones
    @FXML
    private JFXPasswordField txtPassword;
    @FXML
    public void iniciarConexion(){
        Conexion conexion = new Conexion(txtPassword.getText());
        connection = conexion.getConnection();
        if (connection != null){
            vBoxREmpleados.setDisable(false);
            vboxHorarios.setDisable(false);
            vboxDiasLaborales.setDisable(false);
            vboxRAsistencias.setDisable(false);
            vboxRJustificantes.setDisable(false);
            vBoxAHorarios.setVisible(false);
            vBoxJustificantes.setDisable(false);
        } else {
            vBoxREmpleados.setDisable(true);
            vboxHorarios.setDisable(true);
            vboxDiasLaborales.setDisable(true);
            vboxRAsistencias.setDisable(true);
            vboxRJustificantes.setDisable(true);
            vBoxAHorarios.setVisible(true);
            vBoxJustificantes.setDisable(true);
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
        vBoxAHorarios.setDisable(true);
        vBoxJustificantes.setDisable(true);

        validarTextFieldIncidencias();
        llenarComboboxStatus();
        llenarComboboxIncidencias();
        crearMenuLateral();
        //validacionTextFildHorarios();
        //llenarComboboxJustificantes();
        //validarTXT();
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
        hBoxPestanyas.setVisible(false);
        panePestanyasFondo.setVisible(false);
        lblTitulo.setVisible(false);
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
        vBoxJustificantes.setVisible(false);
        vBoxAHorarios.setVisible(false);

        hBoxPestanyas.setVisible(true);
        panePestanyasFondo.setVisible(true);

        lblTitulo.setText("Empleados");
        lblTitulo.setVisible(true);
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
        vBoxJustificantes.setVisible(false);
        vBoxAHorarios.setVisible(false);

        hBoxPestanyas.setVisible(true);
        panePestanyasFondo.setVisible(true);

        lblTitulo.setText("Horarios");
        lblTitulo.setVisible(true);
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
        hBoxPestanyas.setVisible(true);
        vBoxJustificantes.setVisible(false);
        vBoxAHorarios.setVisible(false);
        panePestanyasFondo.setVisible(true);
        lblTitulo.setText("Días no Laborales");
        lblTitulo.setVisible(true);
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
        hBoxPestanyas.setVisible(true);
        vBoxJustificantes.setVisible(false);
        vBoxAHorarios.setVisible(false);
        panePestanyasFondo.setVisible(true);
        lblTitulo.setText("Asistencias");
        lblTitulo.setVisible(true);
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
        hBoxPestanyas.setVisible(true);
        vBoxAHorarios.setVisible(false);
        vBoxJustificantes.setVisible(false);
        panePestanyasFondo.setVisible(true);
        lblTitulo.setText("Justificantes");
        lblTitulo.setVisible(true);
    }

    @FXML
    public void mostrarAHorarios(){
        vboxHome.setVisible(false);
        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        hBoxPestanyas.setVisible(true);
        vBoxAHorarios.setVisible(true);
        vBoxJustificantes.setVisible(false);
        panePestanyasFondo.setVisible(true);
        lblTitulo.setText("Asignación de Horarios");
        lblTitulo.setVisible(true);
    }

    @FXML
    public void mostrarJustificantes(){
        vboxHome.setVisible(false);
        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        hBoxPestanyas.setVisible(true);
        vBoxAHorarios.setVisible(false);
        vBoxJustificantes.setVisible(true);
        panePestanyasFondo.setVisible(true);
        lblTitulo.setText("Asignación de Horarios");
        lblTitulo.setVisible(true);
    }
}
