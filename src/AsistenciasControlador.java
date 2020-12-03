import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;

import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AsistenciasControlador {
    private Tabla Tabla;
    private Desktop escritorio = Desktop.getDesktop();
    @FXML
    private FlowPane main;
    @FXML
    private JFXTreeTableView<Asistencia> tablaRegistroAsistencias;
    private ObservableList<Asistencia> asistenciaObservableList = FXCollections.observableArrayList();
    private JFXTreeTableView<Asistencia> treeView;


    @FXML
    public void initialize() {
        System.out.println("hola putos");


        //this.Tabla = new Tabla(tablaRegistroAsistencias);
        //this.Tabla.asignarTextoTablavacia("Elija Archivo");

        JFXTreeTableColumn<Asistencia, String> claveColumn = new JFXTreeTableColumn<>("clave");
        claveColumn.setPrefWidth(150);
        claveColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Asistencia, String> param) -> {
            if (claveColumn.validateValue(param)) return param.getValue().getValue().claveProperty();
            else return claveColumn.getComputedValue(param);
        });

        JFXTreeTableColumn<Asistencia, String> fechaColumn = new JFXTreeTableColumn<>("Fecha registro");
        fechaColumn.setPrefWidth(150);
        fechaColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Asistencia, String> param) -> {
            if (fechaColumn.validateValue(param)) return param.getValue().getValue().fechaRegistroProperty();
            else return fechaColumn.getComputedValue(param);


        });
        JFXTreeTableColumn<Asistencia, String> BioColumn = new JFXTreeTableColumn<>("Numero bimetrico");
        BioColumn.setPrefWidth(150);
        BioColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Asistencia, String> param) -> {
            if (BioColumn.validateValue(param)) return param.getValue().getValue().numBiometricoProperty();
            else return BioColumn.getComputedValue(param);

        });

        JFXTreeTableColumn<Asistencia, String> statusColumn = new JFXTreeTableColumn<>("estatus registro");
        statusColumn.setPrefWidth(150);
        statusColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Asistencia, String> param) -> {
            if (statusColumn.validateValue(param)) return param.getValue().getValue().StatusRegistroProperty();
            else return statusColumn.getComputedValue(param);

        });

        JFXTreeTableColumn<Asistencia, String> numColumn = new JFXTreeTableColumn<>("numero");
        numColumn.setPrefWidth(150);
        numColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<Asistencia, String> param) -> {
            if (numColumn.validateValue(param)) return param.getValue().getValue().numeroProperty();
            else return numColumn.getComputedValue(param);

        });


        final TreeItem<Asistencia> root = new RecursiveTreeItem<Asistencia>(asistenciaObservableList, RecursiveTreeObject::getChildren);

        this.tablaRegistroAsistencias.setRoot(root);
        this.tablaRegistroAsistencias.setShowRoot(false);
        this.tablaRegistroAsistencias.setEditable(false);

        this.tablaRegistroAsistencias.getColumns().setAll(claveColumn, fechaColumn, BioColumn, statusColumn, numColumn);
        AgregarRenglon(new Asistencia("123456", "2020-12-02", "10", "A", "1"));


    }
    @FXML
    public  void abrirVentana()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("abrir archivo");
        fileChooser.showOpenDialog(new Stage());
        System.out.println(fileChooser.getExtensionFilters());
    }
    public void abrirVentanaa(/*final Stage stage*/) {

        /*FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.showOpenDialog(stage);*/

        final FileChooser abrir = new FileChooser();
        final Button openButtom = new Button("abrir archivo");
        final Button openMultipeButtom = new Button("abrir archivos");
        openButtom.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        File file = abrir.showOpenDialog(new Stage());
                        if (file != null) {
                            openFile(file);
                        }
                    }
                }
        );
        openMultipeButtom.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        List<File> list =
                                abrir.showOpenMultipleDialog(new Stage());
                        if (list != null) {
                            for (File file : list) {
                                openFile(file);
                            }
                        }
                    }
                });


      /*  final GridPane inputGridPane = new GridPane();

        GridPane.setConstraints(openButtom, 0, 0);
        GridPane.setConstraints(openMultipeButtom, 1, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButtom, openMultipeButtom);

        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));

        stage.setScene(new Scene(rootGroup));
        stage.show();*/

    }

    private void openFile(File file) {
        try {
            escritorio.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    FileChooser.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }




    public void AgregarRenglon (Asistencia asistencia)
    {
        this.asistenciaObservableList.add(asistencia);

    }
    public void LimpiarTabla ()
    {
        this.asistenciaObservableList.clear();
    }

    public void RegistrarAsistencia()
    {

    }


}
