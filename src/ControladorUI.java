import com.jfoenix.controls.*;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;
import javax.swing.*;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class ControladorUI {

    private Connection connection;

    private int posicionPantalla;
    //0: Home, 1: Empleados, 2: Horarios, 3: Días no laborales, 4: Asistencias, 5: Justificantes, 6: Justificar Incidencias, 7:Asignación de horarios

    //Inician las propiedades @FXML
    @FXML private Label lblAgregar;
    @FXML private SVGPath svgAgregar;
    @FXML private Label lblBuscar;
    @FXML private SVGPath svgBuscar;
    @FXML private VBox vboxBuscarEmpleados;
    @FXML private JFXButton btnEditarCancelar;
    @FXML private JFXButton btnEliminarGuardar;
    @FXML private VBox vboxEmpleadosBuscarEditar;
    @FXML private VBox vboxEmpleadosBuscarEcontrado;
    @FXML private VBox vboxEmpleadosBuscar;
    @FXML private ImageView imgEmpleadosNoFound;
    @FXML private VBox vboxMenu;
    @FXML private HBox panePestanyasFondo;
    @FXML private VBox vBoxJustificantes;
    @FXML private VBox vboxBuscarHorarios;
    @FXML private VBox vboxLaboralesBuscar;
    @FXML private VBox vboxBuscarJIncidencias;
    @FXML private VBox vBoxAHorariosBuscar;

    @FXML private AnchorPane aHomeEmpleados;
    @FXML private AnchorPane aHomeHorarios;
    @FXML private AnchorPane aHomeLaborales;
    @FXML private AnchorPane aHomeAsistencias;
    @FXML private AnchorPane aHomeJustificantes;
    @FXML private AnchorPane aHomeJIncidencias;
    @FXML private AnchorPane aHomeAHorarios;


    @FXML private HBox hboxHomeUno;
    @FXML private HBox hboxHomeDos;
    @FXML private Pane paneHomeEmpleados;
    @FXML private Pane paneHomeHorarios;
    @FXML private Pane paneHomeLaborales;
    @FXML private Pane paneHomeAsistencias;
    @FXML private Pane paneHomeJustificantes;
    @FXML private Pane paneHomeJIncidencias;
    @FXML private Pane paneHomeAHorarios;
    @FXML private Pane paneAgregar;
    @FXML private Pane paneBuscar;
    @FXML private Pane paneHome;
    @FXML private Pane paneREmpleados;
    @FXML private Pane paneRHorarios;
    @FXML private Pane paneDiasLaborales;
    @FXML private Pane paneAsistencias;
    @FXML private Pane paneRJustificantes;
    @FXML private Pane paneJIncidencias;
    @FXML private Pane paneAHorario;
    @FXML private Pane paneReloj;
    @FXML private Label lblHora;
    @FXML private Label lblMinutos;
    @FXML private Label lblMeridian;
    @FXML private Label lblFecha;
    @FXML private HBox hBoxPestanyas;

    @FXML private VBox vboxPantallas;
    @FXML private VBox vboxHome;
    @FXML private Label lblTitulo;
    @FXML private VBox vBoxREmpleados;
    @FXML private VBox vboxRJustificantes;
    @FXML private VBox vboxHorarios;
    @FXML private VBox vboxDiasLaborales;
    @FXML private VBox vboxRAsistencias;
    @FXML private VBox vBoxAHorarios;
    @FXML private VBox vboxBuscarJustificantes;

    @FXML private JFXTextField txtIdHorarioHorarios;
    @FXML private JFXTextField txtDescripcionHorarioHorarios;
    @FXML private JFXTextField txtEstatusHorarios;

    @FXML private JFXTextField txtMotivoLaborales;
    @FXML private JFXComboBox<String> comboStatusDiasLaborables;
    @FXML private JFXDatePicker pickerFechaLaborales;

    @FXML private JFXTextField txtClaveRegistroIncidencias;
    @FXML private JFXComboBox<String> comboTipoRegistroIncidencias;
    @FXML private JFXComboBox<String> comboStatusRegistroIncidencias;

    @FXML private JFXTextField txtIdEmpleadoREmpleados;
    @FXML private JFXComboBox<String> comboMunicipioREmpleados;
    @FXML private JFXDatePicker pickerFechaREmpleados;
    @FXML private JFXTextField txtNombresREmpleados;
    @FXML private JFXTextField txtCurpREmpleados;
    @FXML private JFXTextField txtNumeroExtREmpleados;
    @FXML private JFXTextField txtCodigoPostalREmpleados;
    @FXML private JFXTextField txtApellidoMaternoREmpleados;
    @FXML private JFXTextField txtCalleREmpleados;
    @FXML private JFXTextField txtColoniaREmpleados;
    @FXML private JFXTextField txtApellidoPaternoREmpleados;
    @FXML private JFXTextField txtNumeroIntREmpleados;
    @FXML private JFXComboBox<String> comboEstadoREmpleados;

    @FXML private JFXComboBox<String> comboTipoRJustificantes;
    @FXML private JFXComboBox<String> comboEstatusRJustificantes;
    @FXML private JFXTextField txtClaveRJustificantes;
    @FXML private JFXTextField txtApellidoMRJustificantes;
    @FXML private JFXTextField txtNombreRJustificantes;
    @FXML private JFXTextField txtApellidoPRJustificantes;
    @FXML private JFXDatePicker pickerFechaJustificantes;

    @FXML private JFXPasswordField txtPassword;
    //Terminan propiedades de @FXML

    //Inician metodos de @FXML
    @FXML public void pestanyasAgregar(){
        lblAgregar.setTextFill(Color.web("#FF4E10"));
        svgAgregar.setFill(Color.web("#FF4E10"));
        lblBuscar.setTextFill(Color.web("#000000"));
        svgBuscar.setFill(Color.web("#000000"));
        switch (posicionPantalla){
            case 1:
                mostrarRegistrosEmpleados();
                break;
            case 2:
                mostrarRegistrosHorarios();
                break;
            case 3:
                mostrarRegistrosDiasLaborales();
                break;
            case 4:
                mostrarRegistrosAsistencias();
                break;
            case 5:
                mostrarJustificantes();
                break;
            case 6:
                mostrarRegistrosJustificantes();
                break;
            case 7:
                mostrarAHorarios();
                break;
        }
    }

    @FXML public void pestanyasBuscar(){
        lblAgregar.setTextFill(Color.web("#000000"));
        svgAgregar.setFill(Color.web("#000000"));
        lblBuscar.setTextFill(Color.web("#FF4E10"));
        svgBuscar.setFill(Color.web("#FF4E10"));
        switch (posicionPantalla){
            case 1:
                mostrarBuscarEmpleados();
                break;
            case 2:
                mostrarBuscarHorarios();
                break;
            case 3:
                mostrarBuscarLaborales();
                break;
            case 5:
                mostrarBuscarJustificantes();
                break;
            case 6:
                mostrarBuscarJIncidencias();
                break;
            case 7:
                mostrarBuscarAHorarios();
                break;

        }
    }



    @FXML private void editarEmpleados(){
        btnEditarCancelar.setText("Cancelar");
        btnEliminarGuardar.setText("Guardar");
        buscarEmpleadosPantalla(true, false, false, false);
    }

    private void buscarEmpleadosPantalla(boolean editar, boolean encontrado, boolean buscar, boolean noFound){
        vboxEmpleadosBuscarEditar.setVisible(editar);
        vboxEmpleadosBuscarEcontrado.setVisible(encontrado);
        vboxEmpleadosBuscar.setVisible(buscar);
        imgEmpleadosNoFound.setVisible(noFound);
    }


    //Inicia propiedades del menú




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

        JFXRippler ripplerBuscar = new JFXRippler(paneBuscar);
        ripplerBuscar.setRipplerFill(Paint.valueOf("#FF4E10"));
        hBoxPestanyas.getChildren().add(ripplerBuscar);

        JFXRippler ripplerAgregar = new JFXRippler(paneAgregar);
        ripplerAgregar.setRipplerFill(Paint.valueOf("#FF4E10"));
        hBoxPestanyas.getChildren().add(ripplerAgregar);

        JFXRippler ripplerHomeEmpleados = new JFXRippler(paneHomeEmpleados);
        ripplerHomeEmpleados.setRipplerFill(Paint.valueOf("#FF4E10"));
        aHomeEmpleados.getChildren().add(ripplerHomeEmpleados);

        JFXRippler ripplerHomeHorarios = new JFXRippler(paneHomeHorarios);
        ripplerHomeHorarios.setRipplerFill(Paint.valueOf("#FF4E10"));
        aHomeHorarios.getChildren().add(ripplerHomeHorarios);

        JFXRippler ripplerHomeLaborales = new JFXRippler(paneHomeLaborales);
        ripplerHomeLaborales.setRipplerFill(Paint.valueOf("#FF4E10"));
        aHomeLaborales.getChildren().add(ripplerHomeLaborales);

        JFXRippler ripplerHomeAsistencias = new JFXRippler(paneHomeAsistencias);
        ripplerHomeAsistencias.setRipplerFill(Paint.valueOf("#FF4E10"));
        aHomeAsistencias.getChildren().add(ripplerHomeAsistencias);

        JFXRippler ripplerHomeJustificantes = new JFXRippler(paneHomeJustificantes);
        ripplerHomeJustificantes.setRipplerFill(Paint.valueOf("#FF4E10"));
        aHomeJustificantes.getChildren().add(ripplerHomeJustificantes);

        JFXRippler ripplerHomeJIncidencias = new JFXRippler(paneHomeJIncidencias);
        ripplerHomeJIncidencias.setRipplerFill(Paint.valueOf("#FF4E10"));
        aHomeJIncidencias.getChildren().add(ripplerHomeJIncidencias);

        JFXRippler ripplerHomeAHorarios = new JFXRippler(paneHomeAHorarios);
        ripplerHomeAHorarios.setRipplerFill(Paint.valueOf("#FF4E10"));
        aHomeAHorarios.getChildren().add(ripplerHomeAHorarios);





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


    //INICIA PROPIEDADES DE HORARIOS


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

    @FXML public void btnGuardarHorariosOnClicked(){
        System.out.println("Guardar");
    }
    //FINALIZA PROPIEDADES DE HORARIOS



    //Inicia propiedades de registro de Incidencias


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


    @FXML public void hacerInserccionesDiasNoLaborales(){
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


    private String idMunicipio;
    private String idEstado;

    @FXML private void asignarIDMunicipio(){
        BD_Consultas consultas = new BD_Consultas();
        idMunicipio = consultas.hacerConsultasMunicipiosID(connection, comboMunicipioREmpleados.getValue());
        System.out.println(idMunicipio);
    }

    @FXML private void hacerRegistroEmpleados(){
        BD_Inserciones inserciones = new BD_Inserciones();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Validaciones validaciones = new Validaciones();
        boolean hacer = true;
        String texto = "";
        if (!validaciones.validarClave(txtIdEmpleadoREmpleados.getText())){
            hacer = false;
            texto = texto + "Clave de empleado invalida\n";
        }
        if (!validaciones.validarNombre(txtNombresREmpleados.getText())){
            hacer = false;
            texto = texto + "Nombre invalido";
        }
        if (!validaciones.validarNombre(txtApellidoPaternoREmpleados.getText())){
            hacer = false;
            texto = texto + "Apellido paterno invalido";
        }
        if (!validaciones.validarNombre(txtApellidoMaternoREmpleados.getText())){
            hacer = false;
            texto = texto + "Apellido materno invalido";
        }
        if (!validaciones.validarNombre(txtCalleREmpleados.getText())){
            hacer = false;
            texto = texto + "Nombre de Calle invalido";
        }
        if (!validaciones.validarNumeroDireccion(txtNumeroExtREmpleados.getText())){
            hacer = false;
            texto = texto + "Número Exterior invalido";
        }
        if (!validaciones.validarNumeroDireccion(txtNumeroIntREmpleados.getText())){
            hacer = false;
            texto = texto + "Número Interior invalido";
        }
        if (!validaciones.validarNombre(txtColoniaREmpleados.getText())){
            hacer = false;
            texto = texto + "Nombre de Colonia invalido";
        }
        if (!validaciones.validarCURP(txtCurpREmpleados.getText())){
            hacer = false;
            texto = texto + "CURP invalido\n";
        }
        if  (inserciones.hacerInsercionEmpleado(connection, txtIdEmpleadoREmpleados.getText(), txtNombresREmpleados.getText(),txtApellidoPaternoREmpleados.getText(),txtApellidoMaternoREmpleados.getText(),txtCurpREmpleados.getText(),dateFormat.format(date),txtCalleREmpleados.getText(),txtNumeroExtREmpleados.getText(),txtNumeroIntREmpleados.getText(),txtColoniaREmpleados.getText(),txtCodigoPostalREmpleados.getText(),idEstado,idMunicipio,"A") && hacer) {
            System.out.println("Insercion correcta");
            limpiarEMpleadosRegistro();
        } else {
            System.out.println(texto);
        }

    }

    @FXML private JFXTextField txtbuscarEmpleado;
    @FXML private Label lblClaveEmpleado;

    @FXML public void buscarEmpleado() {
        BD_Consultas consultas = new BD_Consultas();
        String[] empleado = new String[14];
        if (consultas.buscarEmpleadoEntero(connection, txtbuscarEmpleado.getText())){
            empleado = consultas.getTemporal();
            lblClaveEmpleado.setText(empleado[1]);
            vboxEmpleadosBuscarEcontrado.setVisible(true);
            vboxEmpleadosBuscarEditar.setVisible(false);
            vboxEmpleadosBuscar.setVisible(false);
            imgEmpleadosNoFound.setVisible(false);
        }

    }

    private void limpiarEMpleadosRegistro(){
        txtIdEmpleadoREmpleados.setText("");
        txtNombresREmpleados.setText("");
        txtApellidoPaternoREmpleados.setText("");
        txtApellidoMaternoREmpleados.setText("");
        txtCurpREmpleados.setText("");
        txtCalleREmpleados.setText("");
        txtNumeroExtREmpleados.setText("");
        txtNumeroIntREmpleados.setText("");
        txtColoniaREmpleados.setText("");
        txtCodigoPostalREmpleados.setText("");
        comboEstadoREmpleados.setValue("");
        comboMunicipioREmpleados.getItems().clear();
        comboMunicipioREmpleados.setDisable(true);
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
        System.out.println("1");
        comboMunicipioREmpleados.setDisable(true);
        System.out.println("2");
        BD_Consultas consultas = new BD_Consultas();
        System.out.println("3");
        consultas.hacerConsultasMunicipios(connection, choose);
        System.out.println("4");
        Municipios[] municipios = consultas.getMunicipios();
        System.out.println("5");
        for (Municipios municipio : municipios) {
            System.out.println("6");
            comboMunicipioREmpleados.getItems().add(municipio.getNombre());
            System.out.println("7");
        }
        System.out.println("8");
        comboMunicipioREmpleados.setDisable(false);
        System.out.println("9");
    }


    @FXML public void cargarMunicipios(){
        String listItem = comboEstadoREmpleados.getValue();
        switch (listItem) {
            case "Aguascalientes": //Action for this item
                generarComboMunicipios(1);
                this.idEstado = "1";
                System.out.println("rkjgbergjkbsghkjbrthkbnrth");
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


    @FXML public void guardarJustificantes(){
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

    @FXML public void iniciarConexion(){
        Conexion conexion = new Conexion(txtPassword.getText());
        connection = conexion.getConnection();
        if (connection != null){
            vboxPantallas.setDisable(false);
        } else {
            vboxPantallas.setDisable(true);
        }
    }
    //Finalizan propiedades de configuraciones

    @FXML public void initialize(){
        vboxPantallas.setDisable(true);

        //validarTextFieldIncidencias();
        //llenarComboboxStatus();
        //llenarComboboxIncidencias();
        crearMenuLateral();
        //validacionTextFildHorarios();
        //llenarComboboxJustificantes();
        //validarTXT();
        comboboxEmpleadosEstados();
        validacionTextFieldEmpleados();
        llenarComboboxLaborales();
        llenarMotivoLaborales();

        vBoxREmpleados.setDisable(false);
        vboxHorarios.setDisable(false);
        vboxDiasLaborales.setDisable(false);
        vboxRAsistencias.setDisable(false);
        vBoxJustificantes.setDisable(false);
        //vboxRJustificantes

    }

    @FXML public void mostrarInicio(){
        vboxHome.setVisible(true);
        vboxPantallas.setVisible(false);
        hBoxPestanyas.setVisible(false);
        panePestanyasFondo.setVisible(false);
        lblTitulo.setVisible(false);
    }

    @FXML public void mostrarRegistrosEmpleados(){
        posicionPantalla = 1;
        limpiarEMpleadosRegistro();
        lblAgregar.setTextFill(Color.web("#FF4E10"));
        svgAgregar.setFill(Color.web("#FF4E10"));
        lblBuscar.setTextFill(Color.web("#000000"));
        svgBuscar.setFill(Color.web("#000000"));
        vboxHome.setVisible(false);

        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(true);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        vBoxJustificantes.setVisible(false);
        vBoxAHorarios.setVisible(false);

        vboxBuscarEmpleados.setVisible(false);
        vboxBuscarHorarios.setVisible(false);
        vboxLaboralesBuscar.setVisible(false);
        vboxBuscarJustificantes.setVisible(false);
        vboxBuscarJIncidencias.setVisible(false);
        vBoxAHorariosBuscar.setVisible(false);

        hBoxPestanyas.setVisible(true);
        panePestanyasFondo.setVisible(true);

        lblTitulo.setText("Empleados");
        lblTitulo.setVisible(true);
    }

    @FXML public void mostrarBuscarEmpleados(){
        posicionPantalla = 1;
        lblAgregar.setTextFill(Color.web("#000000"));
        svgAgregar.setFill(Color.web("#000000"));
        lblBuscar.setTextFill(Color.web("#FF4E10"));
        svgBuscar.setFill(Color.web("#FF4E10"));
        vboxHome.setVisible(false);

        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        vBoxJustificantes.setVisible(false);
        vBoxAHorarios.setVisible(false);

        vboxBuscarEmpleados.setVisible(true);
        vboxBuscarHorarios.setVisible(false);
        vboxLaboralesBuscar.setVisible(false);
        vboxBuscarJustificantes.setVisible(false);
        vboxBuscarJIncidencias.setVisible(false);
        vBoxAHorariosBuscar.setVisible(false);

        hBoxPestanyas.setVisible(true);
        panePestanyasFondo.setVisible(true);

        lblTitulo.setText("Empleados");
        lblTitulo.setVisible(true);
    }

    @FXML public void mostrarRegistrosHorarios(){
        posicionPantalla = 2;
        lblAgregar.setTextFill(Color.web("#FF4E10"));
        svgAgregar.setFill(Color.web("#FF4E10"));
        lblBuscar.setTextFill(Color.web("#000000"));
        svgBuscar.setFill(Color.web("#000000"));
        vboxHome.setVisible(false);

        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(true);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        vBoxJustificantes.setVisible(false);
        vBoxAHorarios.setVisible(false);

        vboxBuscarEmpleados.setVisible(false);
        vboxBuscarHorarios.setVisible(false);
        vboxLaboralesBuscar.setVisible(false);
        vboxBuscarJustificantes.setVisible(false);
        vboxBuscarJIncidencias.setVisible(false);
        vBoxAHorariosBuscar.setVisible(false);

        hBoxPestanyas.setVisible(true);
        panePestanyasFondo.setVisible(true);

        lblTitulo.setText("Horarios");
        lblTitulo.setVisible(true);
    }

    @FXML public void mostrarBuscarHorarios(){
        posicionPantalla = 2;
        lblAgregar.setTextFill(Color.web("#000000"));
        svgAgregar.setFill(Color.web("#000000"));
        lblBuscar.setTextFill(Color.web("#FF4E10"));
        svgBuscar.setFill(Color.web("#FF4E10"));
        vboxHome.setVisible(false);

        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        vBoxJustificantes.setVisible(false);
        vBoxAHorarios.setVisible(false);

        vboxBuscarEmpleados.setVisible(false);
        vboxBuscarHorarios.setVisible(true);
        vboxLaboralesBuscar.setVisible(false);
        vboxBuscarJustificantes.setVisible(false);
        vboxBuscarJIncidencias.setVisible(false);
        vBoxAHorariosBuscar.setVisible(false);

        hBoxPestanyas.setVisible(true);
        panePestanyasFondo.setVisible(true);

        lblTitulo.setText("Horarios");
        lblTitulo.setVisible(true);
    }

    @FXML public void mostrarRegistrosDiasLaborales(){
        posicionPantalla = 3;

        lblAgregar.setTextFill(Color.web("#FF4E10"));
        svgAgregar.setFill(Color.web("#FF4E10"));
        lblBuscar.setTextFill(Color.web("#000000"));
        svgBuscar.setFill(Color.web("#000000"));

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

        vboxBuscarEmpleados.setVisible(false);
        vboxBuscarHorarios.setVisible(false);
        vboxLaboralesBuscar.setVisible(false);
        vboxBuscarJustificantes.setVisible(false);
        vboxBuscarJIncidencias.setVisible(false);
        vBoxAHorariosBuscar.setVisible(false);

        panePestanyasFondo.setVisible(true);
        lblTitulo.setText("Días no Laborales");
        lblTitulo.setVisible(true);
    }

    @FXML public void mostrarBuscarLaborales(){
        posicionPantalla = 3;
        lblAgregar.setTextFill(Color.web("#000000"));
        svgAgregar.setFill(Color.web("#000000"));
        lblBuscar.setTextFill(Color.web("#FF4E10"));
        svgBuscar.setFill(Color.web("#FF4E10"));
        vboxHome.setVisible(false);

        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        vBoxJustificantes.setVisible(false);
        vBoxAHorarios.setVisible(false);

        vboxBuscarEmpleados.setVisible(false);
        vboxBuscarHorarios.setVisible(false);
        vboxLaboralesBuscar.setVisible(true);
        vboxBuscarJustificantes.setVisible(false);
        vboxBuscarJIncidencias.setVisible(false);
        vBoxAHorariosBuscar.setVisible(false);

        hBoxPestanyas.setVisible(true);
        panePestanyasFondo.setVisible(true);

        lblTitulo.setText("Días no Laborales");
        lblTitulo.setVisible(true);
    }

    @FXML public void mostrarRegistrosAsistencias(){
        posicionPantalla = 4;
        lblAgregar.setTextFill(Color.web("#FF4E10"));
        svgAgregar.setFill(Color.web("#FF4E10"));
        lblBuscar.setTextFill(Color.web("#000000"));
        svgBuscar.setFill(Color.web("#000000"));
        vboxHome.setVisible(false);
        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(true);
        vboxRJustificantes.setVisible(false);
        hBoxPestanyas.setVisible(false);
        vBoxJustificantes.setVisible(false);
        vBoxAHorarios.setVisible(false);
        panePestanyasFondo.setVisible(false);

        vboxBuscarEmpleados.setVisible(false);
        vboxBuscarHorarios.setVisible(false);
        vboxLaboralesBuscar.setVisible(false);
        vboxBuscarJustificantes.setVisible(false);
        vboxBuscarJIncidencias.setVisible(false);
        vBoxAHorariosBuscar.setVisible(false);

        lblTitulo.setText("Asistencias");
        lblTitulo.setVisible(true);
    }

    @FXML public void mostrarRegistrosJustificantes(){
        posicionPantalla = 6;
        lblAgregar.setTextFill(Color.web("#FF4E10"));
        svgAgregar.setFill(Color.web("#FF4E10"));
        lblBuscar.setTextFill(Color.web("#000000"));
        svgBuscar.setFill(Color.web("#000000"));
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
        lblTitulo.setText("Justificar Incidencias");
        lblTitulo.setVisible(true);
        vboxBuscarEmpleados.setVisible(false);
        vboxBuscarHorarios.setVisible(false);
        vboxLaboralesBuscar.setVisible(false);
        vboxBuscarJustificantes.setVisible(false);
        vboxBuscarJIncidencias.setVisible(false);
        vBoxAHorariosBuscar.setVisible(false);
    }

    @FXML public void mostrarBuscarJIncidencias(){
        posicionPantalla = 6;
        lblAgregar.setTextFill(Color.web("#000000"));
        svgAgregar.setFill(Color.web("#000000"));
        lblBuscar.setTextFill(Color.web("#FF4E10"));
        svgBuscar.setFill(Color.web("#FF4E10"));
        vboxHome.setVisible(false);

        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        vBoxJustificantes.setVisible(false);
        vBoxAHorarios.setVisible(false);

        vboxBuscarEmpleados.setVisible(false);
        vboxBuscarHorarios.setVisible(false);
        vboxLaboralesBuscar.setVisible(false);
        vboxBuscarJustificantes.setVisible(false);
        vboxBuscarJIncidencias.setVisible(true);
        vBoxAHorariosBuscar.setVisible(false);

        hBoxPestanyas.setVisible(true);
        panePestanyasFondo.setVisible(true);

        lblTitulo.setText("Justificar Incidencias");
        lblTitulo.setVisible(true);
    }

    @FXML public void mostrarAHorarios(){
        posicionPantalla = 7;
        lblAgregar.setTextFill(Color.web("#FF4E10"));
        svgAgregar.setFill(Color.web("#FF4E10"));
        lblBuscar.setTextFill(Color.web("#000000"));
        svgBuscar.setFill(Color.web("#000000"));
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
        vboxBuscarEmpleados.setVisible(false);
        vboxBuscarHorarios.setVisible(false);
        vboxLaboralesBuscar.setVisible(false);
        vboxBuscarJustificantes.setVisible(false);
        vboxBuscarJIncidencias.setVisible(false);
        vBoxAHorariosBuscar.setVisible(false);
    }

    @FXML public void mostrarBuscarAHorarios(){
        posicionPantalla = 7;
        lblAgregar.setTextFill(Color.web("#000000"));
        svgAgregar.setFill(Color.web("#000000"));
        lblBuscar.setTextFill(Color.web("#FF4E10"));
        svgBuscar.setFill(Color.web("#FF4E10"));
        vboxHome.setVisible(false);

        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        vBoxJustificantes.setVisible(false);
        vBoxAHorarios.setVisible(false);

        vboxBuscarEmpleados.setVisible(false);
        vboxBuscarHorarios.setVisible(false);
        vboxLaboralesBuscar.setVisible(false);
        vboxBuscarJustificantes.setVisible(false);
        vboxBuscarJIncidencias.setVisible(false);
        vBoxAHorariosBuscar.setVisible(true);

        hBoxPestanyas.setVisible(true);
        panePestanyasFondo.setVisible(true);

        lblTitulo.setText("Asignación de Horarios");
        lblTitulo.setVisible(true);
    }

    @FXML public void mostrarJustificantes(){
        posicionPantalla = 5;
        lblAgregar.setTextFill(Color.web("#FF4E10"));
        svgAgregar.setFill(Color.web("#FF4E10"));
        lblBuscar.setTextFill(Color.web("#000000"));
        svgBuscar.setFill(Color.web("#000000"));
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
        lblTitulo.setText("Justificantes");
        lblTitulo.setVisible(true);
        vboxBuscarEmpleados.setVisible(false);
        vboxBuscarHorarios.setVisible(false);
        vboxLaboralesBuscar.setVisible(false);
        vboxBuscarJustificantes.setVisible(false);
        vboxBuscarJIncidencias.setVisible(false);
        vBoxAHorariosBuscar.setVisible(false);
    }

    @FXML public void mostrarBuscarJustificantes(){
        posicionPantalla = 5;
        lblAgregar.setTextFill(Color.web("#000000"));
        svgAgregar.setFill(Color.web("#000000"));
        lblBuscar.setTextFill(Color.web("#FF4E10"));
        svgBuscar.setFill(Color.web("#FF4E10"));
        vboxHome.setVisible(false);

        vboxPantallas.setVisible(true);
        vBoxREmpleados.setVisible(false);
        vboxHorarios.setVisible(false);
        vboxDiasLaborales.setVisible(false);
        vboxRAsistencias.setVisible(false);
        vboxRJustificantes.setVisible(false);
        vBoxJustificantes.setVisible(false);
        vBoxAHorarios.setVisible(false);

        vboxBuscarEmpleados.setVisible(false);
        vboxBuscarHorarios.setVisible(false);
        vboxLaboralesBuscar.setVisible(false);
        vboxBuscarJustificantes.setVisible(true);
        vboxBuscarJIncidencias.setVisible(false);
        vBoxAHorariosBuscar.setVisible(false);

        hBoxPestanyas.setVisible(true);
        panePestanyasFondo.setVisible(true);

        lblTitulo.setText("Justificantes");
        lblTitulo.setVisible(true);
    }
}
